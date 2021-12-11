package AST;

import Util.position;

public class binaryExprNode extends ExprNode{
    public enum binaryOpType{
        DOT, ASSIGN, AND_LOG, OR_LOG,
        STAR, DIV, MOD, PLUS, MINUS, LEFT_SHIFT, RIGHT_SHIFT, AND_OP, XOR_OP, OR_OP,
        LESS_THAN, GREATER_THAN, LT_EQ, GT_EQ, EQUALS, NOT_EQ,
    }

    public binaryOpType binaryOp;
    public ExprNode lhs, rhs;

    public binaryExprNode(position pos, binaryOpType binaryOp_, ExprNode lhs_, ExprNode rhs_){
        super(pos);
        binaryOp = binaryOp_;
        lhs = lhs_;
        rhs = rhs_;
    }

    public boolean isCmpOp(){
        binaryOpType Op = binaryOp;
        return Op == binaryOpType.LESS_THAN
                || Op == binaryOpType.GREATER_THAN
                || Op == binaryOpType.LT_EQ
                || Op == binaryOpType.GT_EQ
                || Op == binaryOpType.EQUALS
                || Op == binaryOpType.NOT_EQ
                ;
    }

    public boolean isArithOp(){
        binaryOpType Op = binaryOp;
        return Op == binaryOpType.STAR
                || Op == binaryOpType.DIV
                || Op == binaryOpType.MOD
                || Op == binaryOpType.PLUS
                || Op == binaryOpType.MINUS
                || Op == binaryOpType.LEFT_SHIFT
                || Op == binaryOpType.RIGHT_SHIFT
                || Op == binaryOpType.AND_OP
                || Op == binaryOpType.XOR_OP
                || Op == binaryOpType.OR_OP
                ;
    }

    public boolean isLogicOp(){
        binaryOpType Op = binaryOp;
        return Op ==binaryOpType.OR_LOG
                || Op == binaryOpType.AND_LOG
                ;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
