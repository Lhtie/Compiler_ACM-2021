package Util;

import Util.error.semanticError;

import java.util.HashMap;

public class Scope {
    private HashMap<String, Type> members;
    private Scope parentScope;

    public Scope(){
        members = new HashMap<>();
        parentScope = null;
    }

    public Scope(Scope parentScope_){
        members = new HashMap<>();
        parentScope = parentScope_;
    }

    public Scope getParentScope(){
        return this.parentScope;
    }

    public void addVar(position pos, String name, Type type){
        if (members.containsKey(name))
            throw new semanticError("Semantic Error: redefine variable " + name, pos);
        else members.put(name, type);
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
}
