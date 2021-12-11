package LLVMIR.Entity;

import LLVMIR.Type.IRType;

public abstract class Entity {
    public IRType type;
    public boolean islValue;

    public Entity(boolean islValue_, IRType type_){
        islValue = islValue_;
        type = type_;
    }

    public abstract String getValue();

    public String toString(){
        return type.toString();
    }
}
