package LLVMIR;

import LLVMIR.Type.IRType;

import java.util.ArrayList;
import java.util.HashMap;

public class Class {
    public String identifier;
    public ArrayList<IRType> vars;
    public ArrayList<Function> fns;
    public HashMap<String, Integer> ctx;

    public Class(String identifier_){
        identifier = identifier_;
        vars = new ArrayList<>();
        fns = new ArrayList<>();
        ctx = new HashMap<>();
    }
}
