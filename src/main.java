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

public class main {
    public static void main(String[] args) throws Exception{
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

            Module topModule = new Module();
            new IRCollector(gScope, topModule).visit(ASTRoot);
            new IRBuilder(gScope, topModule).visit(ASTRoot);
//            new IRPrinter(System.out).visitModule(topModule);

            AsmMod topAsmMod = new AsmMod();
            new InstrSelector(topAsmMod).visitModule(topModule);
            new RegAlloc().visit(topAsmMod);
            new AsmPrinter(System.out).visit(topAsmMod);
        } catch(error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}