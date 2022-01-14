package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import LLVMIR.Pass;

public class store extends Stmt{
    public Entity rs, rd;

    public store(Entity rs_, Entity rd_){
        rs = rs_;
        rd = rd_;
    }

    @Override
    public String toString(){
        return "store " + rs + ", " + rd;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
