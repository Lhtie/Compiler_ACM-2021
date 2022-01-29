package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Operand.Reg;
import Assembly.Pass;

import java.util.ArrayList;
import java.util.List;

public class mv extends Instr {
    public Operand rd, rs;

    public mv(Operand rd_, Operand rs_){
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
        return "\tmv\t" + rd + ", " + rs;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
