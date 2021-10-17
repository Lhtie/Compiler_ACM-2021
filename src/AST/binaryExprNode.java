package AST;

import Util.position;

public class binaryExprNode extends ExprNode{
    public enum binaryOpType{
        DOT, STAR, DIV, MOD, PLUS, MINUS, LEFT_SHIFT, RIGHT_SHIFT, LESS_THAN, GREATER_THAN,
        LT_EQ, GT_EQ, EQUALS, NOT_EQ, AND_OP, XOR_OP, OR_OP, AND_LOG, OR_LOG, ASSIGN
    }

    public binaryOpType binaryOp;
    public ExprNode lhs, rhs;

    public binaryExprNode(position pos, binaryOpType binaryOp_, ExprNode lhs_, ExprNode rhs_){
        super(pos);
        binaryOp = binaryOp_;
        lhs = lhs_;
        rhs = rhs_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
