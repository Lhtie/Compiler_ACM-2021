package LLVMIR;

import LLVMIR.Stmt.*;

public interface Pass {
    void visitModule(Module module);
    void visitFunction(Function fn);
    void visitClass(Class cl);
    void visitBasicBlock(BasicBlock block);
    void visitStmt(Stmt stmt);

    void visit(alloca it);
    void visit(binaryOp it);
    void visit(br it);
    void visit(call it);
    void visit(convertOp it);
    void visit(declare it);
    void visit(getelementptr it);
    void visit(global it);
    void visit(icmp it);
    void visit(load it);
    void visit(phi it);
    void visit(ret it);
    void visit(store it);
}
