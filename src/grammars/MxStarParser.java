// Generated from C:/Users/lhtie/Documents/Repos/Compiler_ACM-2022/src/grammars\MxStar.g4 by ANTLR 4.9.1
package grammars;
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
		LAMBDA_HEAD=49, BOOL_LITERAL=50, INT_LITERAL=51, STRING_LITERAL=52, IDENTIFIER=53, 
		NEWLINE=54, BlockComment=55, LINE_COMMENT=56, WS=57;
	public static final int
		RULE_program = 0, RULE_define = 1, RULE_class_def = 2, RULE_constructor_def = 3, 
		RULE_var_def_stmt = 4, RULE_var_def = 5, RULE_var_def_arg = 6, RULE_func_def = 7, 
		RULE_basic_type = 8, RULE_type = 9, RULE_func_type = 10, RULE_parameter_list = 11, 
		RULE_parameter = 12, RULE_suite = 13, RULE_stmt = 14, RULE_if_stmt = 15, 
		RULE_loop_stmt = 16, RULE_while_stmt = 17, RULE_for_stmt = 18, RULE_flow_stmt = 19, 
		RULE_expr_stmt = 20, RULE_expr = 21, RULE_arg_list = 22, RULE_creator = 23, 
		RULE_lambda_stmt = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "define", "class_def", "constructor_def", "var_def_stmt", 
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
			"'return'", "'new'", "'class'", "'this'", "'[&]'"
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
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << VOID) | (1L << CLASS) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(50);
				define();
				}
				}
				setState(55);
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
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				class_def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				func_def();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
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
			setState(61);
			match(CLASS);
			setState(62);
			match(IDENTIFIER);
			setState(63);
			match(OPEN_BRACE);
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(64);
				constructor_def();
				}
				break;
			}
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << VOID) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(69);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(67);
					var_def_stmt();
					}
					break;
				case 2:
					{
					setState(68);
					func_def();
					}
					break;
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(CLOSE_BRACE);
			setState(75);
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
			setState(77);
			match(IDENTIFIER);
			setState(78);
			match(OPEN_PAREN);
			setState(79);
			match(CLOSE_PAREN);
			setState(80);
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
		enterRule(_localctx, 8, RULE_var_def_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			var_def();
			setState(83);
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
		enterRule(_localctx, 10, RULE_var_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			type(0);
			setState(86);
			var_def_arg();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(87);
				match(COMMA);
				setState(88);
				var_def_arg();
				}
				}
				setState(93);
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
		enterRule(_localctx, 12, RULE_var_def_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(IDENTIFIER);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(95);
				match(ASSIGN);
				setState(96);
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
		enterRule(_localctx, 14, RULE_func_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			func_type();
			setState(100);
			match(IDENTIFIER);
			setState(101);
			parameter_list();
			setState(102);
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
		enterRule(_localctx, 16, RULE_basic_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING))) != 0)) ) {
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(107);
				match(IDENTIFIER);
				}
				break;
			case INT:
			case BOOL:
			case STRING:
				{
				setState(108);
				basic_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(111);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(112);
					match(OPEN_BRACK);
					setState(113);
					match(CLOSE_BRACK);
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		enterRule(_localctx, 20, RULE_func_type);
		try {
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case STRING:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				type(0);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(VOID);
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
		enterRule(_localctx, 22, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(OPEN_PAREN);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(124);
				parameter();
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(125);
					match(COMMA);
					setState(126);
					parameter();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(134);
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
		enterRule(_localctx, 24, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			type(0);
			setState(137);
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
		enterRule(_localctx, 26, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(OPEN_BRACE);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << SEMI) | (1L << OPEN_PAREN) | (1L << OPEN_BRACE) | (1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << NULL) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CONITNUE) | (1L << RETURN) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(142);
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
					setState(140);
					stmt();
					}
					break;
				case OPEN_BRACE:
					{
					setState(141);
					suite();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(147);
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
		enterRule(_localctx, 28, RULE_stmt);
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				var_def_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				expr_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				if_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(152);
				loop_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(153);
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
		enterRule(_localctx, 30, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(IF);
			setState(157);
			match(OPEN_PAREN);
			setState(158);
			expr(0);
			setState(159);
			match(CLOSE_PAREN);
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(160);
				suite();
				}
				break;
			case 2:
				{
				setState(161);
				stmt();
				}
				break;
			case 3:
				{
				setState(162);
				match(SEMI);
				}
				break;
			}
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(165);
				match(ELSE);
				setState(169);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(166);
					suite();
					}
					break;
				case 2:
					{
					setState(167);
					stmt();
					}
					break;
				case 3:
					{
					setState(168);
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
		enterRule(_localctx, 32, RULE_loop_stmt);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				while_stmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
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
		enterRule(_localctx, 34, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(WHILE);
			setState(178);
			match(OPEN_PAREN);
			setState(179);
			expr(0);
			setState(180);
			match(CLOSE_PAREN);
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(181);
				suite();
				}
				break;
			case 2:
				{
				setState(182);
				stmt();
				}
				break;
			case 3:
				{
				setState(183);
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
		enterRule(_localctx, 36, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(FOR);
			setState(187);
			match(OPEN_PAREN);
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(188);
				var_def();
				}
				break;
			case 2:
				{
				setState(189);
				expr(0);
				}
				break;
			}
			setState(192);
			match(SEMI);
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(193);
				expr(0);
				}
			}

			setState(196);
			match(SEMI);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(197);
				expr(0);
				}
			}

			setState(200);
			match(CLOSE_PAREN);
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(201);
				suite();
				}
				break;
			case 2:
				{
				setState(202);
				stmt();
				}
				break;
			case 3:
				{
				setState(203);
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
		enterRule(_localctx, 38, RULE_flow_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				{
				setState(206);
				match(RETURN);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(207);
					expr(0);
					}
				}

				}
				break;
			case BREAK:
				{
				setState(210);
				match(BREAK);
				}
				break;
			case CONITNUE:
				{
				setState(211);
				match(CONITNUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(214);
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
		enterRule(_localctx, 40, RULE_expr_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(216);
				expr(0);
				}
			}

			setState(219);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS_PLUS:
			case MINUS_MINUS:
				{
				setState(222);
				_la = _input.LA(1);
				if ( !(_la==PLUS_PLUS || _la==MINUS_MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(223);
				expr(24);
				}
				break;
			case ADD:
			case MINUS:
				{
				setState(224);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(225);
				expr(23);
				}
				break;
			case NOT_LOG:
			case NOT_OP:
				{
				setState(226);
				_la = _input.LA(1);
				if ( !(_la==NOT_LOG || _la==NOT_OP) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(227);
				expr(22);
				}
				break;
			case NEW:
				{
				setState(228);
				match(NEW);
				setState(229);
				creator(0);
				}
				break;
			case THIS:
				{
				setState(230);
				match(THIS);
				}
				break;
			case NULL:
				{
				setState(231);
				match(NULL);
				}
				break;
			case INT_LITERAL:
				{
				setState(232);
				match(INT_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				{
				setState(233);
				match(BOOL_LITERAL);
				}
				break;
			case STRING_LITERAL:
				{
				setState(234);
				match(STRING_LITERAL);
				}
				break;
			case LAMBDA_HEAD:
				{
				setState(235);
				lambda_stmt();
				}
				break;
			case IDENTIFIER:
				{
				setState(236);
				match(IDENTIFIER);
				}
				break;
			case OPEN_PAREN:
				{
				setState(237);
				match(OPEN_PAREN);
				setState(238);
				expr(0);
				setState(239);
				match(CLOSE_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(291);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(243);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(244);
						match(DOT);
						setState(245);
						expr(26);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(246);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(247);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(248);
						expr(21);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(249);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(250);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(251);
						expr(20);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(252);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(253);
						_la = _input.LA(1);
						if ( !(_la==LEFT_SHIFT || _la==RIGHT_SHIFT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(254);
						expr(19);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(255);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(256);
						_la = _input.LA(1);
						if ( !(_la==LESS_THAN || _la==GREATER_THAN) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(257);
						expr(18);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(258);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(259);
						_la = _input.LA(1);
						if ( !(_la==GT_EQ || _la==LT_EQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(260);
						expr(17);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(261);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(262);
						_la = _input.LA(1);
						if ( !(_la==EQUALS || _la==NOT_EQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(263);
						expr(16);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(264);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(265);
						match(AND_OP);
						setState(266);
						expr(15);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(267);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(268);
						match(XOR_OP);
						setState(269);
						expr(14);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(270);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(271);
						match(OR_OP);
						setState(272);
						expr(13);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(273);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(274);
						match(AND_LOG);
						setState(275);
						expr(12);
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(276);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(277);
						match(OR_LOG);
						setState(278);
						expr(11);
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(279);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(280);
						match(ASSIGN);
						setState(281);
						expr(9);
						}
						break;
					case 14:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(282);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(283);
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
						setState(284);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(285);
						arg_list();
						}
						break;
					case 16:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(286);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(287);
						match(OPEN_BRACK);
						setState(288);
						expr(0);
						setState(289);
						match(CLOSE_BRACK);
						}
						break;
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		enterRule(_localctx, 44, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(OPEN_PAREN);
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(297);
				expr(0);
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(298);
					match(COMMA);
					setState(299);
					expr(0);
					}
					}
					setState(304);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(307);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_creator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(310);
				match(IDENTIFIER);
				}
				break;
			case INT:
			case BOOL:
			case STRING:
				{
				setState(311);
				basic_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CreatorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_creator);
					setState(314);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(315);
					match(OPEN_BRACK);
					setState(317);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
						{
						setState(316);
						expr(0);
						}
					}

					setState(319);
					match(CLOSE_BRACK);
					}
					} 
				}
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		enterRule(_localctx, 48, RULE_lambda_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(LAMBDA_HEAD);
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAREN) {
				{
				setState(326);
				parameter_list();
				}
			}

			setState(329);
			match(ARROW);
			setState(330);
			suite();
			setState(331);
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
		case 9:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 21:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 23:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u0150\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\7\2\66\n\2\f\2\16\29\13\2\3\3\3\3\3\3\5\3>\n\3\3\4\3\4"+
		"\3\4\3\4\5\4D\n\4\3\4\3\4\7\4H\n\4\f\4\16\4K\13\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7\\\n\7\f\7\16\7_\13\7\3\b"+
		"\3\b\3\b\5\bd\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\5\13p\n\13"+
		"\3\13\3\13\3\13\7\13u\n\13\f\13\16\13x\13\13\3\f\3\f\5\f|\n\f\3\r\3\r"+
		"\3\r\3\r\7\r\u0082\n\r\f\r\16\r\u0085\13\r\5\r\u0087\n\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\7\17\u0091\n\17\f\17\16\17\u0094\13\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\5\20\u009d\n\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u00a6\n\21\3\21\3\21\3\21\3\21\5\21\u00ac\n\21\5\21\u00ae"+
		"\n\21\3\22\3\22\5\22\u00b2\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u00bb\n\23\3\24\3\24\3\24\3\24\5\24\u00c1\n\24\3\24\3\24\5\24\u00c5\n"+
		"\24\3\24\3\24\5\24\u00c9\n\24\3\24\3\24\3\24\3\24\5\24\u00cf\n\24\3\25"+
		"\3\25\5\25\u00d3\n\25\3\25\3\25\5\25\u00d7\n\25\3\25\3\25\3\26\5\26\u00dc"+
		"\n\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00f4\n\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\7\27\u0126\n\27\f\27\16\27\u0129\13\27\3\30\3\30"+
		"\3\30\3\30\7\30\u012f\n\30\f\30\16\30\u0132\13\30\5\30\u0134\n\30\3\30"+
		"\3\30\3\31\3\31\3\31\5\31\u013b\n\31\3\31\3\31\3\31\5\31\u0140\n\31\3"+
		"\31\7\31\u0143\n\31\f\31\16\31\u0146\13\31\3\32\3\32\5\32\u014a\n\32\3"+
		"\32\3\32\3\32\3\32\3\32\2\5\24,\60\33\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\2\13\3\2$&\3\2\30\31\3\2\3\4\4\2\20\20\26\26\3\2"+
		"\5\7\3\2\21\22\3\2\b\t\3\2\13\f\4\2\n\n\r\r\2\u017c\2\67\3\2\2\2\4=\3"+
		"\2\2\2\6?\3\2\2\2\bO\3\2\2\2\nT\3\2\2\2\fW\3\2\2\2\16`\3\2\2\2\20e\3\2"+
		"\2\2\22j\3\2\2\2\24o\3\2\2\2\26{\3\2\2\2\30}\3\2\2\2\32\u008a\3\2\2\2"+
		"\34\u008d\3\2\2\2\36\u009c\3\2\2\2 \u009e\3\2\2\2\"\u00b1\3\2\2\2$\u00b3"+
		"\3\2\2\2&\u00bc\3\2\2\2(\u00d6\3\2\2\2*\u00db\3\2\2\2,\u00f3\3\2\2\2."+
		"\u012a\3\2\2\2\60\u013a\3\2\2\2\62\u0147\3\2\2\2\64\66\5\4\3\2\65\64\3"+
		"\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\3\3\2\2\29\67\3\2\2\2:>"+
		"\5\6\4\2;>\5\20\t\2<>\5\n\6\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2>\5\3\2\2\2"+
		"?@\7\61\2\2@A\7\67\2\2AC\7\"\2\2BD\5\b\5\2CB\3\2\2\2CD\3\2\2\2DI\3\2\2"+
		"\2EH\5\n\6\2FH\5\20\t\2GE\3\2\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2"+
		"\2\2JL\3\2\2\2KI\3\2\2\2LM\7#\2\2MN\7\34\2\2N\7\3\2\2\2OP\7\67\2\2PQ\7"+
		"\36\2\2QR\7\37\2\2RS\5\34\17\2S\t\3\2\2\2TU\5\f\7\2UV\7\34\2\2V\13\3\2"+
		"\2\2WX\5\24\13\2X]\5\16\b\2YZ\7\33\2\2Z\\\5\16\b\2[Y\3\2\2\2\\_\3\2\2"+
		"\2][\3\2\2\2]^\3\2\2\2^\r\3\2\2\2_]\3\2\2\2`c\7\67\2\2ab\7\27\2\2bd\5"+
		",\27\2ca\3\2\2\2cd\3\2\2\2d\17\3\2\2\2ef\5\26\f\2fg\7\67\2\2gh\5\30\r"+
		"\2hi\5\34\17\2i\21\3\2\2\2jk\t\2\2\2k\23\3\2\2\2lm\b\13\1\2mp\7\67\2\2"+
		"np\5\22\n\2ol\3\2\2\2on\3\2\2\2pv\3\2\2\2qr\f\3\2\2rs\7 \2\2su\7!\2\2"+
		"tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\25\3\2\2\2xv\3\2\2\2y|\5\24"+
		"\13\2z|\7(\2\2{y\3\2\2\2{z\3\2\2\2|\27\3\2\2\2}\u0086\7\36\2\2~\u0083"+
		"\5\32\16\2\177\u0080\7\33\2\2\u0080\u0082\5\32\16\2\u0081\177\3\2\2\2"+
		"\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0087"+
		"\3\2\2\2\u0085\u0083\3\2\2\2\u0086~\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0089\7\37\2\2\u0089\31\3\2\2\2\u008a\u008b\5\24"+
		"\13\2\u008b\u008c\7\67\2\2\u008c\33\3\2\2\2\u008d\u0092\7\"\2\2\u008e"+
		"\u0091\5\36\20\2\u008f\u0091\5\34\17\2\u0090\u008e\3\2\2\2\u0090\u008f"+
		"\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7#\2\2\u0096\35\3\2\2\2"+
		"\u0097\u009d\5\n\6\2\u0098\u009d\5*\26\2\u0099\u009d\5 \21\2\u009a\u009d"+
		"\5\"\22\2\u009b\u009d\5(\25\2\u009c\u0097\3\2\2\2\u009c\u0098\3\2\2\2"+
		"\u009c\u0099\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d\37"+
		"\3\2\2\2\u009e\u009f\7)\2\2\u009f\u00a0\7\36\2\2\u00a0\u00a1\5,\27\2\u00a1"+
		"\u00a5\7\37\2\2\u00a2\u00a6\5\34\17\2\u00a3\u00a6\5\36\20\2\u00a4\u00a6"+
		"\7\34\2\2\u00a5\u00a2\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2"+
		"\u00a6\u00ad\3\2\2\2\u00a7\u00ab\7*\2\2\u00a8\u00ac\5\34\17\2\u00a9\u00ac"+
		"\5\36\20\2\u00aa\u00ac\7\34\2\2\u00ab\u00a8\3\2\2\2\u00ab\u00a9\3\2\2"+
		"\2\u00ab\u00aa\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00a7\3\2\2\2\u00ad\u00ae"+
		"\3\2\2\2\u00ae!\3\2\2\2\u00af\u00b2\5$\23\2\u00b0\u00b2\5&\24\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2#\3\2\2\2\u00b3\u00b4\7,\2\2\u00b4"+
		"\u00b5\7\36\2\2\u00b5\u00b6\5,\27\2\u00b6\u00ba\7\37\2\2\u00b7\u00bb\5"+
		"\34\17\2\u00b8\u00bb\5\36\20\2\u00b9\u00bb\7\34\2\2\u00ba\u00b7\3\2\2"+
		"\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb%\3\2\2\2\u00bc\u00bd"+
		"\7+\2\2\u00bd\u00c0\7\36\2\2\u00be\u00c1\5\f\7\2\u00bf\u00c1\5,\27\2\u00c0"+
		"\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c4\7\34\2\2\u00c3\u00c5\5,\27\2\u00c4\u00c3\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\7\34\2\2\u00c7\u00c9\5"+
		",\27\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00ce\7\37\2\2\u00cb\u00cf\5\34\17\2\u00cc\u00cf\5\36\20\2\u00cd\u00cf"+
		"\7\34\2\2\u00ce\u00cb\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2"+
		"\u00cf\'\3\2\2\2\u00d0\u00d2\7/\2\2\u00d1\u00d3\5,\27\2\u00d2\u00d1\3"+
		"\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d7\3\2\2\2\u00d4\u00d7\7-\2\2\u00d5"+
		"\u00d7\7.\2\2\u00d6\u00d0\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2"+
		"\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\7\34\2\2\u00d9)\3\2\2\2\u00da\u00dc"+
		"\5,\27\2\u00db\u00da\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00de\7\34\2\2\u00de+\3\2\2\2\u00df\u00e0\b\27\1\2\u00e0\u00e1\t\3\2"+
		"\2\u00e1\u00f4\5,\27\32\u00e2\u00e3\t\4\2\2\u00e3\u00f4\5,\27\31\u00e4"+
		"\u00e5\t\5\2\2\u00e5\u00f4\5,\27\30\u00e6\u00e7\7\60\2\2\u00e7\u00f4\5"+
		"\60\31\2\u00e8\u00f4\7\62\2\2\u00e9\u00f4\7\'\2\2\u00ea\u00f4\7\65\2\2"+
		"\u00eb\u00f4\7\64\2\2\u00ec\u00f4\7\66\2\2\u00ed\u00f4\5\62\32\2\u00ee"+
		"\u00f4\7\67\2\2\u00ef\u00f0\7\36\2\2\u00f0\u00f1\5,\27\2\u00f1\u00f2\7"+
		"\37\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00df\3\2\2\2\u00f3\u00e2\3\2\2\2\u00f3"+
		"\u00e4\3\2\2\2\u00f3\u00e6\3\2\2\2\u00f3\u00e8\3\2\2\2\u00f3\u00e9\3\2"+
		"\2\2\u00f3\u00ea\3\2\2\2\u00f3\u00eb\3\2\2\2\u00f3\u00ec\3\2\2\2\u00f3"+
		"\u00ed\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f3\u00ef\3\2\2\2\u00f4\u0127\3\2"+
		"\2\2\u00f5\u00f6\f\33\2\2\u00f6\u00f7\7\32\2\2\u00f7\u0126\5,\27\34\u00f8"+
		"\u00f9\f\26\2\2\u00f9\u00fa\t\6\2\2\u00fa\u0126\5,\27\27\u00fb\u00fc\f"+
		"\25\2\2\u00fc\u00fd\t\4\2\2\u00fd\u0126\5,\27\26\u00fe\u00ff\f\24\2\2"+
		"\u00ff\u0100\t\7\2\2\u0100\u0126\5,\27\25\u0101\u0102\f\23\2\2\u0102\u0103"+
		"\t\b\2\2\u0103\u0126\5,\27\24\u0104\u0105\f\22\2\2\u0105\u0106\t\t\2\2"+
		"\u0106\u0126\5,\27\23\u0107\u0108\f\21\2\2\u0108\u0109\t\n\2\2\u0109\u0126"+
		"\5,\27\22\u010a\u010b\f\20\2\2\u010b\u010c\7\25\2\2\u010c\u0126\5,\27"+
		"\21\u010d\u010e\f\17\2\2\u010e\u010f\7\24\2\2\u010f\u0126\5,\27\20\u0110"+
		"\u0111\f\16\2\2\u0111\u0112\7\23\2\2\u0112\u0126\5,\27\17\u0113\u0114"+
		"\f\r\2\2\u0114\u0115\7\16\2\2\u0115\u0126\5,\27\16\u0116\u0117\f\f\2\2"+
		"\u0117\u0118\7\17\2\2\u0118\u0126\5,\27\r\u0119\u011a\f\13\2\2\u011a\u011b"+
		"\7\27\2\2\u011b\u0126\5,\27\13\u011c\u011d\f\36\2\2\u011d\u0126\t\3\2"+
		"\2\u011e\u011f\f\35\2\2\u011f\u0126\5.\30\2\u0120\u0121\f\34\2\2\u0121"+
		"\u0122\7 \2\2\u0122\u0123\5,\27\2\u0123\u0124\7!\2\2\u0124\u0126\3\2\2"+
		"\2\u0125\u00f5\3\2\2\2\u0125\u00f8\3\2\2\2\u0125\u00fb\3\2\2\2\u0125\u00fe"+
		"\3\2\2\2\u0125\u0101\3\2\2\2\u0125\u0104\3\2\2\2\u0125\u0107\3\2\2\2\u0125"+
		"\u010a\3\2\2\2\u0125\u010d\3\2\2\2\u0125\u0110\3\2\2\2\u0125\u0113\3\2"+
		"\2\2\u0125\u0116\3\2\2\2\u0125\u0119\3\2\2\2\u0125\u011c\3\2\2\2\u0125"+
		"\u011e\3\2\2\2\u0125\u0120\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2"+
		"\2\2\u0127\u0128\3\2\2\2\u0128-\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u0133"+
		"\7\36\2\2\u012b\u0130\5,\27\2\u012c\u012d\7\33\2\2\u012d\u012f\5,\27\2"+
		"\u012e\u012c\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131"+
		"\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u012b\3\2\2\2\u0133"+
		"\u0134\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\7\37\2\2\u0136/\3\2\2\2"+
		"\u0137\u0138\b\31\1\2\u0138\u013b\7\67\2\2\u0139\u013b\5\22\n\2\u013a"+
		"\u0137\3\2\2\2\u013a\u0139\3\2\2\2\u013b\u0144\3\2\2\2\u013c\u013d\f\3"+
		"\2\2\u013d\u013f\7 \2\2\u013e\u0140\5,\27\2\u013f\u013e\3\2\2\2\u013f"+
		"\u0140\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0143\7!\2\2\u0142\u013c\3\2"+
		"\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\61\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0149\7\63\2\2\u0148\u014a\5\30"+
		"\r\2\u0149\u0148\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\3\2\2\2\u014b"+
		"\u014c\7\35\2\2\u014c\u014d\5\34\17\2\u014d\u014e\5.\30\2\u014e\63\3\2"+
		"\2\2&\67=CGI]cov{\u0083\u0086\u0090\u0092\u009c\u00a5\u00ab\u00ad\u00b1"+
		"\u00ba\u00c0\u00c4\u00c8\u00ce\u00d2\u00d6\u00db\u00f3\u0125\u0127\u0130"+
		"\u0133\u013a\u013f\u0144\u0149";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}