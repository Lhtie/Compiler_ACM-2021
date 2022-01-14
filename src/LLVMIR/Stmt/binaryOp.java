package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import AST.binaryExprNode;
import LLVMIR.Pass;
import LLVMIR.Entity.constant;

public class binaryOp extends Stmt{
    public enum binaryOpType{
        ADD, SUB, MUL, UDIV, SDIV, UREM, SREM,
        SHL, LSHR, ASHR, AND, OR, XOR
    }

    public binaryOpType opType;
    public boolean nuw, nsw;
    public Entity rs1, rs2, rd;

    private void trySwap(){
        switch (opType){
            case ADD, MUL, AND, OR, XOR -> {
                if (rs1 instanceof constant c){
                    int val = c.getIntVal();
                    if (-2048 <= val && val < 2048) {
                        Entity tmp = rs1;
                        rs1 = rs2;
                        rs2 = tmp;
                    }
                }
            }
        }
    }

    public binaryOp(Entity rd_, binaryExprNode.binaryOpType binaryOp, Entity rs1_, Entity rs2_){
        rd = rd_;
        opType = switch(binaryOp){
            case AND_LOG, AND_OP -> binaryOpType.AND;
            case OR_LOG, OR_OP -> binaryOpType.OR;
            case STAR -> binaryOpType.MUL;
            case DIV -> binaryOpType.SDIV;
            case MOD -> binaryOpType.SREM;
            case PLUS -> binaryOpType.ADD;
            case MINUS -> binaryOpType.SUB;
            case LEFT_SHIFT -> binaryOpType.SHL;
            case RIGHT_SHIFT -> binaryOpType.ASHR;
            case XOR_OP -> binaryOpType.XOR;
            default -> null;
        };
        rs1 = rs1_;
        rs2 = rs2_;
        trySwap();
    }

    public binaryOp(Entity rd_, binaryOpType opType_, Entity rs1_, Entity rs2_){
        rd = rd_;
        opType = opType_;
        rs1 = rs1_;
        rs2 = rs2_;
        trySwap();
    }

    @Override
    public String toString(){
        String ret = rd.getValue() + " = " + opType.name().toLowerCase();
        if (nuw) ret += " nuw";
        if (nsw) ret += " nsw";
        ret += " " + rs1 + ", " + rs2.getValue();
        return ret;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
