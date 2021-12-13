package LLVMIR.Stmt;

import LLVMIR.Type.IRType;

import java.util.ArrayList;

public class declare extends Stmt{
    public IRType retType;
    public String identifier;
    public ArrayList<IRType> parameters;

    public declare(IRType retType_, String identifier_){
        retType = retType_;
        identifier = identifier_;
        parameters = new ArrayList<>();
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
