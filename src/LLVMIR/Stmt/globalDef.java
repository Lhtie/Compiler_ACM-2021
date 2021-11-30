package LLVMIR.Stmt;

import LLVMIR.Entity.*;
import LLVMIR.IRType;

public class globalDef extends Stmt{
    public enum defineType{
        GLOBAL, CONSTANT
    }

    public defineType defType;
    public Entity init, res;

    public globalDef(String name, defineType defType_, Entity init_){
        defType = defType_;
        init = init_;
        res = new globalEntity(new IRType(init_.type), name, defType_ == defineType.CONSTANT);
        res.type.isPtr = true;
    }
}
