package LLVMIR.Entity;

import LLVMIR.Type.IRType;

public class register extends Entity {
    public String name;

    public register(IRType type_, String name_){
        super(type_);
        name = name_;
    }

    @Override
    public String getValue(){
        return "%" + name;
    }

    @Override
    public String toString(){
        return super.toString() + " %" + name;
    }
}
