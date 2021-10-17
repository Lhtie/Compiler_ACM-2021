// Generated from C:/Users/lhtie/Documents/Repos/Compiler_ACM-2021/src/Grammars\MxStar.g4 by ANTLR 4.9.1
package Grammars;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxStarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MINUS=2, STAR=3, DIV=4, MOD=5, LESS_THAN=6, GREATER_THAN=7, EQUALS=8, 
		GT_EQ=9, LT_EQ=10, NOT_EQ=11, AND_LOG=12, OR_LOG=13, NOT_LOG=14, LEFT_SHIFT=15, 
		RIGHT_SHIFT=16, OR_OP=17, XOR_OP=18, AND_OP=19, NOT_OP=20, ASSIGN=21, 
		PLUS_PLUS=22, MINUS_MINUS=23, DOT=24, COMMA=25, SEMI=26, ARROW=27, OPEN_PAREN=28, 
		CLOSE_PAREN=29, OPEN_BRACK=30, CLOSE_BRACK=31, OPEN_BRACE=32, CLOSE_BRACE=33, 
		INT=34, BOOL=35, STRING=36, NULL=37, VOID=38, IF=39, ELSE=40, FOR=41, 
		WHILE=42, BREAK=43, CONITNUE=44, RETURN=45, NEW=46, CLASS=47, THIS=48, 
		LAMBDA_HEAD=49, BOOL_LITERAL=50, INT_LITERAL=51, STRING_LITERAL=52, IDENTIFIER=53, 
		NEWLINE=54, BlockComment=55, LINE_COMMENT=56, WS=57;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PLUS", "MINUS", "STAR", "DIV", "MOD", "LESS_THAN", "GREATER_THAN", "EQUALS", 
			"GT_EQ", "LT_EQ", "NOT_EQ", "AND_LOG", "OR_LOG", "NOT_LOG", "LEFT_SHIFT", 
			"RIGHT_SHIFT", "OR_OP", "XOR_OP", "AND_OP", "NOT_OP", "ASSIGN", "PLUS_PLUS", 
			"MINUS_MINUS", "DOT", "COMMA", "SEMI", "ARROW", "OPEN_PAREN", "CLOSE_PAREN", 
			"OPEN_BRACK", "CLOSE_BRACK", "OPEN_BRACE", "CLOSE_BRACE", "INT", "BOOL", 
			"STRING", "NULL", "VOID", "TRUE", "FALSE", "IF", "ELSE", "FOR", "WHILE", 
			"BREAK", "CONITNUE", "RETURN", "NEW", "CLASS", "THIS", "LAMBDA_HEAD", 
			"DIGIT", "NON_ZERO_DIGIT", "LETTER_", "SPACE", "ESCAPE_CHAR", "PRINTABLE_CHAR", 
			"BOOL_LITERAL", "INT_LITERAL", "STRING_LITERAL", "IDENTIFIER", "NEWLINE", 
			"BlockComment", "LINE_COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'<'", "'>'", "'=='", "'>='", 
			"'<='", "'!='", "'&&'", "'||'", "'!'", "'<<'", "'>>'", "'|'", "'^'", 
			"'&'", "'~'", "'='", "'++'", "'--'", "'.'", "','", "';'", "'->'", "'('", 
			"')'", "'['", "']'", "'{'", "'}'", "'int'", "'bool'", "'string'", "'null'", 
			"'void'", "'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", 
			"'return'", "'new'", "'class'", "'this'", "'[&]'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PLUS", "MINUS", "STAR", "DIV", "MOD", "LESS_THAN", "GREATER_THAN", 
			"EQUALS", "GT_EQ", "LT_EQ", "NOT_EQ", "AND_LOG", "OR_LOG", "NOT_LOG", 
			"LEFT_SHIFT", "RIGHT_SHIFT", "OR_OP", "XOR_OP", "AND_OP", "NOT_OP", "ASSIGN", 
			"PLUS_PLUS", "MINUS_MINUS", "DOT", "COMMA", "SEMI", "ARROW", "OPEN_PAREN", 
			"CLOSE_PAREN", "OPEN_BRACK", "CLOSE_BRACK", "OPEN_BRACE", "CLOSE_BRACE", 
			"INT", "BOOL", "STRING", "NULL", "VOID", "IF", "ELSE", "FOR", "WHILE", 
			"BREAK", "CONITNUE", "RETURN", "NEW", "CLASS", "THIS", "LAMBDA_HEAD", 
			"BOOL_LITERAL", "INT_LITERAL", "STRING_LITERAL", "IDENTIFIER", "NEWLINE", 
			"BlockComment", "LINE_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public MxStarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MxStar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u018d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%"+
		"\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3"+
		")\3)\3)\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\3"+
		".\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3"+
		"\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\3"+
		"9\39\59\u013e\n9\3:\3:\3;\3;\5;\u0144\n;\3<\3<\7<\u0148\n<\f<\16<\u014b"+
		"\13<\3<\6<\u014e\n<\r<\16<\u014f\5<\u0152\n<\3=\3=\3=\3=\7=\u0158\n=\f"+
		"=\16=\u015b\13=\3=\3=\3>\3>\3>\7>\u0162\n>\f>\16>\u0165\13>\3?\5?\u0168"+
		"\n?\3?\3?\3?\3?\3@\3@\3@\3@\7@\u0172\n@\f@\16@\u0175\13@\3@\3@\3@\3@\3"+
		"@\3A\3A\3A\3A\7A\u0180\nA\fA\16A\u0183\13A\3A\3A\3B\6B\u0188\nB\rB\16"+
		"B\u0189\3B\3B\3\u0173\2C\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O\2Q\2S)U*W+Y,[-]._/a\60c\61"+
		"e\62g\63i\2k\2m\2o\2q\2s\2u\64w\65y\66{\67}8\1779\u0081:\u0083;\3\2\t"+
		"\3\2\62;\3\2\63;\5\2C\\aac|\4\2\f\f^^\6\2\f\f\16\17$$^^\4\2\f\f\17\17"+
		"\4\2\13\13\"\"\2\u0192\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2"+
		"\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2"+
		"\3\u0085\3\2\2\2\5\u0087\3\2\2\2\7\u0089\3\2\2\2\t\u008b\3\2\2\2\13\u008d"+
		"\3\2\2\2\r\u008f\3\2\2\2\17\u0091\3\2\2\2\21\u0093\3\2\2\2\23\u0096\3"+
		"\2\2\2\25\u0099\3\2\2\2\27\u009c\3\2\2\2\31\u009f\3\2\2\2\33\u00a2\3\2"+
		"\2\2\35\u00a5\3\2\2\2\37\u00a7\3\2\2\2!\u00aa\3\2\2\2#\u00ad\3\2\2\2%"+
		"\u00af\3\2\2\2\'\u00b1\3\2\2\2)\u00b3\3\2\2\2+\u00b5\3\2\2\2-\u00b7\3"+
		"\2\2\2/\u00ba\3\2\2\2\61\u00bd\3\2\2\2\63\u00bf\3\2\2\2\65\u00c1\3\2\2"+
		"\2\67\u00c3\3\2\2\29\u00c6\3\2\2\2;\u00c8\3\2\2\2=\u00ca\3\2\2\2?\u00cc"+
		"\3\2\2\2A\u00ce\3\2\2\2C\u00d0\3\2\2\2E\u00d2\3\2\2\2G\u00d6\3\2\2\2I"+
		"\u00db\3\2\2\2K\u00e2\3\2\2\2M\u00e7\3\2\2\2O\u00ec\3\2\2\2Q\u00f1\3\2"+
		"\2\2S\u00f7\3\2\2\2U\u00fa\3\2\2\2W\u00ff\3\2\2\2Y\u0103\3\2\2\2[\u0109"+
		"\3\2\2\2]\u010f\3\2\2\2_\u0118\3\2\2\2a\u011f\3\2\2\2c\u0123\3\2\2\2e"+
		"\u0129\3\2\2\2g\u012e\3\2\2\2i\u0132\3\2\2\2k\u0134\3\2\2\2m\u0136\3\2"+
		"\2\2o\u0138\3\2\2\2q\u013d\3\2\2\2s\u013f\3\2\2\2u\u0143\3\2\2\2w\u0151"+
		"\3\2\2\2y\u0153\3\2\2\2{\u015e\3\2\2\2}\u0167\3\2\2\2\177\u016d\3\2\2"+
		"\2\u0081\u017b\3\2\2\2\u0083\u0187\3\2\2\2\u0085\u0086\7-\2\2\u0086\4"+
		"\3\2\2\2\u0087\u0088\7/\2\2\u0088\6\3\2\2\2\u0089\u008a\7,\2\2\u008a\b"+
		"\3\2\2\2\u008b\u008c\7\61\2\2\u008c\n\3\2\2\2\u008d\u008e\7\'\2\2\u008e"+
		"\f\3\2\2\2\u008f\u0090\7>\2\2\u0090\16\3\2\2\2\u0091\u0092\7@\2\2\u0092"+
		"\20\3\2\2\2\u0093\u0094\7?\2\2\u0094\u0095\7?\2\2\u0095\22\3\2\2\2\u0096"+
		"\u0097\7@\2\2\u0097\u0098\7?\2\2\u0098\24\3\2\2\2\u0099\u009a\7>\2\2\u009a"+
		"\u009b\7?\2\2\u009b\26\3\2\2\2\u009c\u009d\7#\2\2\u009d\u009e\7?\2\2\u009e"+
		"\30\3\2\2\2\u009f\u00a0\7(\2\2\u00a0\u00a1\7(\2\2\u00a1\32\3\2\2\2\u00a2"+
		"\u00a3\7~\2\2\u00a3\u00a4\7~\2\2\u00a4\34\3\2\2\2\u00a5\u00a6\7#\2\2\u00a6"+
		"\36\3\2\2\2\u00a7\u00a8\7>\2\2\u00a8\u00a9\7>\2\2\u00a9 \3\2\2\2\u00aa"+
		"\u00ab\7@\2\2\u00ab\u00ac\7@\2\2\u00ac\"\3\2\2\2\u00ad\u00ae\7~\2\2\u00ae"+
		"$\3\2\2\2\u00af\u00b0\7`\2\2\u00b0&\3\2\2\2\u00b1\u00b2\7(\2\2\u00b2("+
		"\3\2\2\2\u00b3\u00b4\7\u0080\2\2\u00b4*\3\2\2\2\u00b5\u00b6\7?\2\2\u00b6"+
		",\3\2\2\2\u00b7\u00b8\7-\2\2\u00b8\u00b9\7-\2\2\u00b9.\3\2\2\2\u00ba\u00bb"+
		"\7/\2\2\u00bb\u00bc\7/\2\2\u00bc\60\3\2\2\2\u00bd\u00be\7\60\2\2\u00be"+
		"\62\3\2\2\2\u00bf\u00c0\7.\2\2\u00c0\64\3\2\2\2\u00c1\u00c2\7=\2\2\u00c2"+
		"\66\3\2\2\2\u00c3\u00c4\7/\2\2\u00c4\u00c5\7@\2\2\u00c58\3\2\2\2\u00c6"+
		"\u00c7\7*\2\2\u00c7:\3\2\2\2\u00c8\u00c9\7+\2\2\u00c9<\3\2\2\2\u00ca\u00cb"+
		"\7]\2\2\u00cb>\3\2\2\2\u00cc\u00cd\7_\2\2\u00cd@\3\2\2\2\u00ce\u00cf\7"+
		"}\2\2\u00cfB\3\2\2\2\u00d0\u00d1\7\177\2\2\u00d1D\3\2\2\2\u00d2\u00d3"+
		"\7k\2\2\u00d3\u00d4\7p\2\2\u00d4\u00d5\7v\2\2\u00d5F\3\2\2\2\u00d6\u00d7"+
		"\7d\2\2\u00d7\u00d8\7q\2\2\u00d8\u00d9\7q\2\2\u00d9\u00da\7n\2\2\u00da"+
		"H\3\2\2\2\u00db\u00dc\7u\2\2\u00dc\u00dd\7v\2\2\u00dd\u00de\7t\2\2\u00de"+
		"\u00df\7k\2\2\u00df\u00e0\7p\2\2\u00e0\u00e1\7i\2\2\u00e1J\3\2\2\2\u00e2"+
		"\u00e3\7p\2\2\u00e3\u00e4\7w\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6\7n\2\2"+
		"\u00e6L\3\2\2\2\u00e7\u00e8\7x\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea\7k\2"+
		"\2\u00ea\u00eb\7f\2\2\u00ebN\3\2\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee\7"+
		"t\2\2\u00ee\u00ef\7w\2\2\u00ef\u00f0\7g\2\2\u00f0P\3\2\2\2\u00f1\u00f2"+
		"\7h\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f4\7n\2\2\u00f4\u00f5\7u\2\2\u00f5"+
		"\u00f6\7g\2\2\u00f6R\3\2\2\2\u00f7\u00f8\7k\2\2\u00f8\u00f9\7h\2\2\u00f9"+
		"T\3\2\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7n\2\2\u00fc\u00fd\7u\2\2\u00fd"+
		"\u00fe\7g\2\2\u00feV\3\2\2\2\u00ff\u0100\7h\2\2\u0100\u0101\7q\2\2\u0101"+
		"\u0102\7t\2\2\u0102X\3\2\2\2\u0103\u0104\7y\2\2\u0104\u0105\7j\2\2\u0105"+
		"\u0106\7k\2\2\u0106\u0107\7n\2\2\u0107\u0108\7g\2\2\u0108Z\3\2\2\2\u0109"+
		"\u010a\7d\2\2\u010a\u010b\7t\2\2\u010b\u010c\7g\2\2\u010c\u010d\7c\2\2"+
		"\u010d\u010e\7m\2\2\u010e\\\3\2\2\2\u010f\u0110\7e\2\2\u0110\u0111\7q"+
		"\2\2\u0111\u0112\7p\2\2\u0112\u0113\7v\2\2\u0113\u0114\7k\2\2\u0114\u0115"+
		"\7p\2\2\u0115\u0116\7w\2\2\u0116\u0117\7g\2\2\u0117^\3\2\2\2\u0118\u0119"+
		"\7t\2\2\u0119\u011a\7g\2\2\u011a\u011b\7v\2\2\u011b\u011c\7w\2\2\u011c"+
		"\u011d\7t\2\2\u011d\u011e\7p\2\2\u011e`\3\2\2\2\u011f\u0120\7p\2\2\u0120"+
		"\u0121\7g\2\2\u0121\u0122\7y\2\2\u0122b\3\2\2\2\u0123\u0124\7e\2\2\u0124"+
		"\u0125\7n\2\2\u0125\u0126\7c\2\2\u0126\u0127\7u\2\2\u0127\u0128\7u\2\2"+
		"\u0128d\3\2\2\2\u0129\u012a\7v\2\2\u012a\u012b\7j\2\2\u012b\u012c\7k\2"+
		"\2\u012c\u012d\7u\2\2\u012df\3\2\2\2\u012e\u012f\7]\2\2\u012f\u0130\7"+
		"(\2\2\u0130\u0131\7_\2\2\u0131h\3\2\2\2\u0132\u0133\t\2\2\2\u0133j\3\2"+
		"\2\2\u0134\u0135\t\3\2\2\u0135l\3\2\2\2\u0136\u0137\t\4\2\2\u0137n\3\2"+
		"\2\2\u0138\u0139\7\"\2\2\u0139p\3\2\2\2\u013a\u013e\t\5\2\2\u013b\u013c"+
		"\7^\2\2\u013c\u013e\7$\2\2\u013d\u013a\3\2\2\2\u013d\u013b\3\2\2\2\u013e"+
		"r\3\2\2\2\u013f\u0140\n\6\2\2\u0140t\3\2\2\2\u0141\u0144\5O(\2\u0142\u0144"+
		"\5Q)\2\u0143\u0141\3\2\2\2\u0143\u0142\3\2\2\2\u0144v\3\2\2\2\u0145\u0149"+
		"\5k\66\2\u0146\u0148\5i\65\2\u0147\u0146\3\2\2\2\u0148\u014b\3\2\2\2\u0149"+
		"\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u0152\3\2\2\2\u014b\u0149\3\2"+
		"\2\2\u014c\u014e\7\62\2\2\u014d\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f"+
		"\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0152\3\2\2\2\u0151\u0145\3\2"+
		"\2\2\u0151\u014d\3\2\2\2\u0152x\3\2\2\2\u0153\u0159\7$\2\2\u0154\u0158"+
		"\5o8\2\u0155\u0158\5q9\2\u0156\u0158\5s:\2\u0157\u0154\3\2\2\2\u0157\u0155"+
		"\3\2\2\2\u0157\u0156\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u015d\7$"+
		"\2\2\u015dz\3\2\2\2\u015e\u0163\5m\67\2\u015f\u0162\5m\67\2\u0160\u0162"+
		"\5i\65\2\u0161\u015f\3\2\2\2\u0161\u0160\3\2\2\2\u0162\u0165\3\2\2\2\u0163"+
		"\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164|\3\2\2\2\u0165\u0163\3\2\2\2"+
		"\u0166\u0168\7\17\2\2\u0167\u0166\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169"+
		"\3\2\2\2\u0169\u016a\7\f\2\2\u016a\u016b\3\2\2\2\u016b\u016c\b?\2\2\u016c"+
		"~\3\2\2\2\u016d\u016e\7\61\2\2\u016e\u016f\7,\2\2\u016f\u0173\3\2\2\2"+
		"\u0170\u0172\13\2\2\2\u0171\u0170\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0174"+
		"\3\2\2\2\u0173\u0171\3\2\2\2\u0174\u0176\3\2\2\2\u0175\u0173\3\2\2\2\u0176"+
		"\u0177\7,\2\2\u0177\u0178\7\61\2\2\u0178\u0179\3\2\2\2\u0179\u017a\b@"+
		"\2\2\u017a\u0080\3\2\2\2\u017b\u017c\7\61\2\2\u017c\u017d\7\61\2\2\u017d"+
		"\u0181\3\2\2\2\u017e\u0180\n\7\2\2\u017f\u017e\3\2\2\2\u0180\u0183\3\2"+
		"\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0184\3\2\2\2\u0183"+
		"\u0181\3\2\2\2\u0184\u0185\bA\2\2\u0185\u0082\3\2\2\2\u0186\u0188\t\b"+
		"\2\2\u0187\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u0187\3\2\2\2\u0189"+
		"\u018a\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\bB\2\2\u018c\u0084\3\2"+
		"\2\2\20\2\u013d\u0143\u0149\u014f\u0151\u0157\u0159\u0161\u0163\u0167"+
		"\u0173\u0181\u0189\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}