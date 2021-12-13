package LLVMIR.Type;

import LLVMIR.Class;

public class classType extends IRType{
    public String className;
    public String identifier;

    public classType(Class cl){
        className = cl.identifier.substring(6);
        identifier = cl.identifier;
    }

    @Override
    public String toString(){
        return "%" + identifier;
    }
}
