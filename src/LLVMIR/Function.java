package LLVMIR;

import LLVMIR.Entity.*;
import LLVMIR.Type.IRType;

import java.util.ArrayList;

public class Function {
    public int regNum;
    public IRType retType;
    public String identifier;
    public ArrayList<Entity> parameters;
    public BasicBlock entry;
    public ArrayList<BasicBlock> blocks;

    public Function(int regNum_, IRType retType_, String identifier_,
                    ArrayList<Entity> parameters_, BasicBlock entry_){
        regNum = regNum_;
        retType = retType_;
        identifier = identifier_;
        parameters = parameters_;
        entry = entry_;
        blocks = new ArrayList<>();
    }

    public String getRegId(){
        return Integer.toString(regNum++);
    }
}
