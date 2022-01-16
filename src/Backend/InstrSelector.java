package Backend;

import Assembly.AsmBlock;
import Assembly.AsmData;
import Assembly.AsmFn;
import Assembly.AsmMod;
import Assembly.Instr.*;
import Assembly.Operand.Reg;
import Assembly.Operand.imm;
import Assembly.Operand.phyReg;
import LLVMIR.*;
import LLVMIR.Class;
import LLVMIR.Entity.*;
import LLVMIR.Module;
import LLVMIR.Stmt.*;
import LLVMIR.Stmt.ret;
import LLVMIR.Type.*;

import java.util.HashMap;

public class InstrSelector implements Pass {
    public AsmMod topAsmMod;
    public AsmFn currentFn;
    public AsmBlock currentBlock;

    public HashMap<Entity, Reg> regTrans;
    public HashMap<Entity, AsmBlock> blockMap;

    private int iterNum = 0;
    private phyReg zero, ra, sp, s0, a0, a1;

    public InstrSelector(AsmMod topAsmMod_){
        topAsmMod = topAsmMod_;
        regTrans = new HashMap<>();

        zero = topAsmMod.regs.get(0);
        ra = topAsmMod.regs.get(1);
        sp = topAsmMod.regs.get(2);
        s0 = topAsmMod.regs.get(8);
        a0 = topAsmMod.regs.get(10);
        a1 = topAsmMod.regs.get(11);
    }

    private boolean constInRange(int val){
        return -2048 <= val && val < 2048;
    }

    private Reg trans(Entity x){
        if (x instanceof constant){
            constant c = (constant) x;
            int val = c.getIntVal();
            if (val == 0) return zero;
            else {
                Reg ret = currentFn.addVReg(4);
                currentBlock.push_back(new li(ret, new imm(val)));
                return ret;
            }
        } else if (x instanceof globalEntity){
            globalEntity g = (globalEntity) x;
            Reg ret = currentFn.addVReg(4);
            currentBlock.push_back(new la(ret, g.name));
            return ret;
        } else return regTrans.get(x);
    }

    private Reg trans(Entity x, AsmBlock bb, Instr nxt){
        if (x instanceof constant){
            constant c = (constant) x;
            int val = c.getIntVal();
            if (val == 0) return zero;
            else {
                Reg ret = currentFn.addVReg(4);
                bb.insert_before(nxt, new li(ret, new imm(val)));
                return ret;
            }
        } else if (x instanceof globalEntity){
            globalEntity g = (globalEntity) x;
            Reg ret = currentFn.addVReg(4);
            bb.insert_before(nxt, new la(ret, g.name));
            return ret;
        } else return regTrans.get(x);
    }

    @Override
    public void visitModule(Module module) {
        module.cls.forEach(this::visitClass);
        module.fns.forEach(this::visitFunction);
        module.gVars.forEach(this::visitStmt);
    }

    @Override
    public void visitFunction(Function fn) {
        currentFn = topAsmMod.addFn(fn.identifier);
        currentBlock = currentFn.entry;
        for (int i = 0; i < Integer.min(8, fn.parameters.size()); ++i) {
            Entity para = fn.parameters.get(i);
            Reg rd = currentFn.addVReg(para.type.getBytes());
            currentBlock.push_back(new mv(rd, topAsmMod.regs.get(10 + i)));
            regTrans.put(para, rd);
        }
        for (int i = 8; i < fn.parameters.size(); ++i){
            Entity para = fn.parameters.get(i);
            Reg rd = currentFn.addVReg(para.type.getBytes());
            currentBlock.push_back(new loadOp(para.type.getBytes(), rd, s0, new imm((i - 8) * 4)));
            regTrans.put(para, rd);
        }

        blockMap = new HashMap<>();
        blockMap.put(fn.entry.label, currentFn.entry);
        fn.blocks.forEach(x -> blockMap.put(x.label, currentFn.addBlock()));

        for (iterNum = 0; iterNum < 2; ++iterNum) {
            currentBlock = currentFn.entry;
            visitBasicBlock(fn.entry);
            fn.blocks.forEach(x -> {
                currentBlock = blockMap.get(x.label);
                visitBasicBlock(x);
            });
        }
        iterNum = 0;
    }

    @Override
    public void visitClass(Class cl) {
        cl.offset.add(0);
        for (int i = 1; i < cl.vars.size(); ++i)
            cl.offset.add(cl.offset.get(cl.offset.size() - 1) + cl.vars.get(i).getBytes());
    }

