// Generated from C:/Users/lhtie/Documents/Repos/Compiler_ACM-2022/src/grammars-antlr4\MxStar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxStarParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_define = 1, RULE_class_def = 2, RULE_constructor_def = 3, 
		RULE_main_suite = 4, RULE_var_def_stmt = 5, RULE_var_def = 6, RULE_var_def_arg = 7, 
		RULE_func_def = 8, RULE_basic_type = 9, RULE_type = 10, RULE_func_type = 11, 
		RULE_parameter_list = 12, RULE_parameter = 13, RULE_suite = 14, RULE_stmt = 15, 
		RULE_if_stmt = 16, RULE_loop_stmt = 17, RULE_while_stmt = 18, RULE_for_stmt = 19, 
		RULE_flow_stmt = 20, RULE_expr_stmt = 21, RULE_expr = 22, RULE_arg_list = 23, 
		RULE_creator = 24, RULE_lambda_stmt = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "define", "class_def", "constructor_def", "main_suite", "var_def_stmt", 
			"var_def", "var_def_arg", "func_def", "basic_type", "type", "func_type", 
			"parameter_list", "parameter", "suite", "stmt", "if_stmt", "loop_stmt", 
			"while_stmt", "for_stmt", "flow_stmt", "expr_stmt", "expr", "arg_list", 
			"creator", "lambda_stmt"
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

	@Override
	public String getGrammarFileName() { return "MxStar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxStarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Main_suiteContext main_suite() {
			return getRuleContext(Main_suiteContext.class,0);
		}
		public List<DefineContext> define() {
			return getRuleContexts(DefineContext.class);
		}
		public DefineContext define(int i) {
			return getRuleContext(DefineContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(52);
					define();
					}
					} 
				}
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(58);
			main_suite();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << VOID) | (1L << CLASS) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(59);
				define();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineContext extends ParserRuleContext {
		public Class_defContext class_def() {
			return getRuleContext(Class_defContext.class,0);
		}
		public Func_defContext func_def() {
			return getRuleContext(Func_defContext.class,0);
		}
		public Var_def_stmtContext var_def_stmt() {
			return getRuleContext(Var_def_stmtContext.class,0);
		}
		public DefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineContext define() throws RecognitionException {
		DefineContext _localctx = new DefineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_define);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				class_def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				func_def();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				var_def_stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_defContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(MxStarParser.CLASS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MxStarParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(MxStarParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(MxStarParser.CLOSE_BRACE, 0); }
		public TerminalNode SEMI() { return getToken(MxStarParser.SEMI, 0); }
		public Constructor_defContext constructor_def() {
			return getRuleContext(Constructor_defContext.class,0);
		}
		public List<Var_def_stmtContext> var_def_stmt() {
			return getRuleContexts(Var_def_stmtContext.class);
		}
		public Var_def_stmtContext var_def_stmt(int i) {
			return getRuleContext(Var_def_stmtContext.class,i);
		}
		public List<Func_defContext> func_def() {
			return getRuleContexts(Func_defContext.class);
		}
		public Func_defContext func_def(int i) {
			return getRuleContext(Func_defContext.class,i);
		}
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterClass_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitClass_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitClass_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(CLASS);
			setState(71);
			match(IDENTIFIER);
			setState(72);
			match(OPEN_BRACE);
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(73);
				constructor_def();
				}
				break;
			}
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << VOID) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(78);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(76);
					var_def_stmt();
					}
					break;
				case 2:
					{
					setState(77);
					func_def();
					}
					break;
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			match(CLOSE_BRACE);
			setState(84);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constructor_defContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MxStarParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(MxStarParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(MxStarParser.CLOSE_PAREN, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public Constructor_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterConstructor_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitConstructor_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitConstructor_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constructor_defContext constructor_def() throws RecognitionException {
		Constructor_defContext _localctx = new Constructor_defContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constructor_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(IDENTIFIER);
			setState(87);
			match(OPEN_PAREN);
			setState(88);
			match(CLOSE_PAREN);
			setState(89);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Main_suiteContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MxStarParser.INT, 0); }
		public TerminalNode MAIN() { return getToken(MxStarParser.MAIN, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public Main_suiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterMain_suite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitMain_suite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitMain_suite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Main_suiteContext main_suite() throws RecognitionException {
		Main_suiteContext _localctx = new Main_suiteContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_main_suite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(INT);
			setState(92);
			match(MAIN);
			setState(93);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_def_stmtContext extends ParserRuleContext {
		public Var_defContext var_def() {
			return getRuleContext(Var_defContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MxStarParser.SEMI, 0); }
		public Var_def_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_def_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVar_def_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVar_def_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVar_def_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_def_stmtContext var_def_stmt() throws RecognitionException {
		Var_def_stmtContext _localctx = new Var_def_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_var_def_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			var_def();
			setState(96);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_defContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<Var_def_argContext> var_def_arg() {
			return getRuleContexts(Var_def_argContext.class);
		}
		public Var_def_argContext var_def_arg(int i) {
			return getRuleContext(Var_def_argContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MxStarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MxStarParser.COMMA, i);
		}
		public Var_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVar_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVar_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVar_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_defContext var_def() throws RecognitionException {
		Var_defContext _localctx = new Var_defContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			type(0);
			setState(99);
			var_def_arg();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(100);
				match(COMMA);
				setState(101);
				var_def_arg();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_def_argContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MxStarParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(MxStarParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Var_def_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_def_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVar_def_arg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVar_def_arg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVar_def_arg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_def_argContext var_def_arg() throws RecognitionException {
		Var_def_argContext _localctx = new Var_def_argContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_def_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(IDENTIFIER);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(108);
				match(ASSIGN);
				setState(109);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_defContext extends ParserRuleContext {
		public Func_typeContext func_type() {
			return getRuleContext(Func_typeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MxStarParser.IDENTIFIER, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public Func_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFunc_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFunc_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFunc_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_defContext func_def() throws RecognitionException {
		Func_defContext _localctx = new Func_defContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_func_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			func_type();
			setState(113);
			match(IDENTIFIER);
			setState(114);
			parameter_list();
			setState(115);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Basic_typeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(MxStarParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(MxStarParser.INT, 0); }
		public TerminalNode VOID() { return getToken(MxStarParser.VOID, 0); }
		public TerminalNode STRING() { return getToken(MxStarParser.STRING, 0); }
		public Basic_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBasic_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBasic_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBasic_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Basic_typeContext basic_type() throws RecognitionException {
		Basic_typeContext _localctx = new Basic_typeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_basic_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << VOID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MxStarParser.IDENTIFIER, 0); }
		public Basic_typeContext basic_type() {
			return getRuleContext(Basic_typeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode OPEN_BRACK() { return getToken(MxStarParser.OPEN_BRACK, 0); }
		public TerminalNode CLOSE_BRACK() { return getToken(MxStarParser.CLOSE_BRACK, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(120);
				match(IDENTIFIER);
				}
				break;
			case INT:
			case BOOL:
			case STRING:
			case VOID:
				{
				setState(121);
				basic_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(124);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(125);
					match(OPEN_BRACK);
					setState(126);
					match(CLOSE_BRACK);
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Func_typeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(MxStarParser.VOID, 0); }
		public Func_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFunc_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFunc_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFunc_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_typeContext func_type() throws RecognitionException {
		Func_typeContext _localctx = new Func_typeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_func_type);
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				type(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				match(VOID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_listContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(MxStarParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(MxStarParser.CLOSE_PAREN, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MxStarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MxStarParser.COMMA, i);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterParameter_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitParameter_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitParameter_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(OPEN_PAREN);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << VOID) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(137);
				parameter();
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(138);
					match(COMMA);
					setState(139);
					parameter();
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(147);
			match(CLOSE_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MxStarParser.IDENTIFIER, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			type(0);
			setState(150);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuiteContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(MxStarParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(MxStarParser.CLOSE_BRACE, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitSuite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitSuite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(OPEN_BRACE);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << SEMI) | (1L << OPEN_PAREN) | (1L << OPEN_BRACE) | (1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << NULL) | (1L << VOID) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CONITNUE) | (1L << RETURN) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(155);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ADD:
				case MINUS:
				case NOT_LOG:
				case NOT_OP:
				case PLUS_PLUS:
				case MINUS_MINUS:
				case SEMI:
				case OPEN_PAREN:
				case INT:
				case BOOL:
				case STRING:
				case NULL:
				case VOID:
				case IF:
				case FOR:
				case WHILE:
				case BREAK:
				case CONITNUE:
				case RETURN:
				case NEW:
				case THIS:
				case LAMBDA_HEAD:
				case BOOL_LITERAL:
				case INT_LITERAL:
				case STRING_LITERAL:
				case IDENTIFIER:
					{
					setState(153);
					stmt();
					}
					break;
				case OPEN_BRACE:
					{
					setState(154);
					suite();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(160);
			match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Var_def_stmtContext var_def_stmt() {
			return getRuleContext(Var_def_stmtContext.class,0);
		}
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public Loop_stmtContext loop_stmt() {
			return getRuleContext(Loop_stmtContext.class,0);
		}
		public Flow_stmtContext flow_stmt() {
			return getRuleContext(Flow_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_stmt);
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				var_def_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				expr_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				if_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				loop_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(166);
				flow_stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MxStarParser.IF, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(MxStarParser.OPEN_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(MxStarParser.CLOSE_PAREN, 0); }
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MxStarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MxStarParser.SEMI, i);
		}
		public TerminalNode ELSE() { return getToken(MxStarParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(IF);
			setState(170);
			match(OPEN_PAREN);
			setState(171);
			expr(0);
			setState(172);
			match(CLOSE_PAREN);
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(173);
				suite();
				}
				break;
			case 2:
				{
				setState(174);
				stmt();
				}
				break;
			case 3:
				{
				setState(175);
				match(SEMI);
				}
				break;
			}
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(178);
				match(ELSE);
				setState(182);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(179);
					suite();
					}
					break;
				case 2:
					{
					setState(180);
					stmt();
					}
					break;
				case 3:
					{
					setState(181);
					match(SEMI);
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Loop_stmtContext extends ParserRuleContext {
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Loop_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterLoop_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitLoop_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitLoop_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_stmtContext loop_stmt() throws RecognitionException {
		Loop_stmtContext _localctx = new Loop_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_loop_stmt);
		try {
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				while_stmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				for_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MxStarParser.WHILE, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(MxStarParser.OPEN_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(MxStarParser.CLOSE_PAREN, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MxStarParser.SEMI, 0); }
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitWhile_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(WHILE);
			setState(191);
			match(OPEN_PAREN);
			setState(192);
			expr(0);
			setState(193);
			match(CLOSE_PAREN);
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(194);
				suite();
				}
				break;
			case 2:
				{
				setState(195);
				stmt();
				}
				break;
			case 3:
				{
				setState(196);
				match(SEMI);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MxStarParser.FOR, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(MxStarParser.OPEN_PAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(MxStarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MxStarParser.SEMI, i);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(MxStarParser.CLOSE_PAREN, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public Var_defContext var_def() {
			return getRuleContext(Var_defContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFor_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFor_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(FOR);
			setState(200);
			match(OPEN_PAREN);
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(201);
				var_def();
				}
				break;
			case 2:
				{
				setState(202);
				expr(0);
				}
				break;
			}
			setState(205);
			match(SEMI);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(206);
				expr(0);
				}
			}

			setState(209);
			match(SEMI);
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(210);
				expr(0);
				}
			}

			setState(213);
			match(CLOSE_PAREN);
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(214);
				suite();
				}
				break;
			case 2:
				{
				setState(215);
				stmt();
				}
				break;
			case 3:
				{
				setState(216);
				match(SEMI);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Flow_stmtContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(MxStarParser.SEMI, 0); }
		public TerminalNode RETURN() { return getToken(MxStarParser.RETURN, 0); }
		public TerminalNode BREAK() { return getToken(MxStarParser.BREAK, 0); }
		public TerminalNode CONITNUE() { return getToken(MxStarParser.CONITNUE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Flow_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flow_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFlow_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFlow_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFlow_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Flow_stmtContext flow_stmt() throws RecognitionException {
		Flow_stmtContext _localctx = new Flow_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_flow_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				{
				setState(219);
				match(RETURN);
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(220);
					expr(0);
					}
				}

				}
				break;
			case BREAK:
				{
				setState(223);
				match(BREAK);
				}
				break;
			case CONITNUE:
				{
				setState(224);
				match(CONITNUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(227);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_stmtContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(MxStarParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitExpr_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitExpr_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expr_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(229);
				expr(0);
				}
			}

			setState(232);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS_PLUS() { return getToken(MxStarParser.PLUS_PLUS, 0); }
		public TerminalNode MINUS_MINUS() { return getToken(MxStarParser.MINUS_MINUS, 0); }
		public TerminalNode ADD() { return getToken(MxStarParser.ADD, 0); }
		public TerminalNode MINUS() { return getToken(MxStarParser.MINUS, 0); }
		public TerminalNode NOT_LOG() { return getToken(MxStarParser.NOT_LOG, 0); }
		public TerminalNode NOT_OP() { return getToken(MxStarParser.NOT_OP, 0); }
		public TerminalNode NEW() { return getToken(MxStarParser.NEW, 0); }
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public TerminalNode THIS() { return getToken(MxStarParser.THIS, 0); }
		public TerminalNode NULL() { return getToken(MxStarParser.NULL, 0); }
		public TerminalNode INT_LITERAL() { return getToken(MxStarParser.INT_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(MxStarParser.BOOL_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(MxStarParser.STRING_LITERAL, 0); }
		public Lambda_stmtContext lambda_stmt() {
			return getRuleContext(Lambda_stmtContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MxStarParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(MxStarParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(MxStarParser.CLOSE_PAREN, 0); }
		public TerminalNode DOT() { return getToken(MxStarParser.DOT, 0); }
		public TerminalNode STAR() { return getToken(MxStarParser.STAR, 0); }
		public TerminalNode DIV() { return getToken(MxStarParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MxStarParser.MOD, 0); }
		public TerminalNode LEFT_SHIFT() { return getToken(MxStarParser.LEFT_SHIFT, 0); }
		public TerminalNode RIGHT_SHIFT() { return getToken(MxStarParser.RIGHT_SHIFT, 0); }
		public TerminalNode LESS_THAN() { return getToken(MxStarParser.LESS_THAN, 0); }
		public TerminalNode GREATER_THAN() { return getToken(MxStarParser.GREATER_THAN, 0); }
		public TerminalNode LT_EQ() { return getToken(MxStarParser.LT_EQ, 0); }
		public TerminalNode GT_EQ() { return getToken(MxStarParser.GT_EQ, 0); }
		public TerminalNode EQUALS() { return getToken(MxStarParser.EQUALS, 0); }
		public TerminalNode NOT_EQ() { return getToken(MxStarParser.NOT_EQ, 0); }
		public TerminalNode AND_OP() { return getToken(MxStarParser.AND_OP, 0); }
		public TerminalNode XOR_OP() { return getToken(MxStarParser.XOR_OP, 0); }
		public TerminalNode OR_OP() { return getToken(MxStarParser.OR_OP, 0); }
		public TerminalNode AND_LOG() { return getToken(MxStarParser.AND_LOG, 0); }
		public TerminalNode OR_LOG() { return getToken(MxStarParser.OR_LOG, 0); }
		public TerminalNode ASSIGN() { return getToken(MxStarParser.ASSIGN, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode OPEN_BRACK() { return getToken(MxStarParser.OPEN_BRACK, 0); }
		public TerminalNode CLOSE_BRACK() { return getToken(MxStarParser.CLOSE_BRACK, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS_PLUS:
			case MINUS_MINUS:
				{
				setState(235);
				_la = _input.LA(1);
				if ( !(_la==PLUS_PLUS || _la==MINUS_MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(236);
				expr(24);
				}
				break;
			case ADD:
			case MINUS:
				{
				setState(237);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(238);
				expr(23);
				}
				break;
			case NOT_LOG:
			case NOT_OP:
				{
				setState(239);
				_la = _input.LA(1);
				if ( !(_la==NOT_LOG || _la==NOT_OP) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(240);
				expr(22);
				}
				break;
			case NEW:
				{
				setState(241);
				match(NEW);
				setState(242);
				creator(0);
				}
				break;
			case THIS:
				{
				setState(243);
				match(THIS);
				}
				break;
			case NULL:
				{
				setState(244);
				match(NULL);
				}
				break;
			case INT_LITERAL:
				{
				setState(245);
				match(INT_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				{
				setState(246);
				match(BOOL_LITERAL);
				}
				break;
			case STRING_LITERAL:
				{
				setState(247);
				match(STRING_LITERAL);
				}
				break;
			case LAMBDA_HEAD:
				{
				setState(248);
				lambda_stmt();
				}
				break;
			case IDENTIFIER:
				{
				setState(249);
				match(IDENTIFIER);
				}
				break;
			case OPEN_PAREN:
				{
				setState(250);
				match(OPEN_PAREN);
				setState(251);
				expr(0);
				setState(252);
				match(CLOSE_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(306);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(304);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(256);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(257);
						match(DOT);
						setState(258);
						expr(26);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(259);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(260);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(261);
						expr(21);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(262);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(263);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(264);
						expr(20);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(265);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(266);
						_la = _input.LA(1);
						if ( !(_la==LEFT_SHIFT || _la==RIGHT_SHIFT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(267);
						expr(19);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(268);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(269);
						_la = _input.LA(1);
						if ( !(_la==LESS_THAN || _la==GREATER_THAN) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(270);
						expr(18);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(271);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(272);
						_la = _input.LA(1);
						if ( !(_la==GT_EQ || _la==LT_EQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(273);
						expr(17);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(274);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(275);
						_la = _input.LA(1);
						if ( !(_la==EQUALS || _la==NOT_EQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(276);
						expr(16);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(277);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(278);
						match(AND_OP);
						setState(279);
						expr(15);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(280);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(281);
						match(XOR_OP);
						setState(282);
						expr(14);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(283);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(284);
						match(OR_OP);
						setState(285);
						expr(13);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(286);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(287);
						match(AND_LOG);
						setState(288);
						expr(12);
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(289);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(290);
						match(OR_LOG);
						setState(291);
						expr(11);
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(292);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(293);
						match(ASSIGN);
						setState(294);
						expr(9);
						}
						break;
					case 14:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(295);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(296);
						_la = _input.LA(1);
						if ( !(_la==PLUS_PLUS || _la==MINUS_MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 15:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(297);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(298);
						arg_list();
						}
						break;
					case 16:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(299);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(300);
						match(OPEN_BRACK);
						setState(301);
						expr(0);
						setState(302);
						match(CLOSE_BRACK);
						}
						break;
					}
					} 
				}
				setState(308);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Arg_listContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(MxStarParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(MxStarParser.CLOSE_PAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MxStarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MxStarParser.COMMA, i);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterArg_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitArg_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitArg_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(OPEN_PAREN);
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(310);
				expr(0);
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(311);
					match(COMMA);
					setState(312);
					expr(0);
					}
					}
					setState(317);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(320);
			match(CLOSE_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatorContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MxStarParser.IDENTIFIER, 0); }
		public Basic_typeContext basic_type() {
			return getRuleContext(Basic_typeContext.class,0);
		}
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public TerminalNode OPEN_BRACK() { return getToken(MxStarParser.OPEN_BRACK, 0); }
		public TerminalNode CLOSE_BRACK() { return getToken(MxStarParser.CLOSE_BRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		return creator(0);
	}

	private CreatorContext creator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CreatorContext _localctx = new CreatorContext(_ctx, _parentState);
		CreatorContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_creator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(323);
				match(IDENTIFIER);
				}
				break;
			case INT:
			case BOOL:
			case STRING:
			case VOID:
				{
				setState(324);
				basic_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(335);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CreatorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_creator);
					setState(327);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(328);
					match(OPEN_BRACK);
					setState(330);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
						{
						setState(329);
						expr(0);
						}
					}

					setState(332);
					match(CLOSE_BRACK);
					}
					} 
				}
				setState(337);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Lambda_stmtContext extends ParserRuleContext {
		public TerminalNode LAMBDA_HEAD() { return getToken(MxStarParser.LAMBDA_HEAD, 0); }
		public TerminalNode ARROW() { return getToken(MxStarParser.ARROW, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Lambda_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterLambda_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitLambda_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitLambda_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_stmtContext lambda_stmt() throws RecognitionException {
		Lambda_stmtContext _localctx = new Lambda_stmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_lambda_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(LAMBDA_HEAD);
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAREN) {
				{
				setState(339);
				parameter_list();
				}
			}

			setState(342);
			match(ARROW);
			setState(343);
			suite();
			setState(344);
			arg_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 22:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 24:
			return creator_sempred((CreatorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 25);
		case 2:
			return precpred(_ctx, 20);
		case 3:
			return precpred(_ctx, 19);
		case 4:
			return precpred(_ctx, 18);
		case 5:
			return precpred(_ctx, 17);
		case 6:
			return precpred(_ctx, 16);
		case 7:
			return precpred(_ctx, 15);
		case 8:
			return precpred(_ctx, 14);
		case 9:
			return precpred(_ctx, 13);
		case 10:
			return precpred(_ctx, 12);
		case 11:
			return precpred(_ctx, 11);
		case 12:
			return precpred(_ctx, 10);
		case 13:
			return precpred(_ctx, 9);
		case 14:
			return precpred(_ctx, 28);
		case 15:
			return precpred(_ctx, 27);
		case 16:
			return precpred(_ctx, 26);
		}
		return true;
	}
	private boolean creator_sempred(CreatorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3<\u015d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\7\2?\n\2\f\2"+
		"\16\2B\13\2\3\3\3\3\3\3\5\3G\n\3\3\4\3\4\3\4\3\4\5\4M\n\4\3\4\3\4\7\4"+
		"Q\n\4\f\4\16\4T\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\7\bi\n\b\f\b\16\bl\13\b\3\t\3\t\3\t\5\tq\n"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\5\f}\n\f\3\f\3\f\3\f\7\f"+
		"\u0082\n\f\f\f\16\f\u0085\13\f\3\r\3\r\5\r\u0089\n\r\3\16\3\16\3\16\3"+
		"\16\7\16\u008f\n\16\f\16\16\16\u0092\13\16\5\16\u0094\n\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\7\20\u009e\n\20\f\20\16\20\u00a1\13\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\5\21\u00aa\n\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\5\22\u00b3\n\22\3\22\3\22\3\22\3\22\5\22\u00b9\n\22\5"+
		"\22\u00bb\n\22\3\23\3\23\5\23\u00bf\n\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u00c8\n\24\3\25\3\25\3\25\3\25\5\25\u00ce\n\25\3\25\3\25\5"+
		"\25\u00d2\n\25\3\25\3\25\5\25\u00d6\n\25\3\25\3\25\3\25\3\25\5\25\u00dc"+
		"\n\25\3\26\3\26\5\26\u00e0\n\26\3\26\3\26\5\26\u00e4\n\26\3\26\3\26\3"+
		"\27\5\27\u00e9\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0101"+
		"\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0133\n\30\f\30\16\30\u0136\13"+
		"\30\3\31\3\31\3\31\3\31\7\31\u013c\n\31\f\31\16\31\u013f\13\31\5\31\u0141"+
		"\n\31\3\31\3\31\3\32\3\32\3\32\5\32\u0148\n\32\3\32\3\32\3\32\5\32\u014d"+
		"\n\32\3\32\7\32\u0150\n\32\f\32\16\32\u0153\13\32\3\33\3\33\5\33\u0157"+
		"\n\33\3\33\3\33\3\33\3\33\3\33\2\5\26.\62\34\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\2\13\4\2$&((\3\2\30\31\3\2\3\4\4\2\20\20"+
		"\26\26\3\2\5\7\3\2\21\22\3\2\b\t\3\2\13\f\4\2\n\n\r\r\2\u0189\29\3\2\2"+
		"\2\4F\3\2\2\2\6H\3\2\2\2\bX\3\2\2\2\n]\3\2\2\2\fa\3\2\2\2\16d\3\2\2\2"+
		"\20m\3\2\2\2\22r\3\2\2\2\24w\3\2\2\2\26|\3\2\2\2\30\u0088\3\2\2\2\32\u008a"+
		"\3\2\2\2\34\u0097\3\2\2\2\36\u009a\3\2\2\2 \u00a9\3\2\2\2\"\u00ab\3\2"+
		"\2\2$\u00be\3\2\2\2&\u00c0\3\2\2\2(\u00c9\3\2\2\2*\u00e3\3\2\2\2,\u00e8"+
		"\3\2\2\2.\u0100\3\2\2\2\60\u0137\3\2\2\2\62\u0147\3\2\2\2\64\u0154\3\2"+
		"\2\2\668\5\4\3\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2"+
		"\2;9\3\2\2\2<@\5\n\6\2=?\5\4\3\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2"+
		"\2A\3\3\2\2\2B@\3\2\2\2CG\5\6\4\2DG\5\22\n\2EG\5\f\7\2FC\3\2\2\2FD\3\2"+
		"\2\2FE\3\2\2\2G\5\3\2\2\2HI\7\61\2\2IJ\78\2\2JL\7\"\2\2KM\5\b\5\2LK\3"+
		"\2\2\2LM\3\2\2\2MR\3\2\2\2NQ\5\f\7\2OQ\5\22\n\2PN\3\2\2\2PO\3\2\2\2QT"+
		"\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\7#\2\2VW\7\34\2\2W"+
		"\7\3\2\2\2XY\78\2\2YZ\7\36\2\2Z[\7\37\2\2[\\\5\36\20\2\\\t\3\2\2\2]^\7"+
		"$\2\2^_\7\63\2\2_`\5\36\20\2`\13\3\2\2\2ab\5\16\b\2bc\7\34\2\2c\r\3\2"+
		"\2\2de\5\26\f\2ej\5\20\t\2fg\7\33\2\2gi\5\20\t\2hf\3\2\2\2il\3\2\2\2j"+
		"h\3\2\2\2jk\3\2\2\2k\17\3\2\2\2lj\3\2\2\2mp\78\2\2no\7\27\2\2oq\5.\30"+
		"\2pn\3\2\2\2pq\3\2\2\2q\21\3\2\2\2rs\5\30\r\2st\78\2\2tu\5\32\16\2uv\5"+
		"\36\20\2v\23\3\2\2\2wx\t\2\2\2x\25\3\2\2\2yz\b\f\1\2z}\78\2\2{}\5\24\13"+
		"\2|y\3\2\2\2|{\3\2\2\2}\u0083\3\2\2\2~\177\f\3\2\2\177\u0080\7 \2\2\u0080"+
		"\u0082\7!\2\2\u0081~\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\27\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0089\5\26\f"+
		"\2\u0087\u0089\7(\2\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\31"+
		"\3\2\2\2\u008a\u0093\7\36\2\2\u008b\u0090\5\34\17\2\u008c\u008d\7\33\2"+
		"\2\u008d\u008f\5\34\17\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2"+
		"\2\2\u0093\u008b\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0096\7\37\2\2\u0096\33\3\2\2\2\u0097\u0098\5\26\f\2\u0098\u0099\78\2"+
		"\2\u0099\35\3\2\2\2\u009a\u009f\7\"\2\2\u009b\u009e\5 \21\2\u009c\u009e"+
		"\5\36\20\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2"+
		"\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f"+
		"\3\2\2\2\u00a2\u00a3\7#\2\2\u00a3\37\3\2\2\2\u00a4\u00aa\5\f\7\2\u00a5"+
		"\u00aa\5,\27\2\u00a6\u00aa\5\"\22\2\u00a7\u00aa\5$\23\2\u00a8\u00aa\5"+
		"*\26\2\u00a9\u00a4\3\2\2\2\u00a9\u00a5\3\2\2\2\u00a9\u00a6\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa!\3\2\2\2\u00ab\u00ac\7)\2\2\u00ac"+
		"\u00ad\7\36\2\2\u00ad\u00ae\5.\30\2\u00ae\u00b2\7\37\2\2\u00af\u00b3\5"+
		"\36\20\2\u00b0\u00b3\5 \21\2\u00b1\u00b3\7\34\2\2\u00b2\u00af\3\2\2\2"+
		"\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00ba\3\2\2\2\u00b4\u00b8"+
		"\7*\2\2\u00b5\u00b9\5\36\20\2\u00b6\u00b9\5 \21\2\u00b7\u00b9\7\34\2\2"+
		"\u00b8\u00b5\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bb"+
		"\3\2\2\2\u00ba\u00b4\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb#\3\2\2\2\u00bc"+
		"\u00bf\5&\24\2\u00bd\u00bf\5(\25\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2"+
		"\2\2\u00bf%\3\2\2\2\u00c0\u00c1\7,\2\2\u00c1\u00c2\7\36\2\2\u00c2\u00c3"+
		"\5.\30\2\u00c3\u00c7\7\37\2\2\u00c4\u00c8\5\36\20\2\u00c5\u00c8\5 \21"+
		"\2\u00c6\u00c8\7\34\2\2\u00c7\u00c4\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7"+
		"\u00c6\3\2\2\2\u00c8\'\3\2\2\2\u00c9\u00ca\7+\2\2\u00ca\u00cd\7\36\2\2"+
		"\u00cb\u00ce\5\16\b\2\u00cc\u00ce\5.\30\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc"+
		"\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\7\34\2\2"+
		"\u00d0\u00d2\5.\30\2\u00d1\u00d0\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3"+
		"\3\2\2\2\u00d3\u00d5\7\34\2\2\u00d4\u00d6\5.\30\2\u00d5\u00d4\3\2\2\2"+
		"\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00db\7\37\2\2\u00d8\u00dc"+
		"\5\36\20\2\u00d9\u00dc\5 \21\2\u00da\u00dc\7\34\2\2\u00db\u00d8\3\2\2"+
		"\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc)\3\2\2\2\u00dd\u00df"+
		"\7/\2\2\u00de\u00e0\5.\30\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e4\3\2\2\2\u00e1\u00e4\7-\2\2\u00e2\u00e4\7.\2\2\u00e3\u00dd\3\2\2"+
		"\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6"+
		"\7\34\2\2\u00e6+\3\2\2\2\u00e7\u00e9\5.\30\2\u00e8\u00e7\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\7\34\2\2\u00eb-\3\2\2\2"+
		"\u00ec\u00ed\b\30\1\2\u00ed\u00ee\t\3\2\2\u00ee\u0101\5.\30\32\u00ef\u00f0"+
		"\t\4\2\2\u00f0\u0101\5.\30\31\u00f1\u00f2\t\5\2\2\u00f2\u0101\5.\30\30"+
		"\u00f3\u00f4\7\60\2\2\u00f4\u0101\5\62\32\2\u00f5\u0101\7\62\2\2\u00f6"+
		"\u0101\7\'\2\2\u00f7\u0101\7\66\2\2\u00f8\u0101\7\65\2\2\u00f9\u0101\7"+
		"\67\2\2\u00fa\u0101\5\64\33\2\u00fb\u0101\78\2\2\u00fc\u00fd\7\36\2\2"+
		"\u00fd\u00fe\5.\30\2\u00fe\u00ff\7\37\2\2\u00ff\u0101\3\2\2\2\u0100\u00ec"+
		"\3\2\2\2\u0100\u00ef\3\2\2\2\u0100\u00f1\3\2\2\2\u0100\u00f3\3\2\2\2\u0100"+
		"\u00f5\3\2\2\2\u0100\u00f6\3\2\2\2\u0100\u00f7\3\2\2\2\u0100\u00f8\3\2"+
		"\2\2\u0100\u00f9\3\2\2\2\u0100\u00fa\3\2\2\2\u0100\u00fb\3\2\2\2\u0100"+
		"\u00fc\3\2\2\2\u0101\u0134\3\2\2\2\u0102\u0103\f\33\2\2\u0103\u0104\7"+
		"\32\2\2\u0104\u0133\5.\30\34\u0105\u0106\f\26\2\2\u0106\u0107\t\6\2\2"+
		"\u0107\u0133\5.\30\27\u0108\u0109\f\25\2\2\u0109\u010a\t\4\2\2\u010a\u0133"+
		"\5.\30\26\u010b\u010c\f\24\2\2\u010c\u010d\t\7\2\2\u010d\u0133\5.\30\25"+
		"\u010e\u010f\f\23\2\2\u010f\u0110\t\b\2\2\u0110\u0133\5.\30\24\u0111\u0112"+
		"\f\22\2\2\u0112\u0113\t\t\2\2\u0113\u0133\5.\30\23\u0114\u0115\f\21\2"+
		"\2\u0115\u0116\t\n\2\2\u0116\u0133\5.\30\22\u0117\u0118\f\20\2\2\u0118"+
		"\u0119\7\25\2\2\u0119\u0133\5.\30\21\u011a\u011b\f\17\2\2\u011b\u011c"+
		"\7\24\2\2\u011c\u0133\5.\30\20\u011d\u011e\f\16\2\2\u011e\u011f\7\23\2"+
		"\2\u011f\u0133\5.\30\17\u0120\u0121\f\r\2\2\u0121\u0122\7\16\2\2\u0122"+
		"\u0133\5.\30\16\u0123\u0124\f\f\2\2\u0124\u0125\7\17\2\2\u0125\u0133\5"+
		".\30\r\u0126\u0127\f\13\2\2\u0127\u0128\7\27\2\2\u0128\u0133\5.\30\13"+
		"\u0129\u012a\f\36\2\2\u012a\u0133\t\3\2\2\u012b\u012c\f\35\2\2\u012c\u0133"+
		"\5\60\31\2\u012d\u012e\f\34\2\2\u012e\u012f\7 \2\2\u012f\u0130\5.\30\2"+
		"\u0130\u0131\7!\2\2\u0131\u0133\3\2\2\2\u0132\u0102\3\2\2\2\u0132\u0105"+
		"\3\2\2\2\u0132\u0108\3\2\2\2\u0132\u010b\3\2\2\2\u0132\u010e\3\2\2\2\u0132"+
		"\u0111\3\2\2\2\u0132\u0114\3\2\2\2\u0132\u0117\3\2\2\2\u0132\u011a\3\2"+
		"\2\2\u0132\u011d\3\2\2\2\u0132\u0120\3\2\2\2\u0132\u0123\3\2\2\2\u0132"+
		"\u0126\3\2\2\2\u0132\u0129\3\2\2\2\u0132\u012b\3\2\2\2\u0132\u012d\3\2"+
		"\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"/\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u0140\7\36\2\2\u0138\u013d\5.\30\2"+
		"\u0139\u013a\7\33\2\2\u013a\u013c\5.\30\2\u013b\u0139\3\2\2\2\u013c\u013f"+
		"\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0141\3\2\2\2\u013f"+
		"\u013d\3\2\2\2\u0140\u0138\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0142\3\2"+
		"\2\2\u0142\u0143\7\37\2\2\u0143\61\3\2\2\2\u0144\u0145\b\32\1\2\u0145"+
		"\u0148\78\2\2\u0146\u0148\5\24\13\2\u0147\u0144\3\2\2\2\u0147\u0146\3"+
		"\2\2\2\u0148\u0151\3\2\2\2\u0149\u014a\f\3\2\2\u014a\u014c\7 \2\2\u014b"+
		"\u014d\5.\30\2\u014c\u014b\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\3\2"+
		"\2\2\u014e\u0150\7!\2\2\u014f\u0149\3\2\2\2\u0150\u0153\3\2\2\2\u0151"+
		"\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\63\3\2\2\2\u0153\u0151\3\2\2"+
		"\2\u0154\u0156\7\64\2\2\u0155\u0157\5\32\16\2\u0156\u0155\3\2\2\2\u0156"+
		"\u0157\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\7\35\2\2\u0159\u015a\5"+
		"\36\20\2\u015a\u015b\5\60\31\2\u015b\65\3\2\2\2\'9@FLPRjp|\u0083\u0088"+
		"\u0090\u0093\u009d\u009f\u00a9\u00b2\u00b8\u00ba\u00be\u00c7\u00cd\u00d1"+
		"\u00d5\u00db\u00df\u00e3\u00e8\u0100\u0132\u0134\u013d\u0140\u0147\u014c"+
		"\u0151\u0156";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}