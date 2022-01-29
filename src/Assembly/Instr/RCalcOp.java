package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Operand.Reg;
import Assembly.Pass;

import java.util.ArrayList;
import java.util.List;

public class RCalcOp extends Instr {
    public enum RType{
        ADD, SUB, SLL, SLT, SLTU, XOR, SRL, SRA, OR, AND,
        MUL, DIV, REM
    }

    public RType type;
    public Operand rd, rs1, rs2;

    public RCalcOp(RType type_, Operand rd_, Operand rs1_, Operand rs2_){
        type = type_;
        rd = rd_;
        rs1 = rs1_;
        rs2 = rs2_;
    }

    @Override
    public ArrayList<Reg> def() {
        return new ArrayList<>(List.of((Reg) rd));
    }

    @Override
    public ArrayList<Reg> use() {
        return new ArrayList<>(List.of((Reg) rs1, (Reg) rs2));
    }

    @Override
    public void push_def(ArrayList<Reg> def) {
        rd = def.get(0);
    }

    @Override
    public void push_use(ArrayList<Reg> use) {
        rs1 = use.get(0);
        rs2 = use.get(1);
    }

    @Override
    public String toString(){
        return "\t" + type.name().toLowerCase() + "\t" + rd + ", " + rs1 + ", " + rs2;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
