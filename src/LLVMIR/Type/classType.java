package LLVMIR.Type;

import LLVMIR.Class;

public class classType extends IRType{
    public String className;
    public String identifier;
    public int bytes;
    public Class cl;

    public classType(Class cl_){
        cl = cl_;
        className = cl.className;
        identifier = cl.identifier;
        cl.vars.forEach(x -> bytes += x.getBytes());
    }

    @Override
    public String toString(){
        return "%" + identifier;
    }

    @Override
    public int getBytes() {
        return bytes;
    }
}
