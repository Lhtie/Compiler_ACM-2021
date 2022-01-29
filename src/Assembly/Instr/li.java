package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Operand.Reg;
import Assembly.Pass;

import java.util.ArrayList;
import java.util.List;

public class li extends Instr {
    public Operand rd, imm;

    public li(Operand rd_, Operand imm_){
        rd = rd_;
        imm = imm_;
    }

    @Override
    public ArrayList<Reg> def() {
        return new ArrayList<>(List.of((Reg) rd));
    }

    @Override
    public ArrayList<Reg> use() {
        return new ArrayList<>();
    }

    @Override
    public void push_def(ArrayList<Reg> def) {
        rd = def.get(0);
    }

    @Override
    public void push_use(ArrayList<Reg> use) {}

    @Override
    public String toString(){
        return "\tli\t" + rd + ", " + imm;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
