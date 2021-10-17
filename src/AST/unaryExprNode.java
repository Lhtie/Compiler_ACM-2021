package AST;

import Util.position;

public class unaryExprNode extends ExprNode{
    public enum unaryOpType{
        PLUS, MINUS, NOT_LOG, NOT_OP
    }

    public unaryOpType unaryOp;
    public ExprNode expr;

    public unaryExprNode(position pos, unaryOpType unaryOp_, ExprNode expr_){
        super(pos);
        unaryOp = unaryOp_;
        expr = expr_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
