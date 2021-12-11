package LLVMIR.Entity;

import LLVMIR.Type.baseType;

public class label extends Entity{
    public String name;

    public label(String name_){
        super(false, new baseType(baseType.typeToken.LABEL));
        name = name_;
    }

    @Override
    public String getValue(){
        return name;
    }

    @Override
    public String toString(){
        return super.toString() + " %" + name;
    }
}
