import AST.RootNode;
import Assembly.AsmMod;
import Backend.*;
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

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

public class main {
    private static String Semantic = "-fsyntax-only";
    private static String LLVMIR = "-emit-llvm";
    private static String Assembly = "-S";

    public static void main(String[] args) throws Exception{
        boolean SemanticSwitch = false, LLVMIRSwitch = false, AssemblySwtich = false;
        for (int i = 0; i < args.length; ++i){
            if (args[i].charAt(0) == '-'){
                if (Objects.equals(args[i], Semantic))
                    SemanticSwitch = true;
                else if (Objects.equals(args[i], LLVMIR))
                    LLVMIRSwitch = true;
                else if (Objects.equals(args[i], Assembly))
                    AssemblySwtich = true;
            }
        }

        String name = "test.mx";
        InputStream raw = System.in;
//        InputStream raw = new FileInputStream(name);
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
                    new IRPrinter(System.out).visitModule(topModule);

                AsmMod topAsmMod = new AsmMod();
                new InstrSelector(topAsmMod).visitModule(topModule);
                new RegAlloc().visit(topAsmMod);
                if (AssemblySwtich)
                    new AsmPrinter(System.out).visit(topAsmMod);
            }
        } catch(error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}