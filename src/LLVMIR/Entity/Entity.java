package LLVMIR.Entity;

import LLVMIR.Type.IRType;

public abstract class Entity {
    public IRType type;

    public Entity(IRType type_){
        type = type_;
    }

    public abstract String getValue();

    public String toString(){
        return type.toString();
    }
}
