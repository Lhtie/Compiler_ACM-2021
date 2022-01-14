package LLVMIR.Stmt;

import LLVMIR.Pass;

public abstract class Stmt {
    public abstract void accept(Pass visitor);
}
