package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import LLVMIR.Type.IRType;
import LLVMIR.Function;

import java.util.ArrayList;

public class call extends Stmt{
    public Entity rd;
    public IRType retType;
    public String identifier;
    public ArrayList<Entity> parameters;

    public call(Entity rd_, Function fn){
        rd = rd_;
        retType = rd.type;
        identifier = fn.identifier;
        parameters = new ArrayList<>();
    }

    @Override
    public String toString(){
        String ret = rd.getValue() + " = call " + retType
                + " @" + identifier + "(";
        for (int i = 0; i < parameters.size(); ++i) {
            if (i > 0) ret += ", ";
            ret += parameters.get(i);
        }
        ret += ")";
        return ret;
    }
}
