package Frontend;

import AST.*;
import Util.Type;
import Util.position;
import Grammars.MxStarBaseVisitor;
import Grammars.MxStarParser;

public class ASTBuilder extends MxStarBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitProgram(MxStarParser.ProgramContext ctx){
        RootNode root = new RootNode(new position(ctx));
        ctx.define().forEach(x -> root.define.add((DefineNode) visit(x)));
        return root;
    }

    @Override
    public ASTNode visitClass_def(MxStarParser.Class_defContext ctx) {
        classDefNode classDef = new classDefNode(new position(ctx), ctx.IDENTIFIER().toString());
        if (ctx.constructor_def() != null){
            classDef.constructorDef = (constructorDefNode) visit(ctx.constructor_def());
        }
        ctx.var_def_stmt().forEach(x -> classDef.varDef.add((varDefNode) visit(x)));
        ctx.func_def().forEach(x -> classDef.funcDef.add((funcDefNode) visit(x)));
        return classDef;
    }

    @Override
    public ASTNode visitConstructor_def(MxStarParser.Constructor_defContext ctx) {
        return new constructorDefNode(new position(ctx),
                ctx.IDENTIFIER().toString(), (suiteNode) visit(ctx.suite()));
    }

    @Override
    public ASTNode visitVar_def_stmt(MxStarParser.Var_def_stmtContext ctx) {
        return visit(ctx.var_def());
    }

    @Override
    public ASTNode visitVar_def(MxStarParser.Var_defContext ctx) {
        varDefNode varDef = new varDefNode(new position(ctx), (typeNode) visit(ctx.type()));
        ctx.var_def_arg().forEach(x -> varDef.varDefArg.add((varDefArgNode) visit(x)));
        return varDef;
    }

    @Override
    public ASTNode visitVar_def_arg(MxStarParser.Var_def_argContext ctx) {
        if (ctx.expr() == null)
            return new varDefArgNode(new position(ctx), ctx.IDENTIFIER().toString());
        else return new varDefArgNode(new position(ctx), ctx.IDENTIFIER().toString(), (ExprNode) visit(ctx.expr()));
    }

    @Override
    public ASTNode visitFunc_def(MxStarParser.Func_defContext ctx) {
        return new funcDefNode(new position(ctx), (funcTypeNode) visit(ctx.func_type()), ctx.IDENTIFIER().toString(),
                (parameterListNode) visit(ctx.parameter_list()), (suiteNode) visit(ctx.suite()));
    }

    @Override
    public ASTNode visitBasic_type(MxStarParser.Basic_typeContext ctx) {
        if (ctx.BOOL() != null)
            return new basicTypeNode(new position(ctx), Type.typeToken.BOOL);
        else if (ctx.INT() != null)
            return new basicTypeNode(new position(ctx), Type.typeToken.INT);
        else{
            assert(ctx.STRING() != null);
            return new basicTypeNode(new position(ctx), Type.typeToken.STRING);
        }
    }

    @Override
    public ASTNode visitType(MxStarParser.TypeContext ctx) {
        assert(ctx.OPEN_BRACK().size() == ctx.CLOSE_BRACK().size());
        if (ctx.IDENTIFIER() != null){
            return new typeNode(new position(ctx), ctx.IDENTIFIER().toString(), null, ctx.OPEN_BRACK().size());
        } else {
            return new typeNode(new position(ctx), null, (basicTypeNode) visit(ctx.basic_type()), ctx.OPEN_BRACK().size());
        }
    }

    @Override
    public ASTNode visitFunc_type(MxStarParser.Func_typeContext ctx) {
        if (ctx.VOID() != null){
            return new funcTypeNode(new position(ctx), true);
        } else {
            return new funcTypeNode(new position(ctx), false, (typeNode) visit(ctx.type()));
        }
    }

    @Override
    public ASTNode visitParameter_list(MxStarParser.Parameter_listContext ctx) {
        parameterListNode parameterList = new parameterListNode(new position(ctx));
        ctx.parameter().forEach(x -> parameterList.parameter.add((parameterNode) visit(x)));
        return parameterList;
    }

    @Override
    public ASTNode visitParameter(MxStarParser.ParameterContext ctx) {
        return new parameterNode(new position(ctx), (typeNode) visit(ctx.type()), ctx.IDENTIFIER().toString());
    }

    @Override
    public ASTNode visitGlobal_var_def_stmt(MxStarParser.Global_var_def_stmtContext ctx) {
        return new globalVarDefNode(new position(ctx), (varDefNode) visit(ctx.var_def()));
    }

    @Override
    public ASTNode visitSuite(MxStarParser.SuiteContext ctx) {
        suiteNode suite = new suiteNode(new position(ctx));
        ctx.block().forEach(x -> suite.block.add((blockNode) visit(x)));
        return suite;
    }

    @Override
    public ASTNode visitStmt(MxStarParser.StmtContext ctx) {
        if (ctx.var_def_stmt() != null){
            return visit(ctx.var_def_stmt());
        } else if (ctx.expr_stmt() != null){
            return visit(ctx.expr_stmt());
        } else if (ctx.if_stmt() != null){
            return visit(ctx.if_stmt());
        } else if (ctx.loop_stmt() != null){
            return visit(ctx.loop_stmt());
        } else {
            return visit(ctx.flow_stmt());
        }
    }

    @Override
    public ASTNode visitBlock(MxStarParser.BlockContext ctx) {
        suiteNode suite = ctx.suite() != null ? (suiteNode) visit(ctx.suite()) : null;
        StmtNode stmt = ctx.stmt() != null ? (StmtNode) visit(ctx.stmt()) : null;
        return new blockNode(new position(ctx), suite, stmt);
    }

    @Override
    public ASTNode visitIf_stmt(MxStarParser.If_stmtContext ctx) {
        elseStmtNode elseStmt = ctx.else_stmt() != null ? (elseStmtNode) visit(ctx.else_stmt()) : null;
        return new ifStmtNode(new position(ctx), (ExprNode) visit(ctx.expr()), (blockNode) visit(ctx.block()), elseStmt);
    }

    @Override
    public ASTNode visitElse_stmt(MxStarParser.Else_stmtContext ctx) {
        return new elseStmtNode(new position(ctx), (blockNode) visit(ctx.block()));
    }

    @Override
    public ASTNode visitLoop_stmt(MxStarParser.Loop_stmtContext ctx) {
        if (ctx.while_stmt() != null)
            return visit(ctx.while_stmt());
        else return visit(ctx.for_stmt());
    }

    @Override
    public ASTNode visitWhile_stmt(MxStarParser.While_stmtContext ctx) {
        return new whileStmtNode(new position(ctx), (ExprNode) visit(ctx.expr()), (blockNode) visit(ctx.block()));
    }

    @Override
    public ASTNode visitFor_stmt(MxStarParser.For_stmtContext ctx) {
        forInitNode forInit = ctx.for_init() != null ? (forInitNode) visit(ctx.for_init()) : null;
        forStopNode forStop = ctx.for_stop() != null ? (forStopNode) visit(ctx.for_stop()) : null;
        ExprNode expr = ctx.expr() != null ? (ExprNode) visit(ctx.expr()) : null;
        return new forStmtNode(new position(ctx), forInit, forStop, expr, (blockNode) visit(ctx.block()));
    }

    @Override
    public ASTNode visitFor_init(MxStarParser.For_initContext ctx) {
        if (ctx.var_def() != null)
            return new forInitNode(new position(ctx), (varDefNode) visit(ctx.var_def()), null);
        else return new forInitNode(new position(ctx), null, (ExprNode) visit(ctx.expr()));
    }

    @Override
    public ASTNode visitFor_stop(MxStarParser.For_stopContext ctx) {
        return new forStopNode(new position(ctx), (ExprNode) visit(ctx.expr()));
    }

    @Override
    public ASTNode visitFlow_stmt(MxStarParser.Flow_stmtContext ctx) {
        if (ctx.return_stmt() != null)
            return visit(ctx.return_stmt());
        else if (ctx.break_stmt() != null)
            return visit(ctx.break_stmt());
        else return visit(ctx.continue_stmt());
    }

    @Override
    public ASTNode visitReturn_stmt(MxStarParser.Return_stmtContext ctx) {
        return new returnStmtNode(new position(ctx), ctx.expr() != null ? (ExprNode) visit(ctx.expr()) : null);
    }

    @Override
    public ASTNode visitBreak_stmt(MxStarParser.Break_stmtContext ctx) {
        return new breakStmtNode(new position(ctx));
    }

    @Override
    public ASTNode visitContinue_stmt(MxStarParser.Continue_stmtContext ctx) {
        return new continueStmtNode(new position(ctx));
    }

    @Override
    public ASTNode visitExpr_stmt(MxStarParser.Expr_stmtContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ASTNode visitFuncCallExpr(MxStarParser.FuncCallExprContext ctx) {
        return new funcCallExprNode(new position(ctx), (ExprNode) visit(ctx.expr()), (argListNode) visit(ctx.arg_list()));
    }

    @Override
    public ASTNode visitLambdaExpr(MxStarParser.LambdaExprContext ctx) {
        return visit(ctx.lambda_stmt());
    }

    @Override
    public ASTNode visitArrayExpr(MxStarParser.ArrayExprContext ctx) {
        return new arrayExprNode(new position(ctx), (ExprNode) visit(ctx.expr(0)), (ExprNode) visit(ctx.expr(1)));
    }

    @Override
    public ASTNode visitBinaryExpr(MxStarParser.BinaryExprContext ctx) {
        binaryExprNode binaryExpr = new binaryExprNode(new position(ctx), null, (ExprNode) visit(ctx.expr(0)), (ExprNode) visit(ctx.expr(1)));
        if (ctx.DOT() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.DOT;
        else if (ctx.STAR() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.STAR;
        else if (ctx.DIV() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.DIV;
        else if (ctx.MOD() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.MOD;
        else if (ctx.PLUS() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.PLUS;
        else if (ctx.MINUS() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.MINUS;
        else if (ctx.LEFT_SHIFT() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.LEFT_SHIFT;
        else if (ctx.RIGHT_SHIFT() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.RIGHT_SHIFT;
        else if (ctx.LESS_THAN() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.LESS_THAN;
        else if (ctx.GREATER_THAN() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.GREATER_THAN;
        else if (ctx.LT_EQ() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.LT_EQ;
        else if (ctx.GT_EQ() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.GT_EQ;
        else if (ctx.EQUALS() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.EQUALS;
        else if (ctx.NOT_EQ() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.NOT_EQ;
        else if (ctx.AND_OP() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.AND_OP;
        else if (ctx.XOR_OP() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.XOR_OP;
        else if (ctx.OR_OP() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.OR_OP;
        else if (ctx.AND_LOG() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.AND_LOG;
        else if (ctx.OR_LOG() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.OR_LOG;
        else if (ctx.ASSIGN() != null)
            binaryExpr.binaryOp = binaryExprNode.binaryOpType.ASSIGN;
        return binaryExpr;
    }

    @Override
    public ASTNode visitPreIncDecExpr(MxStarParser.PreIncDecExprContext ctx) {
        if (ctx.PLUS_PLUS() != null)
            return new preIncDecExprNode(new position(ctx), preIncDecExprNode.preIncDecOpType.PLUSPLUS, (ExprNode) visit(ctx.expr()));
        else return new preIncDecExprNode(new position(ctx), preIncDecExprNode.preIncDecOpType.MINUSMINUS, (ExprNode) visit(ctx.expr()));
    }

    @Override
    public ASTNode visitPostIncDecExpr(MxStarParser.PostIncDecExprContext ctx) {
        if (ctx.PLUS_PLUS() != null)
            return new postIncDecExprNode(new position(ctx), postIncDecExprNode.postIncDecOpType.PLUSPLUS, (ExprNode) visit(ctx.expr()));
        else return new postIncDecExprNode(new position(ctx), postIncDecExprNode.postIncDecOpType.MINUSMINUS, (ExprNode) visit(ctx.expr()));
    }

    @Override
    public ASTNode visitUnaryExpr(MxStarParser.UnaryExprContext ctx) {
        unaryExprNode unaryExpr = new unaryExprNode(new position(ctx), null, (ExprNode) visit(ctx.expr()));
        if (ctx.PLUS() != null)
            unaryExpr.unaryOp = unaryExprNode.unaryOpType.PLUS;
        else if (ctx.MINUS() != null)
            unaryExpr.unaryOp = unaryExprNode.unaryOpType.MINUS;
        else if (ctx.NOT_LOG() != null)
            unaryExpr.unaryOp = unaryExprNode.unaryOpType.NOT_LOG;
        else if (ctx.NOT_OP() != null)
            unaryExpr.unaryOp = unaryExprNode.unaryOpType.NOT_OP;
        return unaryExpr;
    }

    @Override
    public ASTNode visitNewExpr(MxStarParser.NewExprContext ctx) {
        return visit(ctx.creator());
    }

    @Override
    public ASTNode visitBracketExpr(MxStarParser.BracketExprContext ctx) {
        return new bracketExprNode(new position(ctx), (ExprNode) visit(ctx.expr()));
    }

    @Override
    public ASTNode visitPrimayExpr(MxStarParser.PrimayExprContext ctx) {
        return visit(ctx.primary());
    }

    @Override
    public ASTNode visitPrimary(MxStarParser.PrimaryContext ctx) {
        if (ctx.THIS() != null)
            return new primaryNode(new position(ctx), primaryNode.primaryTypeToken.THIS, null);
        else if (ctx.NULL() != null)
            return new primaryNode(new position(ctx), primaryNode.primaryTypeToken.NULL, null);
        else if (ctx.INT_LITERAL() != null)
            return new primaryNode(new position(ctx), primaryNode.primaryTypeToken.INT, ctx.INT_LITERAL().toString());
        else if (ctx.BOOL_LITERAL() != null)
            return new primaryNode(new position(ctx), primaryNode.primaryTypeToken.BOOL, ctx.BOOL_LITERAL().toString());
        else if (ctx.STRING_LITERAL() != null)
            return new primaryNode(new position(ctx), primaryNode.primaryTypeToken.STRING, ctx.STRING_LITERAL().toString());
        else return new primaryNode(new position(ctx), primaryNode.primaryTypeToken.IDENTIFIER, ctx.IDENTIFIER().toString());
    }

    @Override
    public ASTNode visitArg_list(MxStarParser.Arg_listContext ctx) {
        argListNode argList = new argListNode(new position(ctx));
        ctx.expr().forEach(x -> argList.expr.add((ExprNode) visit(x)));
        return argList;
    }

    @Override
    public ASTNode visitCreator(MxStarParser.CreatorContext ctx) {
        creatorNode creator;
        if (ctx.IDENTIFIER() != null)
            creator = new creatorNode(new position(ctx), ctx.IDENTIFIER().toString(), null);
        else creator = new creatorNode(new position(ctx), null, (basicTypeNode) visit(ctx.basic_type()));
        ctx.creator_size().forEach(x -> creator.creatorSize.add((creatorSizeNode) visit(x)));
        return creator;
    }

    @Override
    public ASTNode visitCreator_size(MxStarParser.Creator_sizeContext ctx) {
        return new creatorSizeNode(new position(ctx), ctx.expr() != null ? (ExprNode) visit(ctx.expr()) : null);
    }

    @Override
    public ASTNode visitLambda_stmt(MxStarParser.Lambda_stmtContext ctx) {
        parameterListNode parameterList = ctx.parameter_list() != null ? (parameterListNode) visit(ctx.parameter_list()) : null;
        return new lambdaStmtNode(new position(ctx), parameterList, (suiteNode) visit(ctx.suite()), (argListNode) visit(ctx.arg_list()));
    }
}