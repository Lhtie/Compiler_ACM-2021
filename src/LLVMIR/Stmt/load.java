package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import LLVMIR.Type.IRType;

public class load extends Stmt{
    public IRType Type;
    public Entity rs, rd;

    public load(Entity rd_, Entity rs_){
        rd = rd_;
        Type = rd.type;
        rs = rs_;
    }

    @Override
    public String toString(){
        return rd.getValue() + " = load " + Type + ", " + rs;
    }
}
