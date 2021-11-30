package LLVMIR;

import LLVMIR.Stmt.*;
import java.util.ArrayList;

public class BasicBlock {
    public String label;
    public ArrayList<Stmt> stmts;

    public BasicBlock(String label_){
        label = label_;
        stmts = new ArrayList<>();
    }

    public void addStmt(Stmt stmt){
        stmts.add(stmt);
    }
}
