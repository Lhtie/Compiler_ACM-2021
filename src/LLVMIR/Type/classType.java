package LLVMIR.Type;

import java.util.ArrayList;

public class classType extends IRType{
    public String className;
    public ArrayList<IRType> innerTypes;

    public classType(String className_){
        className = className_;
        innerTypes = new ArrayList<>();
    }

    @Override
    public String toString(){
        return "%" + className;
    }
}
