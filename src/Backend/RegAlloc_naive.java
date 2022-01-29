package Backend;

import Assembly.*;
import Assembly.Instr.*;
import Assembly.Operand.*;

public class RegAlloc_naive implements Pass {
    public AsmMod topAsmMod;
    public AsmFn currentFn;
    public AsmBlock currentBlock;

    private phyReg t0, t1, t2, t3, s0;

    private Operand loadVReg(Instr it, Operand rs, Operand t){
        if (rs instanceof virtualReg){
            virtualReg vreg = (virtualReg) rs;
            if (!currentFn.stackOffset.containsKey(vreg))
                currentFn.alloc(vreg, vreg.bytes);
            int imm = -currentFn.stackOffset.get(vreg);
            if (-2048 <= imm && imm < 2048)
                currentBlock.insert_before(it, new loadOp(vreg.bytes, t, s0, new imm(imm)));
            else {
                currentBlock.insert_before(it, new li(t3, new imm(imm)));
                currentBlock.insert_before(it, new RCalcOp(RCalcOp.RType.ADD, t3, s0, t3));
                currentBlock.insert_before(it, new loadOp(vreg.bytes, t, t3, new imm(0)));
            }
            return t;
        } else return rs;
    }

    private Operand storeVReg(Instr it, Operand rd, Operand t){
        if (rd instanceof virtualReg) {
            virtualReg vreg = (virtualReg) rd;
            if (!currentFn.stackOffset.containsKey(vreg))
                currentFn.alloc(vreg, vreg.bytes);
            int imm = -currentFn.stackOffset.get(vreg);
            if (-2048 <= imm && imm < 2048)
                currentBlock.insert_after(it, new storeOp(vreg.bytes, t, s0, new imm(imm)));
            else {
                currentBlock.insert_after(it, new storeOp(vreg.bytes, t, t3, new imm(0)));
                currentBlock.insert_after(it, new RCalcOp(RCalcOp.RType.ADD, t3, s0, t3));
                currentBlock.insert_after(it, new li(t3, new imm(imm)));
            }
            return t;
        } else return rd;
    }

    @Override
    public void visit(AsmMod mod) {
        topAsmMod = mod;
        t0 = topAsmMod.regs.get(5);
        t1 = topAsmMod.regs.get(6);
        t2 = topAsmMod.regs.get(7);
        s0 = topAsmMod.regs.get(8);
        t3 = topAsmMod.regs.get(28);

        topAsmMod.fns.forEach(this::visit);
    }

    @Override
    public void visit(AsmFn fn) {
        currentFn = fn;
        currentBlock = fn.entry;
        visit(currentBlock);
        fn.blocks.forEach(x -> {
            currentBlock = x;
            visit(x);
        });
    }

    @Override
    public void visit(AsmBlock block) {
        for (Instr iter = block.head; iter != null; iter = iter.nxt)
            iter.accept(this);
    }

    @Override public void visit(AsmData dt) {}

    @Override
    public void visit(brPseOp it) {
        it.rs = loadVReg(it, it.rs, t0);
    }

    @Override public void visit(callPse it) {}

    @Override
    public void visit(cmpPseOp it) {
        it.rs = loadVReg(it, it.rs, t0);
        it.rd = storeVReg(it, it.rd, t1);
    }

    @Override
    public void visit(ICalcOp it) {
        it.rs = loadVReg(it, it.rs, t0);
        it.rd = storeVReg(it, it.rd, t1);
    }

    @Override public void visit(j it) {}

    @Override
    public void visit(la it) {
        it.rd = storeVReg(it, it.rd, t0);
    }

    @Override
    public void visit(li it) {
        it.rd = storeVReg(it, it.rd, t0);
    }

    @Override
    public void visit(loadOp it) {
        if (it.symbol == null)
            it.rs = loadVReg(it, it.rs, t0);
        it.rd = storeVReg(it, it.rd, t1);
    }

    @Override
    public void visit(mv it) {
        it.rs = loadVReg(it, it.rs, t0);
        it.rd = storeVReg(it, it.rd, t1);
    }

    @Override
    public void visit(RCalcOp it) {
        it.rs1 = loadVReg(it, it.rs1, t0);
        it.rs2 = loadVReg(it, it.rs2, t1);
        it.rd = storeVReg(it, it.rd, t2);
    }

    @Override public void visit(retPse it) {}

    @Override
    public void visit(storeOp it) {
        if (it.symbol == null)
            it.rs = loadVReg(it, it.rs, t0);
        else it.rt = loadVReg(it, it.rt, t1);
        it.rd = loadVReg(it, it.rd, t2);
    }
}
