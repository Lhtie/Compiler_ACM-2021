package LLVMIR;

import java.util.ArrayList;
import java.util.List;

import LLVMIR.Entity.Entity;
import LLVMIR.Entity.register;
import LLVMIR.Stmt.*;
import LLVMIR.Type.IRType;
import LLVMIR.Type.baseType;
import LLVMIR.Type.ptrType;

public class Module {
    public ArrayList<Stmt> gVars;
    public ArrayList<Function> fns;
    public ArrayList<Class> cls;

    public Function malloc, array_size, print, println, printInt, printlnInt, getString, getInt, toString,
                string_length, string_subString, string_parseInt, string_ord,
                string_add, string_eq, string_ne, string_lt, string_le, string_gt, string_ge;

    private void declareBuiltIn(){
        IRType i1 = new baseType(baseType.typeToken.I, 1);
        IRType i8 = new baseType(baseType.typeToken.I, 8);
        IRType i32 = new baseType(baseType.typeToken.I, 32);
        IRType i64 = new baseType(baseType.typeToken.I, 64);
        IRType Void = new baseType(baseType.typeToken.VOID);
        ArrayList<Entity> parameters = new ArrayList<>(List.of(new register(false, i32, "0")));
        malloc = new Function(2, new ptrType(i8),"malloc", parameters, new BasicBlock("1"));
        gVars.add(new declare(malloc));
        parameters = new ArrayList<>(List.of(new register(false, new ptrType(i8), "0")));
        print = new Function(2, Void, "print", parameters, new BasicBlock("1"));
        gVars.add(new declare(print));
        parameters = new ArrayList<>(List.of(new register(false, new ptrType(i8), "0")));
        println = new Function(2, Void, "println", parameters, new BasicBlock("1"));
        gVars.add(new declare(println));
        parameters = new ArrayList<>(List.of(new register(false, i32, "0")));
        printInt = new Function(2, Void, "printInt", parameters, new BasicBlock("1"));
        gVars.add(new declare(printInt));
        parameters = new ArrayList<>(List.of(new register(false, i32, "0")));
        printlnInt = new Function(2, Void, "printlnInt", parameters, new BasicBlock("1"));
        gVars.add(new declare(printlnInt));
        parameters = new ArrayList<>();
        getString = new Function(2, new ptrType(i8), "getString", parameters, new BasicBlock("1"));
        gVars.add(new declare(getString));
        getInt = new Function(2, i32, "getInt", parameters, new BasicBlock("1"));
        gVars.add(new declare(getInt));
        parameters = new ArrayList<>(List.of(new register(false, i32, "0")));
        toString = new Function(2, new ptrType(i8), "toString", parameters, new BasicBlock("1"));
        gVars.add(new declare(toString));

        parameters = new ArrayList<>(List.of(new register(false, new ptrType(i8), "0")));
        array_size = new Function(2, i32, "array_size", parameters, new BasicBlock("1"));
        gVars.add(new declare(array_size));
        parameters = new ArrayList<>(List.of(new register(false, new ptrType(i8), "0")));
        string_length = new Function(2, i32, "string_length", parameters, new BasicBlock("1"));
        gVars.add(new declare(string_length));
        parameters = new ArrayList<>(List.of(new register(false, new ptrType(i8), "0"),
                new register(false, i32, "1"), new register(false, i32, "2")));
        string_subString = new Function(4, new ptrType(i8), "string_subString", parameters, new BasicBlock("3"));
        gVars.add(new declare(string_subString));
        parameters = new ArrayList<>(List.of(new register(false, new ptrType(i8), "0")));
        string_parseInt = new Function(2, i32, "string_parseInt", parameters, new BasicBlock("1"));
        gVars.add(new declare(string_parseInt));
        parameters = new ArrayList<>(List.of(new register(false, new ptrType(i8), "0"),
                new register(false, i32, "1")));
        string_ord = new Function(3, i32, "string_ord", parameters, new BasicBlock("2"));
        gVars.add(new declare(string_ord));
        parameters = new ArrayList<>(List.of(new register(false, new ptrType(i8), "0"),
                new register(false, new ptrType(i8), "1")));
        string_add = new Function(3, new ptrType(i8), "string_add", parameters, new BasicBlock("2"));
        gVars.add(new declare(string_add));
        string_eq = new Function(3, i1, "string_eq", parameters, new BasicBlock("2"));
        gVars.add(new declare(string_eq));
        string_ne = new Function(3, i1, "string_ne", parameters, new BasicBlock("2"));
        gVars.add(new declare(string_ne));
        string_lt = new Function(3, i1, "string_lt", parameters, new BasicBlock("2"));
        gVars.add(new declare(string_lt));
        string_le = new Function(3, i1, "string_le", parameters, new BasicBlock("2"));
        gVars.add(new declare(string_le));
        string_gt = new Function(3, i1, "string_gt", parameters, new BasicBlock("2"));
        gVars.add(new declare(string_gt));
        string_ge = new Function(3, i1, "string_ge", parameters, new BasicBlock("2"));
        gVars.add(new declare(string_ge));
    }

    public Module(){
        gVars = new ArrayList<>();
        fns = new ArrayList<>();
        cls = new ArrayList<>();

        declareBuiltIn();
    }
}
