package Backend;

import LLVMIR.BasicBlock;
import LLVMIR.Class;
import LLVMIR.Function;
import LLVMIR.Module;
import LLVMIR.Stmt.Stmt;

public interface Pass {
    void visitModule(Module module);
    void visitFunction(Function fn);
    void visitClass(Class cl);
    void visitBasicBlock(BasicBlock block);
    void visitStmt(Stmt stmt);
}
