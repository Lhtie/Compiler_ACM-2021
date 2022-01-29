package Assembly.Instr;

import Assembly.Operand.Reg;
import Assembly.Pass;

import java.util.ArrayList;

public class callPse extends Instr {
    public String symbol;

    public callPse(String symbol_){
        symbol = symbol_;
    }

    @Override
    public ArrayList<Reg> def() {
        return new ArrayList<>();
    }

    @Override
    public ArrayList<Reg> use() {
        return new ArrayList<>();
    }

    @Override
    public void push_def(ArrayList<Reg> def) {}

    @Override
    public void push_use(ArrayList<Reg> use) {}

    @Override
    public String toString(){
        return "\tcall\t" + symbol;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
