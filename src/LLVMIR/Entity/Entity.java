package LLVMIR.Entity;

import LLVMIR.IRType;

public abstract class Entity {
    public IRType type;

    public Entity(IRType type_){
        type = type_;
    }
}
