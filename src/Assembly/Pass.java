package Assembly;

import Assembly.Instr.*;

public interface Pass {
    void visit(AsmMod topAsmMod);
    void visit(AsmFn fn);
    void visit(AsmBlock block);
    void visit(AsmData dt);

    void visit(brPseOp it);
    void visit(callPse it);
    void visit(cmpPseOp it);
    void visit(ICalcOp it);
    void visit(j it);
    void visit(la it);
    void visit(li it);
    void visit(loadOp it);
    void visit(mv it);
    void visit(RCalcOp it);
    void visit(retPse it);
    void visit(storeOp it);
}
