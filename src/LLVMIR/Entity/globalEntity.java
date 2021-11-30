package LLVMIR.Entity;

import LLVMIR.IRType;

public class globalEntity extends register{
    public Boolean isConst;

    public globalEntity(IRType type, String name, Boolean isConst_){
        super(type, name);
        isConst = isConst_;
    }
}
