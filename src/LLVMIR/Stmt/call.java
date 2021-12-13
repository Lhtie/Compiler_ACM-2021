package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import LLVMIR.Type.IRType;
import LLVMIR.Function;
import LLVMIR.Type.baseType;

import java.util.ArrayList;

public class call extends Stmt{
    public Entity rd;
    public IRType retType;
    public String identifier;
    public ArrayList<Entity> parameters;

    public call(Entity rd_, Function fn, ArrayList<Entity> parameters_){
        rd = rd_;
        retType = rd == null ? new baseType(baseType.typeToken.VOID) : rd.type;
        identifier = fn.identifier;
        parameters = parameters_;
    }

    @Override
    public String toString(){
        String ret = (rd == null ? "" : rd.getValue() + " = ") + "call " + retType
                + " @" + identifier + "(";
        for (int i = 0; i < parameters.size(); ++i) {
            if (i > 0) ret += ", ";
            ret += parameters.get(i);
        }
        ret += ")";
        return ret;
    }
}
