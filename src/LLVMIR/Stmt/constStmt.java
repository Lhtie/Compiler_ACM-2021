package LLVMIR.Stmt;

public class constStmt extends Stmt{
    public String ctx;

    public constStmt(String ctx_){
        ctx = ctx_;
    }

    @Override
    public String toString(){
        return ctx;
    }
}
