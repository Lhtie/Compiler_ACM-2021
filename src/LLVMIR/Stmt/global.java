package LLVMIR.Stmt;

import LLVMIR.Entity.Entity;
import LLVMIR.Pass;

public class global extends Stmt{
    public enum defineType{
        GLOBAL, CONSTANT
    }

    public defineType defType;
    public Entity init, rd;

    public global(Entity rd_, defineType defType_, Entity init_){
        rd = rd_;
        defType = defType_;
        init = init_;
    }

    @Override
    public String toString(){
        return rd.getValue() + " = " + defType.name().toLowerCase() + " " + init;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
