package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import LLVMIR.Type.IRType;

import java.util.ArrayList;

public class call extends Stmt{
    public Entity rd;
    public IRType retType;
    public String funcName;
    public ArrayList<Entity> parameters;

    public call(Entity rd_, IRType retType_, String funcName_){
        rd = rd_;
        retType = retType_;
        funcName = funcName_;
        parameters = new ArrayList<>();
    }

    @Override
    public String toString(){
        String ret = rd.getValue() + " = call " + retType
                + " @" + funcName + "(";
        for (int i = 0; i < parameters.size(); ++i) {
            if (i > 0) ret += ", ";
            ret += parameters.get(i);
        }
        ret += ")";
        return ret;
    }
}
