package LLVMIR.Entity;

import LLVMIR.IRType;

public class register extends Entity {
    public String name;

    public register(IRType type_, String name_){
        super(type_);
        name = name_;
    }
}
