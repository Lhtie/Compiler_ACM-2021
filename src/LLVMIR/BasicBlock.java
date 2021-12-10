package LLVMIR;

import LLVMIR.Entity.Entity;
import LLVMIR.Entity.label;
import LLVMIR.Stmt.*;
import java.util.ArrayList;

public class BasicBlock {
    public Entity label;
    public ArrayList<Stmt> stmts;

    public BasicBlock(String label_){
        label = new label(label_);
        stmts = new ArrayList<>();
    }
}
