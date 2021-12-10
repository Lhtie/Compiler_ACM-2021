package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;

public class binaryOp extends Stmt{
    public enum binaryOpType{
        ADD, SUB, MUL, UDIV, SDIV, UREM, SREM,
        SHL, LSHR, ASHR, AND, OR, XOR
    }

    public binaryOpType opType;
    public boolean nuw, nsw;
    public Entity rs1, rs2, rd;

    public binaryOp(Entity rd_, binaryOpType opType_, Entity rs1_, Entity rs2_){
        rd = rd_;
        opType = opType_;
        rs1 = rs1_;
        rs2 = rs2_;
    }

    @Override
    public String toString(){
        String ret = rd.getValue() + " = " + opType.name().toLowerCase();
        if (nuw) ret += " nuw";
        if (nsw) ret += " nsw";
        assert(rs1.type == rs2.type);
        ret += " " + rs1 + ", " + rs2.getValue();
        return ret;
    }
}
