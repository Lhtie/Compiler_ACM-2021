// Generated from C:/Users/lhtie/Documents/Repos/Compiler_ACM-2022/src/grammars-antlr4\MxStar.g4 by ANTLR 4.9.1
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
		ADD=1, MINUS=2, STAR=3, DIV=4, MOD=5, LESS_THAN=6, GREATER_THAN=7, EQUALS=8, 
		GT_EQ=9, LT_EQ=10, NOT_EQ=11, AND_LOG=12, OR_LOG=13, NOT_LOG=14, LEFT_SHIFT=15, 
		RIGHT_SHIFT=16, OR_OP=17, XOR_OP=18, AND_OP=19, NOT_OP=20, ASSIGN=21, 
		PLUS_PLUS=22, MINUS_MINUS=23, DOT=24, COMMA=25, SEMI=26, ARROW=27, OPEN_PAREN=28, 
		CLOSE_PAREN=29, OPEN_BRACK=30, CLOSE_BRACK=31, OPEN_BRACE=32, CLOSE_BRACE=33, 
		INT=34, BOOL=35, STRING=36, NULL=37, VOID=38, IF=39, ELSE=40, FOR=41, 
		WHILE=42, BREAK=43, CONITNUE=44, RETURN=45, NEW=46, CLASS=47, THIS=48, 
		MAIN=49, LAMBDA_HEAD=50, BOOL_LITERAL=51, INT_LITERAL=52, STRING_LITERAL=53, 
		IDENTIFIER=54, NEWLINE=55, BlockComment=56, LINE_COMMENT=57, WS=58;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ADD", "MINUS", "STAR", "DIV", "MOD", "LESS_THAN", "GREATER_THAN", "EQUALS", 
			"GT_EQ", "LT_EQ", "NOT_EQ", "AND_LOG", "OR_LOG", "NOT_LOG", "LEFT_SHIFT", 
			"RIGHT_SHIFT", "OR_OP", "XOR_OP", "AND_OP", "NOT_OP", "ASSIGN", "PLUS_PLUS", 
			"MINUS_MINUS", "DOT", "COMMA", "SEMI", "ARROW", "OPEN_PAREN", "CLOSE_PAREN", 
			"OPEN_BRACK", "CLOSE_BRACK", "OPEN_BRACE", "CLOSE_BRACE", "INT", "BOOL", 
			"STRING", "NULL", "VOID", "TRUE", "FALSE", "IF", "ELSE", "FOR", "WHILE", 
			"BREAK", "CONITNUE", "RETURN", "NEW", "CLASS", "THIS", "MAIN", "LAMBDA_HEAD", 
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
			"'return'", "'new'", "'class'", "'this'", "'main()'", "'[&]'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADD", "MINUS", "STAR", "DIV", "MOD", "LESS_THAN", "GREATER_THAN", 
			"EQUALS", "GT_EQ", "LT_EQ", "NOT_EQ", "AND_LOG", "OR_LOG", "NOT_LOG", 
			"LEFT_SHIFT", "RIGHT_SHIFT", "OR_OP", "XOR_OP", "AND_OP", "NOT_OP", "ASSIGN", 
			"PLUS_PLUS", "MINUS_MINUS", "DOT", "COMMA", "SEMI", "ARROW", "OPEN_PAREN", 
			"CLOSE_PAREN", "OPEN_BRACK", "CLOSE_BRACK", "OPEN_BRACE", "CLOSE_BRACE", 
			"INT", "BOOL", "STRING", "NULL", "VOID", "IF", "ELSE", "FOR", "WHILE", 
			"BREAK", "CONITNUE", "RETURN", "NEW", "CLASS", "THIS", "MAIN", "LAMBDA_HEAD", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2<\u0196\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3"+
		"%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)"+
		"\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3."+
		"\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3"+
		"\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3"+
		"\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3:\5:\u0147\n:\3;\3;\3<\3<\5<\u014d"+
		"\n<\3=\3=\7=\u0151\n=\f=\16=\u0154\13=\3=\6=\u0157\n=\r=\16=\u0158\5="+
		"\u015b\n=\3>\3>\3>\3>\7>\u0161\n>\f>\16>\u0164\13>\3>\3>\3?\3?\3?\7?\u016b"+
		"\n?\f?\16?\u016e\13?\3@\5@\u0171\n@\3@\3@\3@\3@\3A\3A\3A\3A\7A\u017b\n"+
		"A\fA\16A\u017e\13A\3A\3A\3A\3A\3A\3B\3B\3B\3B\7B\u0189\nB\fB\16B\u018c"+
		"\13B\3B\3B\3C\6C\u0191\nC\rC\16C\u0192\3C\3C\3\u017c\2D\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O\2Q\2S)U*W+Y,[-]._/a\60c\61e\62g\63i\64k\2m\2o\2q\2s\2u\2w\65"+
		"y\66{\67}8\1779\u0081:\u0083;\u0085<\3\2\t\3\2\62;\3\2\63;\5\2C\\aac|"+
		"\4\2\f\f^^\6\2\f\f\16\17$$^^\4\2\f\f\17\17\4\2\13\13\"\"\2\u019b\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\3\u0087\3\2\2"+
		"\2\5\u0089\3\2\2\2\7\u008b\3\2\2\2\t\u008d\3\2\2\2\13\u008f\3\2\2\2\r"+
		"\u0091\3\2\2\2\17\u0093\3\2\2\2\21\u0095\3\2\2\2\23\u0098\3\2\2\2\25\u009b"+
		"\3\2\2\2\27\u009e\3\2\2\2\31\u00a1\3\2\2\2\33\u00a4\3\2\2\2\35\u00a7\3"+
		"\2\2\2\37\u00a9\3\2\2\2!\u00ac\3\2\2\2#\u00af\3\2\2\2%\u00b1\3\2\2\2\'"+
		"\u00b3\3\2\2\2)\u00b5\3\2\2\2+\u00b7\3\2\2\2-\u00b9\3\2\2\2/\u00bc\3\2"+
		"\2\2\61\u00bf\3\2\2\2\63\u00c1\3\2\2\2\65\u00c3\3\2\2\2\67\u00c5\3\2\2"+
		"\29\u00c8\3\2\2\2;\u00ca\3\2\2\2=\u00cc\3\2\2\2?\u00ce\3\2\2\2A\u00d0"+
		"\3\2\2\2C\u00d2\3\2\2\2E\u00d4\3\2\2\2G\u00d8\3\2\2\2I\u00dd\3\2\2\2K"+
		"\u00e4\3\2\2\2M\u00e9\3\2\2\2O\u00ee\3\2\2\2Q\u00f3\3\2\2\2S\u00f9\3\2"+
		"\2\2U\u00fc\3\2\2\2W\u0101\3\2\2\2Y\u0105\3\2\2\2[\u010b\3\2\2\2]\u0111"+
		"\3\2\2\2_\u011a\3\2\2\2a\u0121\3\2\2\2c\u0125\3\2\2\2e\u012b\3\2\2\2g"+
		"\u0130\3\2\2\2i\u0137\3\2\2\2k\u013b\3\2\2\2m\u013d\3\2\2\2o\u013f\3\2"+
		"\2\2q\u0141\3\2\2\2s\u0146\3\2\2\2u\u0148\3\2\2\2w\u014c\3\2\2\2y\u015a"+
		"\3\2\2\2{\u015c\3\2\2\2}\u0167\3\2\2\2\177\u0170\3\2\2\2\u0081\u0176\3"+
		"\2\2\2\u0083\u0184\3\2\2\2\u0085\u0190\3\2\2\2\u0087\u0088\7-\2\2\u0088"+
		"\4\3\2\2\2\u0089\u008a\7/\2\2\u008a\6\3\2\2\2\u008b\u008c\7,\2\2\u008c"+
		"\b\3\2\2\2\u008d\u008e\7\61\2\2\u008e\n\3\2\2\2\u008f\u0090\7\'\2\2\u0090"+
		"\f\3\2\2\2\u0091\u0092\7>\2\2\u0092\16\3\2\2\2\u0093\u0094\7@\2\2\u0094"+
		"\20\3\2\2\2\u0095\u0096\7?\2\2\u0096\u0097\7?\2\2\u0097\22\3\2\2\2\u0098"+
		"\u0099\7@\2\2\u0099\u009a\7?\2\2\u009a\24\3\2\2\2\u009b\u009c\7>\2\2\u009c"+
		"\u009d\7?\2\2\u009d\26\3\2\2\2\u009e\u009f\7#\2\2\u009f\u00a0\7?\2\2\u00a0"+
		"\30\3\2\2\2\u00a1\u00a2\7(\2\2\u00a2\u00a3\7(\2\2\u00a3\32\3\2\2\2\u00a4"+
		"\u00a5\7~\2\2\u00a5\u00a6\7~\2\2\u00a6\34\3\2\2\2\u00a7\u00a8\7#\2\2\u00a8"+
		"\36\3\2\2\2\u00a9\u00aa\7>\2\2\u00aa\u00ab\7>\2\2\u00ab \3\2\2\2\u00ac"+
		"\u00ad\7@\2\2\u00ad\u00ae\7@\2\2\u00ae\"\3\2\2\2\u00af\u00b0\7~\2\2\u00b0"+
		"$\3\2\2\2\u00b1\u00b2\7`\2\2\u00b2&\3\2\2\2\u00b3\u00b4\7(\2\2\u00b4("+
		"\3\2\2\2\u00b5\u00b6\7\u0080\2\2\u00b6*\3\2\2\2\u00b7\u00b8\7?\2\2\u00b8"+
		",\3\2\2\2\u00b9\u00ba\7-\2\2\u00ba\u00bb\7-\2\2\u00bb.\3\2\2\2\u00bc\u00bd"+
		"\7/\2\2\u00bd\u00be\7/\2\2\u00be\60\3\2\2\2\u00bf\u00c0\7\60\2\2\u00c0"+
		"\62\3\2\2\2\u00c1\u00c2\7.\2\2\u00c2\64\3\2\2\2\u00c3\u00c4\7=\2\2\u00c4"+
		"\66\3\2\2\2\u00c5\u00c6\7/\2\2\u00c6\u00c7\7@\2\2\u00c78\3\2\2\2\u00c8"+
		"\u00c9\7*\2\2\u00c9:\3\2\2\2\u00ca\u00cb\7+\2\2\u00cb<\3\2\2\2\u00cc\u00cd"+
		"\7]\2\2\u00cd>\3\2\2\2\u00ce\u00cf\7_\2\2\u00cf@\3\2\2\2\u00d0\u00d1\7"+
		"}\2\2\u00d1B\3\2\2\2\u00d2\u00d3\7\177\2\2\u00d3D\3\2\2\2\u00d4\u00d5"+
		"\7k\2\2\u00d5\u00d6\7p\2\2\u00d6\u00d7\7v\2\2\u00d7F\3\2\2\2\u00d8\u00d9"+
		"\7d\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7q\2\2\u00db\u00dc\7n\2\2\u00dc"+
		"H\3\2\2\2\u00dd\u00de\7u\2\2\u00de\u00df\7v\2\2\u00df\u00e0\7t\2\2\u00e0"+
		"\u00e1\7k\2\2\u00e1\u00e2\7p\2\2\u00e2\u00e3\7i\2\2\u00e3J\3\2\2\2\u00e4"+
		"\u00e5\7p\2\2\u00e5\u00e6\7w\2\2\u00e6\u00e7\7n\2\2\u00e7\u00e8\7n\2\2"+
		"\u00e8L\3\2\2\2\u00e9\u00ea\7x\2\2\u00ea\u00eb\7q\2\2\u00eb\u00ec\7k\2"+
		"\2\u00ec\u00ed\7f\2\2\u00edN\3\2\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7"+
		"t\2\2\u00f0\u00f1\7w\2\2\u00f1\u00f2\7g\2\2\u00f2P\3\2\2\2\u00f3\u00f4"+
		"\7h\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7n\2\2\u00f6\u00f7\7u\2\2\u00f7"+
		"\u00f8\7g\2\2\u00f8R\3\2\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7h\2\2\u00fb"+
		"T\3\2\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe\7n\2\2\u00fe\u00ff\7u\2\2\u00ff"+
		"\u0100\7g\2\2\u0100V\3\2\2\2\u0101\u0102\7h\2\2\u0102\u0103\7q\2\2\u0103"+
		"\u0104\7t\2\2\u0104X\3\2\2\2\u0105\u0106\7y\2\2\u0106\u0107\7j\2\2\u0107"+
		"\u0108\7k\2\2\u0108\u0109\7n\2\2\u0109\u010a\7g\2\2\u010aZ\3\2\2\2\u010b"+
		"\u010c\7d\2\2\u010c\u010d\7t\2\2\u010d\u010e\7g\2\2\u010e\u010f\7c\2\2"+
		"\u010f\u0110\7m\2\2\u0110\\\3\2\2\2\u0111\u0112\7e\2\2\u0112\u0113\7q"+
		"\2\2\u0113\u0114\7p\2\2\u0114\u0115\7v\2\2\u0115\u0116\7k\2\2\u0116\u0117"+
		"\7p\2\2\u0117\u0118\7w\2\2\u0118\u0119\7g\2\2\u0119^\3\2\2\2\u011a\u011b"+
		"\7t\2\2\u011b\u011c\7g\2\2\u011c\u011d\7v\2\2\u011d\u011e\7w\2\2\u011e"+
		"\u011f\7t\2\2\u011f\u0120\7p\2\2\u0120`\3\2\2\2\u0121\u0122\7p\2\2\u0122"+
		"\u0123\7g\2\2\u0123\u0124\7y\2\2\u0124b\3\2\2\2\u0125\u0126\7e\2\2\u0126"+
		"\u0127\7n\2\2\u0127\u0128\7c\2\2\u0128\u0129\7u\2\2\u0129\u012a\7u\2\2"+
		"\u012ad\3\2\2\2\u012b\u012c\7v\2\2\u012c\u012d\7j\2\2\u012d\u012e\7k\2"+
		"\2\u012e\u012f\7u\2\2\u012ff\3\2\2\2\u0130\u0131\7o\2\2\u0131\u0132\7"+
		"c\2\2\u0132\u0133\7k\2\2\u0133\u0134\7p\2\2\u0134\u0135\7*\2\2\u0135\u0136"+
		"\7+\2\2\u0136h\3\2\2\2\u0137\u0138\7]\2\2\u0138\u0139\7(\2\2\u0139\u013a"+
		"\7_\2\2\u013aj\3\2\2\2\u013b\u013c\t\2\2\2\u013cl\3\2\2\2\u013d\u013e"+
		"\t\3\2\2\u013en\3\2\2\2\u013f\u0140\t\4\2\2\u0140p\3\2\2\2\u0141\u0142"+
		"\7\"\2\2\u0142r\3\2\2\2\u0143\u0147\t\5\2\2\u0144\u0145\7^\2\2\u0145\u0147"+
		"\7$\2\2\u0146\u0143\3\2\2\2\u0146\u0144\3\2\2\2\u0147t\3\2\2\2\u0148\u0149"+
		"\n\6\2\2\u0149v\3\2\2\2\u014a\u014d\5O(\2\u014b\u014d\5Q)\2\u014c\u014a"+
		"\3\2\2\2\u014c\u014b\3\2\2\2\u014dx\3\2\2\2\u014e\u0152\5m\67\2\u014f"+
		"\u0151\5k\66\2\u0150\u014f\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2"+
		"\2\2\u0152\u0153\3\2\2\2\u0153\u015b\3\2\2\2\u0154\u0152\3\2\2\2\u0155"+
		"\u0157\7\62\2\2\u0156\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0156\3"+
		"\2\2\2\u0158\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u014e\3\2\2\2\u015a"+
		"\u0156\3\2\2\2\u015bz\3\2\2\2\u015c\u0162\7$\2\2\u015d\u0161\5q9\2\u015e"+
		"\u0161\5s:\2\u015f\u0161\5u;\2\u0160\u015d\3\2\2\2\u0160\u015e\3\2\2\2"+
		"\u0160\u015f\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163"+
		"\3\2\2\2\u0163\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0166\7$\2\2\u0166"+
		"|\3\2\2\2\u0167\u016c\5o8\2\u0168\u016b\5o8\2\u0169\u016b\5k\66\2\u016a"+
		"\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2"+
		"\2\2\u016c\u016d\3\2\2\2\u016d~\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0171"+
		"\7\17\2\2\u0170\u016f\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\3\2\2\2"+
		"\u0172\u0173\7\f\2\2\u0173\u0174\3\2\2\2\u0174\u0175\b@\2\2\u0175\u0080"+
		"\3\2\2\2\u0176\u0177\7\61\2\2\u0177\u0178\7,\2\2\u0178\u017c\3\2\2\2\u0179"+
		"\u017b\13\2\2\2\u017a\u0179\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017d\3"+
		"\2\2\2\u017c\u017a\3\2\2\2\u017d\u017f\3\2\2\2\u017e\u017c\3\2\2\2\u017f"+
		"\u0180\7,\2\2\u0180\u0181\7\61\2\2\u0181\u0182\3\2\2\2\u0182\u0183\bA"+
		"\2\2\u0183\u0082\3\2\2\2\u0184\u0185\7\61\2\2\u0185\u0186\7\61\2\2\u0186"+
		"\u018a\3\2\2\2\u0187\u0189\n\7\2\2\u0188\u0187\3\2\2\2\u0189\u018c\3\2"+
		"\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018d\3\2\2\2\u018c"+
		"\u018a\3\2\2\2\u018d\u018e\bB\2\2\u018e\u0084\3\2\2\2\u018f\u0191\t\b"+
		"\2\2\u0190\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0190\3\2\2\2\u0192"+
		"\u0193\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\bC\2\2\u0195\u0086\3\2"+
		"\2\2\20\2\u0146\u014c\u0152\u0158\u015a\u0160\u0162\u016a\u016c\u0170"+
		"\u017c\u018a\u0192\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}