package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Pass;

public class cmpPseOp extends Instr {
    public enum cmpType{
        SEQZ, SNEZ, SLTZ, SGTZ
    }

    public cmpType type;
    public Operand rd, rs;

    public cmpPseOp(cmpType type_, Operand rd_, Operand rs_){
        type = type_;
        rd = rd_;
        rs = rs_;
    }

    @Override
    public String toString(){
        return "\t" + type.name().toLowerCase() + "\t" + rd + ", " + rs;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
