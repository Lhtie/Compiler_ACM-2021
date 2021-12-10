package LLVMIR;

import LLVMIR.Entity.*;
import LLVMIR.Type.IRType;

import java.util.ArrayList;

public class Function {
    public IRType retType;
    public String funcName;
    public ArrayList<Entity> parameters;
    public BasicBlock entry;
    public ArrayList<BasicBlock> blocks;

    public Function(IRType retType_, String funcName_, ArrayList<Entity> parameters_, BasicBlock entry_){
        retType = retType_;
        funcName = funcName_;
        parameters = parameters_;
        entry = entry_;
        blocks = new ArrayList<>();
    }
}
