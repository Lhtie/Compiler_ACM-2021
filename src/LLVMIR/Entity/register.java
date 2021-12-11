package LLVMIR.Entity;

import LLVMIR.Type.IRType;

public class register extends Entity {
    public String name;

    public register(boolean islValue_, IRType type_, String name_){
        super(islValue_, type_);
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