    @Override
    public void visitBasicBlock(BasicBlock block) {
        block.stmts.forEach(this::visitStmt);
    }

    @Override
    public void visitStmt(Stmt stmt) {
        if (iterNum == 0 || stmt instanceof phi)
            stmt.accept(this);
    }

    @Override
    public void visit(alloca it) {
        Reg vreg = currentFn.addVReg(it.type.getBytes());
        regTrans.put(it.rd, vreg);
        currentFn.alloc(vreg, it.type.getBytes());
    }

    @Override
    public void visit(binaryOp it) {
        Reg res = currentFn.addVReg(it.rd.type.getBytes());
        constant c = null;
        if (it.rs2 instanceof constant)
            c = (constant) it.rs2;
        switch (it.opType) {
            case ADD -> {
                if (it.rs2 instanceof constant && constInRange(c.getIntVal()))
                        currentBlock.push_back(new ICalcOp(ICalcOp.IType.ADDI, res, trans(it.rs1), new imm(c.getIntVal())));
                else currentBlock.push_back(new RCalcOp(RCalcOp.RType.ADD, res, trans(it.rs1), trans(it.rs2)));
            }
            case SUB -> {
                if (it.rs2 instanceof constant && constInRange(c.getIntVal()))
                    currentBlock.push_back(new ICalcOp(ICalcOp.IType.ADDI, res, trans(it.rs1), new imm(-c.getIntVal())));
                else currentBlock.push_back(new RCalcOp(RCalcOp.RType.SUB, res, trans(it.rs1), trans(it.rs2)));
            }
            case MUL -> currentBlock.push_back(new RCalcOp(RCalcOp.RType.MUL, res, trans(it.rs1), trans(it.rs2)));
            case SDIV -> currentBlock.push_back(new RCalcOp(RCalcOp.RType.DIV, res, trans(it.rs1), trans(it.rs2)));
            case SREM -> currentBlock.push_back(new RCalcOp(RCalcOp.RType.REM, res, trans(it.rs1), trans(it.rs2)));
            case AND -> {
                if (it.rs2 instanceof constant && constInRange(c.getIntVal()))
                    currentBlock.push_back(new ICalcOp(ICalcOp.IType.ANDI, res, trans(it.rs1), new imm(c.getIntVal())));
                else currentBlock.push_back(new RCalcOp(RCalcOp.RType.AND, res, trans(it.rs1), trans(it.rs2)));
            }
            case OR -> {
                if (it.rs2 instanceof constant && constInRange(c.getIntVal()))
                        currentBlock.push_back(new ICalcOp(ICalcOp.IType.ORI, res, trans(it.rs1), new imm(c.getIntVal())));
                else currentBlock.push_back(new RCalcOp(RCalcOp.RType.OR, res, trans(it.rs1), trans(it.rs2)));
            }
            case XOR -> {
                if (it.rs2 instanceof constant && constInRange(c.getIntVal()))
                    currentBlock.push_back(new ICalcOp(ICalcOp.IType.XORI, res, trans(it.rs1), new imm(c.getIntVal())));
                else currentBlock.push_back(new RCalcOp(RCalcOp.RType.XOR, res, trans(it.rs1), trans(it.rs2)));
            }
            case SHL -> {
                if (it.rs2 instanceof constant && constInRange(c.getIntVal()))
                    currentBlock.push_back(new ICalcOp(ICalcOp.IType.SLLI, res, trans(it.rs1), new imm(c.getIntVal())));
                else currentBlock.push_back(new RCalcOp(RCalcOp.RType.SLL, res, trans(it.rs1), trans(it.rs2)));
            }
            case ASHR -> {
                if (it.rs2 instanceof constant && constInRange(c.getIntVal()))
                    currentBlock.push_back(new ICalcOp(ICalcOp.IType.SRAI, res, trans(it.rs1), new imm(c.getIntVal())));
                else currentBlock.push_back(new RCalcOp(RCalcOp.RType.SRA, res, trans(it.rs1), trans(it.rs2)));
            }
            case UDIV, UREM, LSHR -> {} // no need
        }
        regTrans.put(it.rd, res);
    }

