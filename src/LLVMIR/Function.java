package LLVMIR;

import LLVMIR.Entity.*;
import java.util.ArrayList;

public class Function {
    public IRType retType;
    public String funcName;
    public ArrayList<register> parameters;
    public ArrayList<BasicBlock> blocks;

    public Function(IRType retType_, String funcName_, ArrayList<register> parameters_){
        retType = retType_;
        funcName = funcName_;
        parameters = parameters_;
        blocks = new ArrayList<>();
    }

    public void addBlock(BasicBlock block){
        blocks.add(block);
    }
}
