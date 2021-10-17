// Generated from C:/Users/lhtie/Documents/Repos/Compiler_ACM-2021/src/Grammars\MxStar.g4 by ANTLR 4.9.1
package Grammars;
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
		PLUS=1, MINUS=2, STAR=3, DIV=4, MOD=5, LESS_THAN=6, GREATER_THAN=7, EQUALS=8, 
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
		RULE_parameter = 12, RULE_global_var_def_stmt = 13, RULE_suite = 14, RULE_stmt = 15, 
		RULE_block = 16, RULE_if_stmt = 17, RULE_else_stmt = 18, RULE_loop_stmt = 19, 
		RULE_while_stmt = 20, RULE_for_stmt = 21, RULE_for_init = 22, RULE_for_stop = 23, 
		RULE_flow_stmt = 24, RULE_return_stmt = 25, RULE_break_stmt = 26, RULE_continue_stmt = 27, 
		RULE_expr_stmt = 28, RULE_expr = 29, RULE_primary = 30, RULE_arg_list = 31, 
		RULE_creator = 32, RULE_creator_size = 33, RULE_lambda_stmt = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "define", "class_def", "constructor_def", "var_def_stmt", 
			"var_def", "var_def_arg", "func_def", "basic_type", "type", "func_type", 
			"parameter_list", "parameter", "global_var_def_stmt", "suite", "stmt", 
			"block", "if_stmt", "else_stmt", "loop_stmt", "while_stmt", "for_stmt", 
			"for_init", "for_stop", "flow_stmt", "return_stmt", "break_stmt", "continue_stmt", 
			"expr_stmt", "expr", "primary", "arg_list", "creator", "creator_size", 
			"lambda_stmt"
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
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << VOID) | (1L << CLASS) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(70);
				define();
				}
				}
				setState(75);
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
		public Global_var_def_stmtContext global_var_def_stmt() {
			return getRuleContext(Global_var_def_stmtContext.class,0);
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
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				class_def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				func_def();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				global_var_def_stmt();
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
			setState(81);
			match(CLASS);
			setState(82);
			match(IDENTIFIER);
			setState(83);
			match(OPEN_BRACE);
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(84);
				constructor_def();
				}
				break;
			}
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << VOID) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(89);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(87);
					var_def_stmt();
					}
					break;
				case 2:
					{
					setState(88);
					func_def();
					}
					break;
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(CLOSE_BRACE);
			setState(95);
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
			setState(97);
			match(IDENTIFIER);
			setState(98);
			match(OPEN_PAREN);
			setState(99);
			match(CLOSE_PAREN);
			setState(100);
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
			setState(102);
			var_def();
			setState(103);
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
			setState(105);
			type();
			setState(106);
			var_def_arg();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(107);
				match(COMMA);
				setState(108);
				var_def_arg();
				}
				}
				setState(113);
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
			setState(114);
			match(IDENTIFIER);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(115);
				match(ASSIGN);
				setState(116);
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
			setState(119);
			func_type();
			setState(120);
			match(IDENTIFIER);
			setState(121);
			parameter_list();
			setState(122);
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
			setState(124);
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
		public List<TerminalNode> OPEN_BRACK() { return getTokens(MxStarParser.OPEN_BRACK); }
		public TerminalNode OPEN_BRACK(int i) {
			return getToken(MxStarParser.OPEN_BRACK, i);
		}
		public List<TerminalNode> CLOSE_BRACK() { return getTokens(MxStarParser.CLOSE_BRACK); }
		public TerminalNode CLOSE_BRACK(int i) {
			return getToken(MxStarParser.CLOSE_BRACK, i);
		}
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
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(126);
				match(IDENTIFIER);
				}
				break;
			case INT:
			case BOOL:
			case STRING:
				{
				setState(127);
				basic_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPEN_BRACK) {
				{
				{
				setState(130);
				match(OPEN_BRACK);
				setState(131);
				match(CLOSE_BRACK);
				}
				}
				setState(136);
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
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case STRING:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				type();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
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
			setState(141);
			match(OPEN_PAREN);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(142);
				parameter();
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(143);
					match(COMMA);
					setState(144);
					parameter();
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(152);
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
			setState(154);
			type();
			setState(155);
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

	public static class Global_var_def_stmtContext extends ParserRuleContext {
		public Var_defContext var_def() {
			return getRuleContext(Var_defContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MxStarParser.SEMI, 0); }
		public Global_var_def_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_var_def_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterGlobal_var_def_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitGlobal_var_def_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitGlobal_var_def_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Global_var_def_stmtContext global_var_def_stmt() throws RecognitionException {
		Global_var_def_stmtContext _localctx = new Global_var_def_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_global_var_def_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			var_def();
			setState(158);
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

	public static class SuiteContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(MxStarParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(MxStarParser.CLOSE_BRACE, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
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
			setState(160);
			match(OPEN_BRACE);
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case NOT_LOG:
			case NOT_OP:
			case PLUS_PLUS:
			case MINUS_MINUS:
			case SEMI:
			case OPEN_PAREN:
			case CLOSE_BRACE:
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
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << SEMI) | (1L << OPEN_PAREN) | (1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << NULL) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CONITNUE) | (1L << RETURN) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(161);
					stmt();
					}
					}
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case OPEN_BRACE:
				{
				setState(167);
				suite();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(170);
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
		public TerminalNode SEMI() { return getToken(MxStarParser.SEMI, 0); }
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
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				var_def_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				expr_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				if_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(175);
				loop_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(176);
				flow_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(177);
				match(SEMI);
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

	public static class BlockContext extends ParserRuleContext {
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MxStarParser.SEMI, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_block);
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				suite();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				match(SEMI);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Else_stmtContext else_stmt() {
			return getRuleContext(Else_stmtContext.class,0);
		}
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
		enterRule(_localctx, 34, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(IF);
			setState(186);
			match(OPEN_PAREN);
			setState(187);
			expr(0);
			setState(188);
			match(CLOSE_PAREN);
			setState(189);
			block();
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(190);
				else_stmt();
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

	public static class Else_stmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MxStarParser.ELSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Else_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterElse_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitElse_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitElse_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_stmtContext else_stmt() throws RecognitionException {
		Else_stmtContext _localctx = new Else_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_else_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(ELSE);
			setState(194);
			block();
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
		enterRule(_localctx, 38, RULE_loop_stmt);
		try {
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				while_stmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
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
		enterRule(_localctx, 40, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(WHILE);
			setState(201);
			match(OPEN_PAREN);
			setState(202);
			expr(0);
			setState(203);
			match(CLOSE_PAREN);
			setState(204);
			block();
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public For_initContext for_init() {
			return getRuleContext(For_initContext.class,0);
		}
		public For_stopContext for_stop() {
			return getRuleContext(For_stopContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		enterRule(_localctx, 42, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(FOR);
			setState(207);
			match(OPEN_PAREN);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(208);
				for_init();
				}
			}

			setState(211);
			match(SEMI);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(212);
				for_stop();
				}
			}

			setState(215);
			match(SEMI);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(216);
				expr(0);
				}
			}

			setState(219);
			match(CLOSE_PAREN);
			setState(220);
			block();
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

	public static class For_initContext extends ParserRuleContext {
		public Var_defContext var_def() {
			return getRuleContext(Var_defContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public For_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFor_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFor_init(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFor_init(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_initContext for_init() throws RecognitionException {
		For_initContext _localctx = new For_initContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_for_init);
		try {
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				var_def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				expr(0);
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

	public static class For_stopContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public For_stopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFor_stop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFor_stop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFor_stop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stopContext for_stop() throws RecognitionException {
		For_stopContext _localctx = new For_stopContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_for_stop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			expr(0);
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
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Break_stmtContext break_stmt() {
			return getRuleContext(Break_stmtContext.class,0);
		}
		public Continue_stmtContext continue_stmt() {
			return getRuleContext(Continue_stmtContext.class,0);
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
		enterRule(_localctx, 48, RULE_flow_stmt);
		try {
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				return_stmt();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				break_stmt();
				}
				break;
			case CONITNUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(230);
				continue_stmt();
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

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MxStarParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(MxStarParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitReturn_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitReturn_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_return_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(RETURN);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(234);
				expr(0);
				}
			}

			setState(237);
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

	public static class Break_stmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(MxStarParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(MxStarParser.SEMI, 0); }
		public Break_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBreak_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBreak_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBreak_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Break_stmtContext break_stmt() throws RecognitionException {
		Break_stmtContext _localctx = new Break_stmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_break_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(BREAK);
			setState(240);
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

	public static class Continue_stmtContext extends ParserRuleContext {
		public TerminalNode CONITNUE() { return getToken(MxStarParser.CONITNUE, 0); }
		public TerminalNode SEMI() { return getToken(MxStarParser.SEMI, 0); }
		public Continue_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continue_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterContinue_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitContinue_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitContinue_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Continue_stmtContext continue_stmt() throws RecognitionException {
		Continue_stmtContext _localctx = new Continue_stmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_continue_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(CONITNUE);
			setState(243);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MxStarParser.SEMI, 0); }
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
		enterRule(_localctx, 56, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			expr(0);
			setState(246);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PostIncDecExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PLUS_PLUS() { return getToken(MxStarParser.PLUS_PLUS, 0); }
		public TerminalNode MINUS_MINUS() { return getToken(MxStarParser.MINUS_MINUS, 0); }
		public PostIncDecExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPostIncDecExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPostIncDecExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPostIncDecExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewExprContext extends ExprContext {
		public TerminalNode NEW() { return getToken(MxStarParser.NEW, 0); }
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public NewExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitNewExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitNewExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(MxStarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MxStarParser.MINUS, 0); }
		public TerminalNode NOT_LOG() { return getToken(MxStarParser.NOT_LOG, 0); }
		public TerminalNode NOT_OP() { return getToken(MxStarParser.NOT_OP, 0); }
		public UnaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPEN_BRACK() { return getToken(MxStarParser.OPEN_BRACK, 0); }
		public TerminalNode CLOSE_BRACK() { return getToken(MxStarParser.CLOSE_BRACK, 0); }
		public ArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaExprContext extends ExprContext {
		public Lambda_stmtContext lambda_stmt() {
			return getRuleContext(Lambda_stmtContext.class,0);
		}
		public LambdaExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterLambdaExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitLambdaExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitLambdaExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketExprContext extends ExprContext {
		public TerminalNode OPEN_PAREN() { return getToken(MxStarParser.OPEN_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(MxStarParser.CLOSE_PAREN, 0); }
		public BracketExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBracketExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBracketExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBracketExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreIncDecExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PLUS_PLUS() { return getToken(MxStarParser.PLUS_PLUS, 0); }
		public TerminalNode MINUS_MINUS() { return getToken(MxStarParser.MINUS_MINUS, 0); }
		public PreIncDecExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPreIncDecExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPreIncDecExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPreIncDecExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DOT() { return getToken(MxStarParser.DOT, 0); }
		public TerminalNode STAR() { return getToken(MxStarParser.STAR, 0); }
		public TerminalNode DIV() { return getToken(MxStarParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MxStarParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(MxStarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MxStarParser.MINUS, 0); }
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
		public BinaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public FuncCallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFuncCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFuncCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFuncCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimayExprContext extends ExprContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPrimayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPrimayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPrimayExpr(this);
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LAMBDA_HEAD:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(249);
				lambda_stmt();
				}
				break;
			case PLUS_PLUS:
			case MINUS_MINUS:
				{
				_localctx = new PostIncDecExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(250);
				_la = _input.LA(1);
				if ( !(_la==PLUS_PLUS || _la==MINUS_MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(251);
				expr(18);
				}
				break;
			case PLUS:
			case MINUS:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(253);
				expr(17);
				}
				break;
			case NOT_LOG:
			case NOT_OP:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(254);
				_la = _input.LA(1);
				if ( !(_la==NOT_LOG || _la==NOT_OP) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(255);
				expr(16);
				}
				break;
			case NEW:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				match(NEW);
				setState(257);
				creator();
				}
				break;
			case OPEN_PAREN:
				{
				_localctx = new BracketExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258);
				match(OPEN_PAREN);
				setState(259);
				expr(0);
				setState(260);
				match(CLOSE_PAREN);
				}
				break;
			case NULL:
			case THIS:
			case BOOL_LITERAL:
			case INT_LITERAL:
			case STRING_LITERAL:
			case IDENTIFIER:
				{
				_localctx = new PrimayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(262);
				primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(315);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(313);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(265);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(266);
						match(DOT);
						setState(267);
						expr(20);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(268);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(269);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(270);
						expr(15);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(271);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(272);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(273);
						expr(14);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(274);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(275);
						_la = _input.LA(1);
						if ( !(_la==LEFT_SHIFT || _la==RIGHT_SHIFT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(276);
						expr(13);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(277);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(278);
						_la = _input.LA(1);
						if ( !(_la==LESS_THAN || _la==GREATER_THAN) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(279);
						expr(12);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(280);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(281);
						_la = _input.LA(1);
						if ( !(_la==GT_EQ || _la==LT_EQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(282);
						expr(11);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(283);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(284);
						_la = _input.LA(1);
						if ( !(_la==EQUALS || _la==NOT_EQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(285);
						expr(10);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(286);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(287);
						match(AND_OP);
						setState(288);
						expr(9);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(289);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(290);
						match(XOR_OP);
						setState(291);
						expr(8);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(292);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(293);
						match(OR_OP);
						setState(294);
						expr(7);
						}
						break;
					case 11:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(295);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(296);
						match(AND_LOG);
						setState(297);
						expr(6);
						}
						break;
					case 12:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(298);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(299);
						match(OR_LOG);
						setState(300);
						expr(5);
						}
						break;
					case 13:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(301);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(302);
						match(ASSIGN);
						setState(303);
						expr(3);
						}
						break;
					case 14:
						{
						_localctx = new PreIncDecExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(304);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(305);
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
						_localctx = new FuncCallExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(306);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(307);
						arg_list();
						}
						break;
					case 16:
						{
						_localctx = new ArrayExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(308);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(309);
						match(OPEN_BRACK);
						setState(310);
						expr(0);
						setState(311);
						match(CLOSE_BRACK);
						}
						break;
					}
					} 
				}
				setState(317);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode THIS() { return getToken(MxStarParser.THIS, 0); }
		public TerminalNode NULL() { return getToken(MxStarParser.NULL, 0); }
		public TerminalNode INT_LITERAL() { return getToken(MxStarParser.INT_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(MxStarParser.BOOL_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(MxStarParser.STRING_LITERAL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MxStarParser.IDENTIFIER, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << THIS) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) ) {
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
		enterRule(_localctx, 62, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(OPEN_PAREN);
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(321);
				expr(0);
				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(322);
					match(COMMA);
					setState(323);
					expr(0);
					}
					}
					setState(328);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(331);
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
		public List<Creator_sizeContext> creator_size() {
			return getRuleContexts(Creator_sizeContext.class);
		}
		public Creator_sizeContext creator_size(int i) {
			return getRuleContext(Creator_sizeContext.class,i);
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
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_creator);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(333);
				match(IDENTIFIER);
				}
				break;
			case INT:
			case BOOL:
			case STRING:
				{
				setState(334);
				basic_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(340);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(337);
					creator_size();
					}
					} 
				}
				setState(342);
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
			exitRule();
		}
		return _localctx;
	}

	public static class Creator_sizeContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACK() { return getToken(MxStarParser.OPEN_BRACK, 0); }
		public TerminalNode CLOSE_BRACK() { return getToken(MxStarParser.CLOSE_BRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Creator_sizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator_size; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterCreator_size(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitCreator_size(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitCreator_size(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Creator_sizeContext creator_size() throws RecognitionException {
		Creator_sizeContext _localctx = new Creator_sizeContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_creator_size);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(OPEN_BRACK);
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT_LOG) | (1L << NOT_OP) | (1L << PLUS_PLUS) | (1L << MINUS_MINUS) | (1L << OPEN_PAREN) | (1L << NULL) | (1L << NEW) | (1L << THIS) | (1L << LAMBDA_HEAD) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(344);
				expr(0);
				}
			}

			setState(347);
			match(CLOSE_BRACK);
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
		enterRule(_localctx, 68, RULE_lambda_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(LAMBDA_HEAD);
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAREN) {
				{
				setState(350);
				parameter_list();
				}
			}

			setState(353);
			match(ARROW);
			setState(354);
			suite();
			setState(355);
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
		case 29:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 23);
		case 14:
			return precpred(_ctx, 22);
		case 15:
			return precpred(_ctx, 20);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u0168\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\7\2J\n\2\f\2\16\2M\13\2\3\3\3\3\3\3\5\3R\n"+
		"\3\3\4\3\4\3\4\3\4\5\4X\n\4\3\4\3\4\7\4\\\n\4\f\4\16\4_\13\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7p\n\7\f\7\16\7s"+
		"\13\7\3\b\3\b\3\b\5\bx\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\5\13"+
		"\u0083\n\13\3\13\3\13\7\13\u0087\n\13\f\13\16\13\u008a\13\13\3\f\3\f\5"+
		"\f\u008e\n\f\3\r\3\r\3\r\3\r\7\r\u0094\n\r\f\r\16\r\u0097\13\r\5\r\u0099"+
		"\n\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\7\20\u00a5\n\20\f"+
		"\20\16\20\u00a8\13\20\3\20\5\20\u00ab\n\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u00b5\n\21\3\22\3\22\3\22\5\22\u00ba\n\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00c2\n\23\3\24\3\24\3\24\3\25\3\25\5\25\u00c9"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\5\27\u00d4\n\27\3\27"+
		"\3\27\5\27\u00d8\n\27\3\27\3\27\5\27\u00dc\n\27\3\27\3\27\3\27\3\30\3"+
		"\30\5\30\u00e3\n\30\3\31\3\31\3\32\3\32\3\32\5\32\u00ea\n\32\3\33\3\33"+
		"\5\33\u00ee\n\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\5\37\u010a\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u013c\n\37\f\37"+
		"\16\37\u013f\13\37\3 \3 \3!\3!\3!\3!\7!\u0147\n!\f!\16!\u014a\13!\5!\u014c"+
		"\n!\3!\3!\3\"\3\"\5\"\u0152\n\"\3\"\7\"\u0155\n\"\f\"\16\"\u0158\13\""+
		"\3#\3#\5#\u015c\n#\3#\3#\3$\3$\5$\u0162\n$\3$\3$\3$\3$\3$\2\3<%\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\f\3\2"+
		"$&\3\2\30\31\3\2\3\4\4\2\20\20\26\26\3\2\5\7\3\2\21\22\3\2\b\t\3\2\13"+
		"\f\4\2\n\n\r\r\5\2\'\'\62\62\64\67\2\u017f\2K\3\2\2\2\4Q\3\2\2\2\6S\3"+
		"\2\2\2\bc\3\2\2\2\nh\3\2\2\2\fk\3\2\2\2\16t\3\2\2\2\20y\3\2\2\2\22~\3"+
		"\2\2\2\24\u0082\3\2\2\2\26\u008d\3\2\2\2\30\u008f\3\2\2\2\32\u009c\3\2"+
		"\2\2\34\u009f\3\2\2\2\36\u00a2\3\2\2\2 \u00b4\3\2\2\2\"\u00b9\3\2\2\2"+
		"$\u00bb\3\2\2\2&\u00c3\3\2\2\2(\u00c8\3\2\2\2*\u00ca\3\2\2\2,\u00d0\3"+
		"\2\2\2.\u00e2\3\2\2\2\60\u00e4\3\2\2\2\62\u00e9\3\2\2\2\64\u00eb\3\2\2"+
		"\2\66\u00f1\3\2\2\28\u00f4\3\2\2\2:\u00f7\3\2\2\2<\u0109\3\2\2\2>\u0140"+
		"\3\2\2\2@\u0142\3\2\2\2B\u0151\3\2\2\2D\u0159\3\2\2\2F\u015f\3\2\2\2H"+
		"J\5\4\3\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\3\3\2\2\2MK\3\2\2\2"+
		"NR\5\6\4\2OR\5\20\t\2PR\5\34\17\2QN\3\2\2\2QO\3\2\2\2QP\3\2\2\2R\5\3\2"+
		"\2\2ST\7\61\2\2TU\7\67\2\2UW\7\"\2\2VX\5\b\5\2WV\3\2\2\2WX\3\2\2\2X]\3"+
		"\2\2\2Y\\\5\n\6\2Z\\\5\20\t\2[Y\3\2\2\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2"+
		"]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7#\2\2ab\7\34\2\2b\7\3\2\2\2cd\7\67\2"+
		"\2de\7\36\2\2ef\7\37\2\2fg\5\36\20\2g\t\3\2\2\2hi\5\f\7\2ij\7\34\2\2j"+
		"\13\3\2\2\2kl\5\24\13\2lq\5\16\b\2mn\7\33\2\2np\5\16\b\2om\3\2\2\2ps\3"+
		"\2\2\2qo\3\2\2\2qr\3\2\2\2r\r\3\2\2\2sq\3\2\2\2tw\7\67\2\2uv\7\27\2\2"+
		"vx\5<\37\2wu\3\2\2\2wx\3\2\2\2x\17\3\2\2\2yz\5\26\f\2z{\7\67\2\2{|\5\30"+
		"\r\2|}\5\36\20\2}\21\3\2\2\2~\177\t\2\2\2\177\23\3\2\2\2\u0080\u0083\7"+
		"\67\2\2\u0081\u0083\5\22\n\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083"+
		"\u0088\3\2\2\2\u0084\u0085\7 \2\2\u0085\u0087\7!\2\2\u0086\u0084\3\2\2"+
		"\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\25"+
		"\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008e\5\24\13\2\u008c\u008e\7(\2\2"+
		"\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\27\3\2\2\2\u008f\u0098"+
		"\7\36\2\2\u0090\u0095\5\32\16\2\u0091\u0092\7\33\2\2\u0092\u0094\5\32"+
		"\16\2\u0093\u0091\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0090\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\7\37\2\2\u009b"+
		"\31\3\2\2\2\u009c\u009d\5\24\13\2\u009d\u009e\7\67\2\2\u009e\33\3\2\2"+
		"\2\u009f\u00a0\5\f\7\2\u00a0\u00a1\7\34\2\2\u00a1\35\3\2\2\2\u00a2\u00aa"+
		"\7\"\2\2\u00a3\u00a5\5 \21\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00ab\3\2\2\2\u00a8\u00a6\3\2"+
		"\2\2\u00a9\u00ab\5\36\20\2\u00aa\u00a6\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\u00ad\7#\2\2\u00ad\37\3\2\2\2\u00ae\u00b5\5\n\6\2"+
		"\u00af\u00b5\5:\36\2\u00b0\u00b5\5$\23\2\u00b1\u00b5\5(\25\2\u00b2\u00b5"+
		"\5\62\32\2\u00b3\u00b5\7\34\2\2\u00b4\u00ae\3\2\2\2\u00b4\u00af\3\2\2"+
		"\2\u00b4\u00b0\3\2\2\2\u00b4\u00b1\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b3"+
		"\3\2\2\2\u00b5!\3\2\2\2\u00b6\u00ba\5\36\20\2\u00b7\u00ba\5 \21\2\u00b8"+
		"\u00ba\7\34\2\2\u00b9\u00b6\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3"+
		"\2\2\2\u00ba#\3\2\2\2\u00bb\u00bc\7)\2\2\u00bc\u00bd\7\36\2\2\u00bd\u00be"+
		"\5<\37\2\u00be\u00bf\7\37\2\2\u00bf\u00c1\5\"\22\2\u00c0\u00c2\5&\24\2"+
		"\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2%\3\2\2\2\u00c3\u00c4\7"+
		"*\2\2\u00c4\u00c5\5\"\22\2\u00c5\'\3\2\2\2\u00c6\u00c9\5*\26\2\u00c7\u00c9"+
		"\5,\27\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9)\3\2\2\2\u00ca"+
		"\u00cb\7,\2\2\u00cb\u00cc\7\36\2\2\u00cc\u00cd\5<\37\2\u00cd\u00ce\7\37"+
		"\2\2\u00ce\u00cf\5\"\22\2\u00cf+\3\2\2\2\u00d0\u00d1\7+\2\2\u00d1\u00d3"+
		"\7\36\2\2\u00d2\u00d4\5.\30\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2"+
		"\u00d4\u00d5\3\2\2\2\u00d5\u00d7\7\34\2\2\u00d6\u00d8\5\60\31\2\u00d7"+
		"\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\7\34"+
		"\2\2\u00da\u00dc\5<\37\2\u00db\u00da\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00dd\3\2\2\2\u00dd\u00de\7\37\2\2\u00de\u00df\5\"\22\2\u00df-\3\2\2"+
		"\2\u00e0\u00e3\5\f\7\2\u00e1\u00e3\5<\37\2\u00e2\u00e0\3\2\2\2\u00e2\u00e1"+
		"\3\2\2\2\u00e3/\3\2\2\2\u00e4\u00e5\5<\37\2\u00e5\61\3\2\2\2\u00e6\u00ea"+
		"\5\64\33\2\u00e7\u00ea\5\66\34\2\u00e8\u00ea\58\35\2\u00e9\u00e6\3\2\2"+
		"\2\u00e9\u00e7\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\63\3\2\2\2\u00eb\u00ed"+
		"\7/\2\2\u00ec\u00ee\5<\37\2\u00ed\u00ec\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00f0\7\34\2\2\u00f0\65\3\2\2\2\u00f1\u00f2\7-\2"+
		"\2\u00f2\u00f3\7\34\2\2\u00f3\67\3\2\2\2\u00f4\u00f5\7.\2\2\u00f5\u00f6"+
		"\7\34\2\2\u00f69\3\2\2\2\u00f7\u00f8\5<\37\2\u00f8\u00f9\7\34\2\2\u00f9"+
		";\3\2\2\2\u00fa\u00fb\b\37\1\2\u00fb\u010a\5F$\2\u00fc\u00fd\t\3\2\2\u00fd"+
		"\u010a\5<\37\24\u00fe\u00ff\t\4\2\2\u00ff\u010a\5<\37\23\u0100\u0101\t"+
		"\5\2\2\u0101\u010a\5<\37\22\u0102\u0103\7\60\2\2\u0103\u010a\5B\"\2\u0104"+
		"\u0105\7\36\2\2\u0105\u0106\5<\37\2\u0106\u0107\7\37\2\2\u0107\u010a\3"+
		"\2\2\2\u0108\u010a\5> \2\u0109\u00fa\3\2\2\2\u0109\u00fc\3\2\2\2\u0109"+
		"\u00fe\3\2\2\2\u0109\u0100\3\2\2\2\u0109\u0102\3\2\2\2\u0109\u0104\3\2"+
		"\2\2\u0109\u0108\3\2\2\2\u010a\u013d\3\2\2\2\u010b\u010c\f\25\2\2\u010c"+
		"\u010d\7\32\2\2\u010d\u013c\5<\37\26\u010e\u010f\f\20\2\2\u010f\u0110"+
		"\t\6\2\2\u0110\u013c\5<\37\21\u0111\u0112\f\17\2\2\u0112\u0113\t\4\2\2"+
		"\u0113\u013c\5<\37\20\u0114\u0115\f\16\2\2\u0115\u0116\t\7\2\2\u0116\u013c"+
		"\5<\37\17\u0117\u0118\f\r\2\2\u0118\u0119\t\b\2\2\u0119\u013c\5<\37\16"+
		"\u011a\u011b\f\f\2\2\u011b\u011c\t\t\2\2\u011c\u013c\5<\37\r\u011d\u011e"+
		"\f\13\2\2\u011e\u011f\t\n\2\2\u011f\u013c\5<\37\f\u0120\u0121\f\n\2\2"+
		"\u0121\u0122\7\25\2\2\u0122\u013c\5<\37\13\u0123\u0124\f\t\2\2\u0124\u0125"+
		"\7\24\2\2\u0125\u013c\5<\37\n\u0126\u0127\f\b\2\2\u0127\u0128\7\23\2\2"+
		"\u0128\u013c\5<\37\t\u0129\u012a\f\7\2\2\u012a\u012b\7\16\2\2\u012b\u013c"+
		"\5<\37\b\u012c\u012d\f\6\2\2\u012d\u012e\7\17\2\2\u012e\u013c\5<\37\7"+
		"\u012f\u0130\f\5\2\2\u0130\u0131\7\27\2\2\u0131\u013c\5<\37\5\u0132\u0133"+
		"\f\31\2\2\u0133\u013c\t\3\2\2\u0134\u0135\f\30\2\2\u0135\u013c\5@!\2\u0136"+
		"\u0137\f\26\2\2\u0137\u0138\7 \2\2\u0138\u0139\5<\37\2\u0139\u013a\7!"+
		"\2\2\u013a\u013c\3\2\2\2\u013b\u010b\3\2\2\2\u013b\u010e\3\2\2\2\u013b"+
		"\u0111\3\2\2\2\u013b\u0114\3\2\2\2\u013b\u0117\3\2\2\2\u013b\u011a\3\2"+
		"\2\2\u013b\u011d\3\2\2\2\u013b\u0120\3\2\2\2\u013b\u0123\3\2\2\2\u013b"+
		"\u0126\3\2\2\2\u013b\u0129\3\2\2\2\u013b\u012c\3\2\2\2\u013b\u012f\3\2"+
		"\2\2\u013b\u0132\3\2\2\2\u013b\u0134\3\2\2\2\u013b\u0136\3\2\2\2\u013c"+
		"\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e=\3\2\2\2"+
		"\u013f\u013d\3\2\2\2\u0140\u0141\t\13\2\2\u0141?\3\2\2\2\u0142\u014b\7"+
		"\36\2\2\u0143\u0148\5<\37\2\u0144\u0145\7\33\2\2\u0145\u0147\5<\37\2\u0146"+
		"\u0144\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2"+
		"\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u0143\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\7\37\2\2\u014eA\3\2\2\2"+
		"\u014f\u0152\7\67\2\2\u0150\u0152\5\22\n\2\u0151\u014f\3\2\2\2\u0151\u0150"+
		"\3\2\2\2\u0152\u0156\3\2\2\2\u0153\u0155\5D#\2\u0154\u0153\3\2\2\2\u0155"+
		"\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157C\3\2\2\2"+
		"\u0158\u0156\3\2\2\2\u0159\u015b\7 \2\2\u015a\u015c\5<\37\2\u015b\u015a"+
		"\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\7!\2\2\u015e"+
		"E\3\2\2\2\u015f\u0161\7\63\2\2\u0160\u0162\5\30\r\2\u0161\u0160\3\2\2"+
		"\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\7\35\2\2\u0164"+
		"\u0165\5\36\20\2\u0165\u0166\5@!\2\u0166G\3\2\2\2#KQW[]qw\u0082\u0088"+
		"\u008d\u0095\u0098\u00a6\u00aa\u00b4\u00b9\u00c1\u00c8\u00d3\u00d7\u00db"+
		"\u00e2\u00e9\u00ed\u0109\u013b\u013d\u0148\u014b\u0151\u0156\u015b\u0161";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}