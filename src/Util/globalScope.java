package Util;

import LLVMIR.Class;
import LLVMIR.Function;
import Util.error.semanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class globalScope extends Scope {
    public String identifier;
    private HashMap<String, globalScope> classScope = new HashMap<>();
    private HashMap<String, Scope> funcScope = new HashMap<>();
    private HashMap<String, Type> funcRetType = new HashMap<>();
    private HashMap<String, ArrayList<Type>> funcParameters = new HashMap<>();

    private HashMap<String, Class> classType = new HashMap<>();
    private HashMap<String, Function> funcType = new HashMap<>();

    public globalScope() {
        identifier = "Global";
    }

    public globalScope(Scope scope, String id){
        super(scope);
        identifier = id;
    }

    public void addClass(position pos, String name, globalScope scope){
        if (classScope.containsKey(name))
            throw new semanticError("Semantic Error: redefinition class " + name, pos);
        else if (funcScope.containsKey(name))
            throw new semanticError("Semantic Error: " + name + " defined as function", pos);
        else if (super.containsKey(name, false) != null)
            throw new semanticError("Semantic Error: " + name + " defined as variable", pos);
        else classScope.put(name, scope);
    }

    public void addClass(String name, Class cl){
        classType.put(name, cl);
    }

    public void addFunc(position pos, String name, Scope scope, Type retType, ArrayList<Type> parameters){
        if (funcScope.containsKey(name))
            throw new semanticError("Semantic Error: redefined funciton " + name, pos);
        else if (classScope.containsKey(name))
            throw new semanticError("Semantic Error: " + name + " defined as class", pos);
        else{
            funcScope.put(name, scope);
            funcRetType.put(name, retType);
            funcParameters.put(name, parameters);
        }
    }

    public void addFunc(String name, Function fn){
        funcType.put(name, fn);
    }

    public Scope getScopeFromClass(position pos, String name){
        if (classScope.containsKey(name))
            return classScope.get(name);
        else if (this.getParentScope() != null)
            return ((globalScope) this.getParentScope()).getScopeFromClass(pos, name);
        else throw new semanticError("Semantic Error: cannot find class " + name, pos);
    }

    public Class getClass(String name){
        if (classType.containsKey(name))
            return classType.get(name);
        else if (this.getParentScope() != null)
            return ((globalScope) this.getParentScope()).getClass(name);
        else return null;
    }

    public Scope getScopeFromFunc(position pos, String name){
        if (funcScope.containsKey(name))
            return funcScope.get(name);
        else if (this.getParentScope() != null)
            return ((globalScope) this.getParentScope()).getScopeFromFunc(pos, name);
        else throw new semanticError("Semantic Error: cannot find function " + name, pos);
    }

    public Type getRetTypeFromFunc(position pos, String name){
        if (funcScope.containsKey(name))
            return funcRetType.get(name);
        else if (this.getParentScope() != null)
            return ((globalScope) this.getParentScope()).getRetTypeFromFunc(pos, name);
        else throw new semanticError("Semantic Error: cannot find function " + name, pos);
    }

    public ArrayList<Type> getParametersFromFunc(position pos, String name){
        if (funcScope.containsKey(name))
            return funcParameters.get(name);
        else if (this.getParentScope() != null)
            return ((globalScope) this.getParentScope()).getParametersFromFunc(pos, name);
        else throw new semanticError("Semantic Error: cannot find function " + name, pos);
    }

    public Function getFunc(String name){
        if (funcType.containsKey(name))
            return funcType.get(name);
        else if (this.getParentScope() != null)
            return ((globalScope) this.getParentScope()).getFunc(name);
        else return null;
    }

    public boolean findFunc(String name, boolean lookUpon){
        if (funcScope.containsKey(name))
            return true;
        else if (this.getParentScope() != null && lookUpon)
            return ((globalScope) this.getParentScope()).findFunc(name, lookUpon);
        else return false;
    }

    public boolean findClass(String name){
        if (classScope.containsKey(name))
            return true;
        else if (this.getParentScope() != null)
            return ((globalScope) this.getParentScope()).findClass(name);
        else return false;
    }

    @Override
    public Scope containsKey(String name, boolean lookUpon){
        if (funcScope.containsKey(name))
            return this;
        else return super.containsKey(name, lookUpon);
    }
}
