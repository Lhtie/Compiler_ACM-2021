package LLVMIR.Type;

import LLVMIR.Class;

public class classType extends IRType{
    public String identifier;

    public classType(Class cl){
        identifier = cl.identifier;
    }

    @Override
    public String toString(){
        return "%" + identifier;
    }
}