    @Override
    public void visit(br it) {
        if (it.isCond) {
            Instr br = new brPseOp(brPseOp.brType.BEQZ, trans(it.cmpRes), blockMap.get(it.label2).label);
            blockMap.get(it.label2).prevInstr.put(currentBlock, br);
            currentBlock.push_back(br);
        }
        Instr j = new j(blockMap.get(it.label1).label);
        blockMap.get(it.label1).prevInstr.put(currentBlock, j);
        currentBlock.push_back(j);
    }

    @Override
    public void visit(call it) {
        int bytes = 0;
        for (int i = 8; i < it.parameters.size(); ++i)
            bytes += it.parameters.get(i).type.getBytes();
        currentFn.maxOverCall= Math.max(currentFn.maxOverCall, bytes);
        for (int i = 0; i < Math.min(8, it.parameters.size()); ++i) {
            Entity rs = it.parameters.get(i);
            constant c = null;
            if (rs instanceof constant)
                c = (constant) rs;
            if (rs instanceof constant && constInRange(c.getIntVal()))
                currentBlock.push_back(new ICalcOp(ICalcOp.IType.ADDI, topAsmMod.regs.get(10 + i),
                        zero, new imm(c.getIntVal())));
            else currentBlock.push_back(new mv(topAsmMod.regs.get(10 + i), trans(it.parameters.get(i))));
        }
        for (int i = 8; i < it.parameters.size(); ++i) {
            Entity rs = it.parameters.get(i);
            currentBlock.push_back(new storeOp(rs.type.getBytes(), trans(rs), sp, new imm((i - 8) * 4)));
        }
        currentBlock.push_back(new callPse(it.identifier));
        if (it.rd != null) {
            Reg res = currentFn.addVReg(it.rd.type.getBytes());
            currentBlock.push_back(new mv(res, a0));
            regTrans.put(it.rd, res);
        }
    }

    @Override
    public void visit(convertOp it) {
        switch (it.covType){
            case BITCAST -> {
                regTrans.put(it.rd, trans(it.rs));
            }
            case TRUNC, ZEXT, SEXT -> {} // no need
        }
    }

    @Override public void visit(declare it) {}

    @Override
    public void visit(getelementptr it) {
        Reg res = currentFn.addVReg(it.rd.type.getBytes());
        int bytes = it.type.getBytes();
        // only consider 1 arrOffset & classOffset
        Entity rs = it.arrOffset.get(0);
        constant c = null;
        if (rs instanceof constant)
            c = (constant) rs;
        if (rs instanceof constant && constInRange(c.getIntVal() * bytes)) {
            if (c.getIntVal() != 0)
                currentBlock.push_back(new ICalcOp(ICalcOp.IType.ADDI, res, trans(it.rs), new imm(c.getIntVal() * bytes)));
            else currentBlock.push_back(new mv(res, trans(it.rs)));
        } else {
            Reg l = trans(rs), r = currentFn.addVReg(rs.type.getBytes());
            currentBlock.push_back(new RCalcOp(RCalcOp.RType.MUL, r, l, trans(new constant(rs.type, bytes))));
            currentBlock.push_back(new RCalcOp(RCalcOp.RType.ADD, res, trans(it.rs), r));
        }
        if (it.classOffset.size() > 0){
            rs = it.classOffset.get(0);
            if (rs instanceof constant) {
                c = (constant) rs;
                int offset = ((classType) it.type).cl.offset.get(c.getIntVal());
                if (offset != 0)
                    currentBlock.push_back(new ICalcOp(ICalcOp.IType.ADDI, res, res, new imm(offset)));
            }
        }
        regTrans.put(it.rd, res);
    }

    @Override
    public void visit(global it) {
        if (it.init.type instanceof arrayType){
            arrayType t = (arrayType) it.init.type;
            if (t.type instanceof baseType) {
                baseType base = (baseType) t.type;
                if (base.i_N == 8 && it.init instanceof constant) {
                    constant c = (constant) it.init;
                    String str = c.str.replace("\\0A", "\\n").replace("\\22", "\\\"").replace("\\5C", "\\\\");
                    topAsmMod.dts.add(new AsmData(it.defType == global.defineType.CONSTANT,
                            ((globalEntity) it.rd).name, str));
                }
            }
        } else {
            if (it.init instanceof constant) {
                constant c = (constant) it.init;
                topAsmMod.dts.add(new AsmData(it.defType == global.defineType.CONSTANT,
                        ((globalEntity) it.rd).name, c.getIntVal(), c.isBoolean()));
            }
        }
    }

