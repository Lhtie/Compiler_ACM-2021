package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Operand.Reg;
import Assembly.Pass;

import java.util.ArrayList;
import java.util.List;

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
    public ArrayList<Reg> def() {
        return new ArrayList<>(List.of((Reg) rd));
    }

    @Override
    public ArrayList<Reg> use() {
        return new ArrayList<>(List.of((Reg) rs));
    }

    @Override
    public void push_def(ArrayList<Reg> def) {
        rd = def.get(0);
    }

    @Override
    public void push_use(ArrayList<Reg> use) {
        rs = use.get(0);
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
