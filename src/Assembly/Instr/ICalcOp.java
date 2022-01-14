package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Operand.imm;
import Assembly.Pass;

public class ICalcOp extends Instr {
    public enum IType{
        ADDI, SLTI, SLTIU, XORI, ORI, ANDI, SLLI, SRLI, SRAI
    }

    public IType type;
    public Operand rd, rs, im;

    public ICalcOp(IType type_, Operand rd_, Operand rs_, Operand im_){
        type = type_;
        rd = rd_;
        rs = rs_;
        im = im_;
    }

    @Override
    public String toString(){
        return "\t" + type.name().toLowerCase() + "\t" + rd + ", " + rs + ", " + im;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
