package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Operand.Reg;
import Assembly.Pass;

import java.util.ArrayList;
import java.util.List;

public class la extends Instr {
    public Operand rd;
    public String symbol;

    public la(Operand rd_, String symbol_){
        rd = rd_;
        symbol = symbol_;
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
        return "\tla\t" + rd + ", " + symbol;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
