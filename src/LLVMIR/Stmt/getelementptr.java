package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import LLVMIR.Type.IRType;

import java.util.ArrayList;

public class getelementptr extends Stmt{
    public IRType type;
    public Entity rd, rs;
    public ArrayList<Entity> arrOffset;
    public ArrayList<Entity> classOffset;

    public getelementptr(Entity rd_, IRType type_, Entity rs_){
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
        String ret = rd.getValue() + " = getelementptr " + type + ", " + rs;
        assert(arrOffset.size() == classOffset.size() || arrOffset.size() == classOffset.size() + 1);
        for (int i = 0; i < arrOffset.size(); ++i){
            ret += ", " + arrOffset.get(i);
            if (i < classOffset.size())
                ret += ", " + classOffset.get(i);
        }
        return ret;
    }
}
