package LLVMIR.Entity;

import LLVMIR.Type.IRType;

public class globalEntity extends Entity{
    public String name;
    public Boolean isConst;

    public globalEntity(IRType type, String name_, Boolean isConst_){
        super(type);
        name = name_;
        isConst = isConst_;
    }

    @Override
    public String getValue(){
        return "@" + name;
    }

    @Override
    public String toString(){
        return super.toString() + " @" + name;
    }
}
