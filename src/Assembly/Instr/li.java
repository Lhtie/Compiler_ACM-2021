package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Pass;

public class li extends Instr {
    public Operand rd, imm;

    public li(Operand rd_, Operand imm_){
        rd = rd_;
        imm = imm_;
    }

    @Override
    public String toString(){
        return "\tli\t" + rd + ", " + imm;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
