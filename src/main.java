import grammars.MxStarParser;
import grammars.MxStarLexer;
import grammars.MxStarVisitor;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class main {
    public static void main(String[] args) throws Exception{
        String name = "test.mx";
        InputStream raw = new FileInputStream(name);
        try{
            CharStream input = CharStreams.fromStream(raw);
            MxStarLexer lexer = new MxStarLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MxStarParser parser = new MxStarParser(tokens);
            ParseTree parseTreeRoot = parser.program();

        } catch(error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}