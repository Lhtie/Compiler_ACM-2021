package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import LLVMIR.Type.IRType;

import java.util.ArrayList;

public class phi extends Stmt{
    public Entity rd;
    public IRType type;
    public ArrayList<Entity> val;
    public ArrayList<Entity> label;

    public phi(Entity rd_){
        rd = rd_;
        type = rd.type;
        val = new ArrayList<>();
        label = new ArrayList<>();
    }

    public void add(Entity val_, Entity label_){
        val.add(val_);
        label.add(label_);
    }

    @Override
    public String toString(){
        String ret = rd.getValue() + " = phi " + type + " ";
        assert(val.size() == label.size());
        for (int i = 0; i < val.size(); ++i){
            if (i > 0) ret += ", ";
            ret += "[ " + val.get(i).getValue() + ", %" + label.get(i).getValue() + " ]";
        }
        return ret;
    }
}
