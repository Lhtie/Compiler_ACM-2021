package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Pass;

public class brPseOp extends Instr {
    public enum brType{
        BEQZ, BNEZ, BLEZ, BGEZ, BLTZ, BGTZ
    }

    public brType type;
    public Operand rs;
    public String offset;

    public brPseOp(brType type_, Operand rs_, String offset_){
        type = type_;
        rs = rs_;
        offset = offset_;
    }

    @Override
    public String toString(){
        return "\t" + type.name().toLowerCase() + "\t" + rs + ", " + offset;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
