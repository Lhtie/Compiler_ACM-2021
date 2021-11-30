package LLVMIR.Stmt;

import LLVMIR.Entity.*;
import LLVMIR.IRType;

public class localDef extends Stmt{
    public IRType type;
    public Entity res;

    public localDef(String name, IRType type_){
        type = type_;
        res = new register(type_, name);
        res.type.isPtr = true;
    }
}
