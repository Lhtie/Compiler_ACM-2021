package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import LLVMIR.Pass;
import LLVMIR.Type.IRType;

public class convertOp extends Stmt{
    public enum convertType{
        TRUNC, ZEXT, SEXT, BITCAST
    }

    public convertType covType;
    public Entity rd, rs;
    public IRType targetType;

    public convertOp(convertType covType_, Entity rd_, Entity rs_){
        covType = covType_;
        rd = rd_;
        rs = rs_;
        targetType = rd.type;
    }

    @Override
    public String toString(){
        return rd.getValue() + " = " + covType.name().toLowerCase()
                + " " + rs + " to " + targetType;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
