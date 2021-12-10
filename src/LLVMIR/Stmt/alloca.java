package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import LLVMIR.Type.IRType;

public class alloca extends Stmt{
    public IRType type;
    public Entity rd;

    public alloca(Entity rd_, IRType type_){
        rd = rd_;
        type = type_;
    }

    @Override
    public String toString(){
        return rd.getValue() + " = alloca " + type;
    }
}