    @Override
    public void visit(icmp it) {
        Reg res = currentFn.addVReg(it.rd.type.getBytes());
        switch (it.cmpType){
            case EQ, NE -> {
                Reg xor = currentFn.addVReg(it.lhs.type.getBytes());
                currentBlock.push_back(new RCalcOp(RCalcOp.RType.XOR, xor, trans(it.lhs), trans(it.rhs)));
                currentBlock.push_back(new cmpPseOp(it.cmpType == icmp.compareType.EQ ?
                        cmpPseOp.cmpType.SEQZ : cmpPseOp.cmpType.SNEZ, res, xor));
            }
            case SLT, SGT -> {
                Entity l = it.lhs, r = it.rhs;
                if (it.cmpType == icmp.compareType.SGT){
                    l = it.rhs; r = it.lhs;
                }
                currentBlock.push_back(new RCalcOp(RCalcOp.RType.SLT, res, trans(l), trans(r)));
            }
            case SLE, SGE -> {
                Entity l = it.lhs, r = it.rhs;
                if (it.cmpType == icmp.compareType.SLE){
                    l = it.rhs; r = it.lhs;
                }
                currentBlock.push_back(new RCalcOp(RCalcOp.RType.SLT, res, trans(l), trans(r)));
                currentBlock.push_back(new ICalcOp(ICalcOp.IType.XORI, res, res, new imm(1)));
            }
            case UGE, UGT,  ULE, ULT -> {} // no need
        }
        regTrans.put(it.rd, res);
    }

    @Override
    public void visit(load it) {
        Reg vrd = currentFn.addVReg(it.rd.type.getBytes());
        if (it.rs instanceof globalEntity) {
            globalEntity rs = (globalEntity) it.rs;
            currentBlock.push_back(new loadOp(it.Type.getBytes(), vrd, rs.name));
        } else {
            Reg rs = trans(it.rs);
            if (currentFn.stackOffset.containsKey(rs)) {
                int imm = -currentFn.stackOffset.get(trans(it.rs));
                if (constInRange(imm))
                    currentBlock.push_back(new loadOp(it.Type.getBytes(), vrd, s0, new imm(imm)));
                else {
                    Reg t = currentFn.addVReg(4);
                    currentBlock.push_back(new li(t, new imm(imm)));
                    currentBlock.push_back(new RCalcOp(RCalcOp.RType.ADD, t, s0, t));
                    currentBlock.push_back(new loadOp(it.Type.getBytes(), vrd, t, new imm(0)));
                }
            }
            else currentBlock.push_back(new loadOp(it.Type.getBytes(), vrd, rs, new imm(0)));
        }
        regTrans.put(it.rd, vrd);
    }

    @Override
    public void visit(phi it) {
        if (iterNum == 0){
            Reg res = currentFn.addVReg(it.rd.type.getBytes());
            regTrans.put(it.rd, res);
        } else {
            for (int i = 0; i < it.label.size(); ++i) {
                AsmBlock bb = blockMap.get(it.label.get(i));
                Instr from = currentBlock.prevInstr.get(bb);
                Instr mv = new mv(trans(it.rd), trans(it.val.get(i), bb, from));
                bb.insert_before(from, mv);
            }
        }
    }

    @Override
    public void visit(ret it) {
        currentBlock.push_back(new mv(a0, trans(it.ret)));
    }

    @Override
    public void visit(store it) {
        if (it.rd instanceof globalEntity) {
            globalEntity rd = (globalEntity) it.rd;
            Reg rt = currentFn.addVReg(4);
            currentBlock.push_back(new storeOp(it.rs.type.getBytes(), trans(it.rs), rd.name, rt));
        } else{
            Reg rd = trans(it.rd);
            if (currentFn.stackOffset.containsKey(rd)) {
                int imm = -currentFn.stackOffset.get(rd);
                if (constInRange(imm))
                    currentBlock.push_back(new storeOp(it.rs.type.getBytes(), trans(it.rs), s0, new imm(imm)));
                else {
                    Reg t = currentFn.addVReg(4);
                    currentBlock.push_back(new li(t, new imm(imm)));
                    currentBlock.push_back(new RCalcOp(RCalcOp.RType.ADD, t, s0, t));
                    currentBlock.push_back(new storeOp(it.rs.type.getBytes(), trans(it.rs), t, new imm(0)));
                }
            } else currentBlock.push_back(new storeOp(it.rs.type.getBytes(), trans(it.rs), rd, new imm(0)));
        }
    }
}
