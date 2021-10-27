// Generated from C:/Users/lhtie/Documents/Repos/Compiler_ACM-2021/src/Grammars\MxStar.g4 by ANTLR 4.9.1
package Grammars;
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
	 * Enter a parse tree produced by {@link MxStarParser#global_var_def_stmt}.
	 * @param ctx the parse tree
	 */
	void enterGlobal_var_def_stmt(MxStarParser.Global_var_def_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#global_var_def_stmt}.
	 * @param ctx the parse tree
	 */
	void exitGlobal_var_def_stmt(MxStarParser.Global_var_def_stmtContext ctx);
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
	 * Enter a parse tree produced by {@link MxStarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MxStarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MxStarParser.BlockContext ctx);
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
	 * Enter a parse tree produced by {@link MxStarParser#else_stmt}.
	 * @param ctx the parse tree
	 */
	void enterElse_stmt(MxStarParser.Else_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#else_stmt}.
	 * @param ctx the parse tree
	 */
	void exitElse_stmt(MxStarParser.Else_stmtContext ctx);
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
	 * Enter a parse tree produced by {@link MxStarParser#for_init}.
	 * @param ctx the parse tree
	 */
	void enterFor_init(MxStarParser.For_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#for_init}.
	 * @param ctx the parse tree
	 */
	void exitFor_init(MxStarParser.For_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#for_stop}.
	 * @param ctx the parse tree
	 */
	void enterFor_stop(MxStarParser.For_stopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#for_stop}.
	 * @param ctx the parse tree
	 */
	void exitFor_stop(MxStarParser.For_stopContext ctx);
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
	 * Enter a parse tree produced by {@link MxStarParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(MxStarParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(MxStarParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreak_stmt(MxStarParser.Break_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreak_stmt(MxStarParser.Break_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#continue_stmt}.
	 * @param ctx the parse tree
	 */
	void enterContinue_stmt(MxStarParser.Continue_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#continue_stmt}.
	 * @param ctx the parse tree
	 */
	void exitContinue_stmt(MxStarParser.Continue_stmtContext ctx);
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
	 * Enter a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(MxStarParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(MxStarParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postIncDecExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPostIncDecExpr(MxStarParser.PostIncDecExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postIncDecExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPostIncDecExpr(MxStarParser.PostIncDecExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(MxStarParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(MxStarParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(MxStarParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(MxStarParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpr(MxStarParser.LambdaExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpr(MxStarParser.LambdaExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBracketExpr(MxStarParser.BracketExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBracketExpr(MxStarParser.BracketExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code preIncDecExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPreIncDecExpr(MxStarParser.PreIncDecExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code preIncDecExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPreIncDecExpr(MxStarParser.PreIncDecExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(MxStarParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(MxStarParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(MxStarParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(MxStarParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primayExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrimayExpr(MxStarParser.PrimayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primayExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrimayExpr(MxStarParser.PrimayExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MxStarParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MxStarParser.PrimaryContext ctx);
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
	 * Enter a parse tree produced by {@link MxStarParser#creator_size}.
	 * @param ctx the parse tree
	 */
	void enterCreator_size(MxStarParser.Creator_sizeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#creator_size}.
	 * @param ctx the parse tree
	 */
	void exitCreator_size(MxStarParser.Creator_sizeContext ctx);
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