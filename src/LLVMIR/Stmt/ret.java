package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import LLVMIR.Pass;

public class ret extends Stmt{
    public Entity ret;

    public ret(Entity ret_){
        ret = ret_;
    }

    @Override
    public String toString(){
        return "ret " + ret;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
