package LLVMIR;

import LLVMIR.Entity.Entity;
import LLVMIR.Entity.label;
import LLVMIR.Stmt.*;
import java.util.ArrayList;

public class BasicBlock {
    public enum flowStatusType{
        BREAK, CONTINUE, RETURN
    }

    public Entity label;
    public ArrayList<Stmt> stmts;
    public boolean branched;
    public flowStatusType flowStatus;

    public BasicBlock(String label_){
        label = new label(label_);
        stmts = new ArrayList<>();
        branched = false;
    }
}
