package LLVMIR.Stmt;

import LLVMIR.Function;
import LLVMIR.Type.IRType;

import java.util.ArrayList;

public class declare extends Stmt{
    public IRType retType;
    public String identifier;
    public ArrayList<IRType> parameters;

    public declare(Function fn){
        retType = fn.retType;
        identifier = fn.identifier;
        parameters = new ArrayList<>();
        fn.parameters.forEach(x -> parameters.add(x.type));
    }

    @Override
    public String toString(){
        String ret = "declare " + retType + " @" + identifier + "(";
        for (int i = 0; i < parameters.size(); ++i){
            if (i > 0) ret += ", ";
            ret += parameters.get(i);
        }
        ret += ")";
        return ret;
    }
}
