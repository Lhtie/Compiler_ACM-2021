package Backend;

import Assembly.*;
import Assembly.Instr.*;
import Assembly.Operand.phyReg;
import Assembly.Operand.imm;

import java.io.PrintStream;

public class AsmPrinter implements Pass {
    public PrintStream os;

    public AsmMod topAsmMod;
    private phyReg sp, ra, s0;

    public AsmPrinter(PrintStream os_){
        os = os_;
    }

    @Override
    public void visit(AsmMod mod) {
        topAsmMod = mod;
        sp = topAsmMod.regs.get(2);
        ra = topAsmMod.regs.get(1);
        s0 = topAsmMod.regs.get(8);

        os.println("\t.text\n");
        topAsmMod.fns.forEach(this::visit);
        topAsmMod.dts.forEach(this::visit);
    }

    @Override
    public void visit(AsmFn fn) {
        os.println("\t.globl\t" + fn.name);
        os.println("\t.p2align\t2");
        os.println(fn.name + ":");

        int stackSize = fn.offset + fn.maxOverCall;
        if (stackSize % 16 != 0)
            stackSize = (stackSize / 16 + 1) * 16;
        fn.entry.push_front(new ICalcOp(ICalcOp.IType.ADDI, s0, sp, new imm(stackSize)));
        fn.entry.push_front(new storeOp(4, s0, sp, new imm(stackSize - 8)));
        fn.entry.push_front(new storeOp(4, ra, sp, new imm(stackSize - 4)));
        fn.entry.push_front(new ICalcOp(ICalcOp.IType.ADDI, sp, sp, new imm(-stackSize)));
        AsmBlock bb = fn.blocks.size() > 0 ? fn.blocks.get(fn.blocks.size() - 1) : fn.entry;
        bb.push_back(new loadOp(4, s0, sp, new imm(stackSize - 8)));
        bb.push_back(new loadOp(4, ra, sp, new imm(stackSize - 4)));
        bb.push_back(new ICalcOp(ICalcOp.IType.ADDI, sp, sp, new imm(stackSize)));
        bb.push_back(new ret());

        visit(fn.entry);
        for (int i = 0; i < fn.blocks.size(); ++i) {
            bb = fn.blocks.get(i);
            os.println(bb.label + ":");
            visit(bb);
        }
        os.println();
    }

    @Override
    public void visit(AsmBlock block) {
        for (Instr iter = block.head; iter != null; iter = iter.nxt)
            os.println(iter);
    }

    @Override
    public void visit(AsmData dt) {
        os.println(dt);
    }

    @Override public void visit(brPseOp it) {}
    @Override public void visit(callPse it) {}
    @Override public void visit(cmpPseOp it) {}
    @Override public void visit(ICalcOp it) {}
    @Override public void visit(j it) {}
    @Override public void visit(la it) {}
    @Override public void visit(li it) {}
    @Override public void visit(loadOp it) {}
    @Override public void visit(mv it) {}
    @Override public void visit(RCalcOp it) {}
    @Override public void visit(ret it) {}
    @Override public void visit(storeOp it) {}
}
