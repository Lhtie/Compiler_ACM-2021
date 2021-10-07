// Generated from C:/Users/lhtie/Documents/Repos/Compiler_ACM-2022/src/grammars-antlr4\MxStar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxStarParser}.
 */
public interface MxStarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxStarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxStarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxStarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#define}.
	 * @param ctx the parse tree
	 */
	void enterDefine(MxStarParser.DefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#define}.
	 * @param ctx the parse tree
	 */
	void exitDefine(MxStarParser.DefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#class_def}.
	 * @param ctx the parse tree
	 */
	void enterClass_def(MxStarParser.Class_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#class_def}.
	 * @param ctx the parse tree
	 */
	void exitClass_def(MxStarParser.Class_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#constructor_def}.
	 * @param ctx the parse tree
	 */
	void enterConstructor_def(MxStarParser.Constructor_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#constructor_def}.
	 * @param ctx the parse tree
	 */
	void exitConstructor_def(MxStarParser.Constructor_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#main_suite}.
	 * @param ctx the parse tree
	 */
	void enterMain_suite(MxStarParser.Main_suiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#main_suite}.
	 * @param ctx the parse tree
	 */
	void exitMain_suite(MxStarParser.Main_suiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#var_def_stmt}.
	 * @param ctx the parse tree
	 */
	void enterVar_def_stmt(MxStarParser.Var_def_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#var_def_stmt}.
	 * @param ctx the parse tree
	 */
	void exitVar_def_stmt(MxStarParser.Var_def_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#var_def}.
	 * @param ctx the parse tree
	 */
	void enterVar_def(MxStarParser.Var_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#var_def}.
	 * @param ctx the parse tree
	 */
	void exitVar_def(MxStarParser.Var_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#var_def_arg}.
	 * @param ctx the parse tree
	 */
	void enterVar_def_arg(MxStarParser.Var_def_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#var_def_arg}.
	 * @param ctx the parse tree
	 */
	void exitVar_def_arg(MxStarParser.Var_def_argContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#func_def}.
	 * @param ctx the parse tree
	 */
	void enterFunc_def(MxStarParser.Func_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#func_def}.
	 * @param ctx the parse tree
	 */
	void exitFunc_def(MxStarParser.Func_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#basic_type}.
	 * @param ctx the parse tree
	 */
	void enterBasic_type(MxStarParser.Basic_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#basic_type}.
	 * @param ctx the parse tree
	 */
	void exitBasic_type(MxStarParser.Basic_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MxStarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MxStarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#func_type}.
	 * @param ctx the parse tree
	 */
	void enterFunc_type(MxStarParser.Func_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#func_type}.
	 * @param ctx the parse tree
	 */
	void exitFunc_type(MxStarParser.Func_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParameter_list(MxStarParser.Parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParameter_list(MxStarParser.Parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MxStarParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MxStarParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(MxStarParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(MxStarParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(MxStarParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(MxStarParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(MxStarParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(MxStarParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#loop_stmt}.
	 * @param ctx the parse tree
	 */
	void enterLoop_stmt(MxStarParser.Loop_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#loop_stmt}.
	 * @param ctx the parse tree
	 */
	void exitLoop_stmt(MxStarParser.Loop_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(MxStarParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(MxStarParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(MxStarParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(MxStarParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#flow_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFlow_stmt(MxStarParser.Flow_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#flow_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFlow_stmt(MxStarParser.Flow_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stmt(MxStarParser.Expr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stmt(MxStarParser.Expr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MxStarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MxStarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArg_list(MxStarParser.Arg_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArg_list(MxStarParser.Arg_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(MxStarParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(MxStarParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#lambda_stmt}.
	 * @param ctx the parse tree
	 */
	void enterLambda_stmt(MxStarParser.Lambda_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#lambda_stmt}.
	 * @param ctx the parse tree
	 */
	void exitLambda_stmt(MxStarParser.Lambda_stmtContext ctx);
}