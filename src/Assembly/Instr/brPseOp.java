package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Operand.Reg;
import Assembly.Pass;

import java.util.ArrayList;
import java.util.List;

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
    public ArrayList<Reg> def() {
        return new ArrayList<>();
    }

    @Override
    public ArrayList<Reg> use() {
        return new ArrayList<>(List.of((Reg) rs));
    }

    @Override
    public void push_def(ArrayList<Reg> def) {}

    @Override
    public void push_use(ArrayList<Reg> use) {
        rs = use.get(0);
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
