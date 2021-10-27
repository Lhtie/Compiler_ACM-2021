package Util;

import Util.error.semanticError;

import java.util.Objects;

public class FlowController {
    private int loopCnt;
    public String funcName;
    public boolean returned;
    public Type retType;

    public FlowController(String name){
        loopCnt = 0;
        returned = false;
        funcName = name;
    }

    public void loopIn(){
        loopCnt++;
    }

    public void loopOut(){
        loopCnt--;
    }

    public void breakLoop(position pos){
        if (loopCnt <= 0)
            throw new semanticError("Semantic Error: no loop to break", pos);
    }

    public void continueLoop(position pos){
        if (loopCnt <= 0)
            throw new semanticError("Semantic Error: no loop to continue", pos);
    }

    public void returnFunc(position pos, globalScope gScope, Type retType){
        Type funcRetType;
        if (Objects.equals(funcName, "Lambda")){
            if (this.retType == null) this.retType = new Type(retType);
            funcRetType = this.retType;
        } else funcRetType = gScope.getRetTypeFromFunc(pos, funcName);
        if (funcRetType.typeName == Type.typeToken.VOID){
            if (retType.typeName != Type.typeToken.VOID)
                throw new semanticError("Semantic Error: need to return void", pos);
        } else funcRetType.assignChecker(pos, gScope, retType);
        returned = true;
    }
}
