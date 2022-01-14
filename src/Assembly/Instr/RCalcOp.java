package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Pass;

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
    public String toString(){
        return "\t" + type.name().toLowerCase() + "\t" + rd + ", " + rs1 + ", " + rs2;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
