import AST.RootNode;
import Assembly.AsmMod;
import Backend.*;
import Backend.RegAlloc;
import Frontend.ASTBuilder;
import Frontend.SemanticChecker;
import Frontend.SymbolCollector;
import Grammars.MxStarParser;
import Grammars.MxStarLexer;
import LLVMIR.Module;
import Util.*;
import Util.error.*;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.Objects;

public class main {
    private static String Semantic = "-fsyntax-only";
    private static String LLVMIR = "-emit-llvm";
    private static String Assembly = "-S";
    private static String Output = "-o";

    public static void main(String[] args) throws Exception{
        boolean SemanticSwitch = false, LLVMIRSwitch = false, AssemblySwtich = false;
        PrintStream os = System.out;
        for (int i = 0; i < args.length; ++i){
            if (args[i].charAt(0) == '-'){
                if (Objects.equals(args[i], Semantic))
                    SemanticSwitch = true;
                else if (Objects.equals(args[i], LLVMIR))
                    LLVMIRSwitch = true;
                else if (Objects.equals(args[i], Assembly))
                    AssemblySwtich = true;
                else if (Objects.equals(args[i], Output))
                    os = new PrintStream(new FileOutputStream(args[i+1]));
            }
        }

        InputStream raw = System.in;
//        InputStream raw = new FileInputStream("test.mx");
        try{
            CharStream input = CharStreams.fromStream(raw);
            MxStarLexer lexer = new MxStarLexer(input);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxStarErrorListener());
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MxStarParser parser = new MxStarParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new MxStarErrorListener());

            ParseTree parseTreeRoot = parser.program();
            ASTBuilder astBuilder = new ASTBuilder();
            RootNode ASTRoot = (RootNode) astBuilder.visit(parseTreeRoot);

            globalScope gScope = new globalScope();
            new SymbolCollector(gScope).visit(ASTRoot);
            new SemanticChecker(gScope).visit(ASTRoot);

            if (!SemanticSwitch) {
                Module topModule = new Module();
                new IRCollector(gScope, topModule).visit(ASTRoot);
                new IRBuilder(gScope, topModule).visit(ASTRoot);
                if (LLVMIRSwitch)
                    new IRPrinter(os).visitModule(topModule);

                AsmMod topAsmMod = new AsmMod();
                new InstrSelector(topAsmMod).visitModule(topModule);
                new RegAlloc(topAsmMod).run();
//                new RegAlloc_naive().visit(topAsmMod);
                if (AssemblySwtich)
                    new AsmPrinter(os).visit(topAsmMod);
            }
        } catch(error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}