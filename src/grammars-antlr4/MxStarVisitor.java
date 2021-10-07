// Generated from C:/Users/lhtie/Documents/Repos/Compiler_ACM-2022/src/grammars-antlr4\MxStar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxStarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxStarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxStarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxStarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine(MxStarParser.DefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#class_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_def(MxStarParser.Class_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#constructor_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor_def(MxStarParser.Constructor_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#main_suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain_suite(MxStarParser.Main_suiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#var_def_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_def_stmt(MxStarParser.Var_def_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#var_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_def(MxStarParser.Var_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#var_def_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_def_arg(MxStarParser.Var_def_argContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#func_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_def(MxStarParser.Func_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#basic_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasic_type(MxStarParser.Basic_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MxStarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#func_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_type(MxStarParser.Func_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(MxStarParser.Parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MxStarParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(MxStarParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(MxStarParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(MxStarParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#loop_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_stmt(MxStarParser.Loop_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(MxStarParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(MxStarParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#flow_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlow_stmt(MxStarParser.Flow_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#expr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_stmt(MxStarParser.Expr_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MxStarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_list(MxStarParser.Arg_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreator(MxStarParser.CreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#lambda_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_stmt(MxStarParser.Lambda_stmtContext ctx);
}