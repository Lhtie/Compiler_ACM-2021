package Util;

import LLVMIR.BasicBlock;
import LLVMIR.Entity.Entity;
import LLVMIR.Function;
import Util.error.semanticError;

import java.util.HashMap;

public class Scope {
    private HashMap<String, Type> members;
    private Scope parentScope;

    private HashMap<String, Entity> regs;

    public Scope(){
        members = new HashMap<>();
        parentScope = null;
        regs = new HashMap<>();
    }

    public Scope(Scope parentScope_){
        members = new HashMap<>();
        parentScope = parentScope_;
        regs = new HashMap<>();
    }

    public Scope getParentScope(){
        return this.parentScope;
    }

    public void addVar(position pos, String name, Type type){
        if (members.containsKey(name))
            throw new semanticError("Semantic Error: redefine variable " + name, pos);
        else members.put(name, type);
    }

    public void addRegister(String name, Entity reg){
        regs.put(name, reg);
    }

    public Scope containsKey(String name, boolean lookUpon){
        if (members.containsKey(name))
            return this;
        else if (lookUpon && this.parentScope != null)
            return this.parentScope.containsKey(name, lookUpon);
        else return null;
    }

    public Type getType(position pos, String name, boolean lookUpon){
        if (members.containsKey(name))
            return members.get(name);
        else if (parentScope != null && lookUpon)
            return parentScope.getType(pos, name, lookUpon);
        else throw new semanticError("Semantic Error: cannot find identifier " + name, pos);
    }

    public Entity getRegister(String name, boolean lookUpon, BasicBlock block, Function fn){
        if (regs.containsKey(name))
            return regs.get(name);
        else if (parentScope != null && lookUpon)
            return parentScope.getRegister(name, lookUpon, block, fn);
        else return null;
    }
}
