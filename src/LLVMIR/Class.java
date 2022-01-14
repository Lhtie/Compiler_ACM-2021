package LLVMIR;

import LLVMIR.Type.IRType;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Class {
    public String className;
    public String identifier;
    public ArrayList<IRType> vars;
    public ArrayList<Integer> offset;
    public ArrayList<Function> fns;
    public HashMap<String, Integer> ctx;
    public long bytes = 0;
    public boolean hasConstr;

    public Class(String identifier_){
        className = identifier_.substring(6);
        identifier = identifier_;
        vars = new ArrayList<>();
        offset = new ArrayList<>();
        fns = new ArrayList<>();
        ctx = new HashMap<>();
    }
}
