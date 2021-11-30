package LLVMIR.Stmt;

import LLVMIR.Entity.*;
import LLVMIR.IRType;

public class load extends Stmt{
    public IRType type;
    public Entity rs, rd;

    public load(String name, IRType type_, Entity rs_){
        type = type_;
        rs = new register(type_, name);
    }
}
