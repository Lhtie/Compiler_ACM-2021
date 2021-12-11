package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import AST.binaryExprNode;

public class icmp extends Stmt{
    public enum compareType{
        EQ, NE,
        UGT, UGE, ULT, ULE,
        SGT, SGE, SLT, SLE
    }

    public Entity rd;
    public compareType cmpType;
    public Entity lhs, rhs;

    public icmp(Entity rd_, binaryExprNode.binaryOpType binaryOp, Entity lhs_, Entity rhs_){
        rd = rd_;
        cmpType = switch (binaryOp){
            case LESS_THAN -> compareType.SLT;
            case GREATER_THAN -> compareType.SGT;
            case LT_EQ -> compareType.SLE;
            case GT_EQ -> compareType.SGE;
            case EQUALS -> compareType.EQ;
            case NOT_EQ -> compareType.NE;
            default -> null;
        };
        lhs = lhs_;
        rhs = rhs_;
    }

    @Override
    public String toString(){
        return rd.getValue() + " = icmp " + cmpType.name().toLowerCase()
            + " " + lhs + ", " + rhs.getValue();
    }
}
