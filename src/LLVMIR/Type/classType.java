package LLVMIR.Type;

import LLVMIR.Class;

public class classType extends IRType{
    public String className;
    public String identifier;

    public classType(Class cl){
        className = cl.className;
        identifier = cl.identifier;
    }

    @Override
    public String toString(){
        return "%" + identifier;
    }
}
