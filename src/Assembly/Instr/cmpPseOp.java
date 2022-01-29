package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Operand.Reg;
import Assembly.Pass;

import java.util.ArrayList;
import java.util.List;

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
        return "\t" + type.name().toLowerCase() + "\t" + rd + ", " + rs;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
