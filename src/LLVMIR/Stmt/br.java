package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;

public class br extends Stmt{
    public Boolean isCond;
    public Entity cmpRes, label1, label2;

    public br(Entity cmpRes_, Entity label1_, Entity label2_){
        isCond = true;
        cmpRes = cmpRes_;
        label1 = label1_;
        label2 = label2_;
    }

    public br(Entity label1_){
        isCond = false;
        label1 = label1_;
    }

    @Override
    public String toString(){
        if (isCond)
            return "br " + cmpRes + ", " + label1 + ", " + label2;
        else return "br " + label1;
    }
}
