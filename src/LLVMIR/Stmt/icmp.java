package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import LLVMIR.Type.IRType;

public class icmp extends Stmt{
    public enum compareType{
        EQ, NE,
        UGT, UGE, ULT, ULE,
        SGT, SGE, SLT, SLE
    }

    public Entity rd;
    public compareType cmpType;
    public Entity lhs, rhs;

    public icmp(Entity rd_, compareType cmpType_, Entity lhs_, Entity rhs_){
        rd = rd_;
        cmpType = cmpType_;
        lhs = lhs_;
        rhs = rhs_;
    }

    @Override
    public String toString(){
        assert(lhs.type == rhs.type);
        return rd.getValue() + " = " + cmpType.name().toLowerCase()
            + " " + lhs + ", " + rhs.getValue();
    }
}
