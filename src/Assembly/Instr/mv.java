package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Pass;

public class mv extends Instr {
    public Operand rd, rs;

    public mv(Operand rd_, Operand rs_){
        rd = rd_;
        rs = rs_;
    }

    @Override
    public String toString(){
        return "\tmv\t" + rd + ", " + rs;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
