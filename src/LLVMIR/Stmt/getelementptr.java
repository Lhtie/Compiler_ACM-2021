package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import LLVMIR.Pass;
import LLVMIR.Type.IRType;

import java.util.ArrayList;

public class getelementptr extends Stmt{
    boolean inbounds;
    public IRType type;
    public Entity rd, rs;
    public ArrayList<Entity> arrOffset;
    public ArrayList<Entity> classOffset;

    public getelementptr(Entity rd_, boolean inbounds_, IRType type_, Entity rs_){
        inbounds = inbounds_;
        type = type_;
        rd = rd_;
        rs = rs_;
        arrOffset = new ArrayList<>();
        classOffset = new ArrayList<>();
    }

    public void addOffset(Entity arrOffset_, Entity classOffset_){
        arrOffset.add(arrOffset_);
        classOffset.add(classOffset_);
    }

    public void addOffset(Entity arrOffset_){
        arrOffset.add(arrOffset_);
    }

    @Override
    public String toString(){
        String ret = rd.getValue() + " = getelementptr " + (inbounds ? "inbounds " : "") + type + ", " + rs;
        assert(arrOffset.size() == classOffset.size() || arrOffset.size() == classOffset.size() + 1);
        for (int i = 0; i < arrOffset.size(); ++i){
            ret += ", " + arrOffset.get(i);
            if (i < classOffset.size())
                ret += ", " + classOffset.get(i);
        }
        return ret;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
