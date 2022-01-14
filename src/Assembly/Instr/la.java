package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Pass;

public class la extends Instr {
    public Operand rd;
    public String symbol;

    public la(Operand rd_, String symbol_){
        rd = rd_;
        symbol = symbol_;
    }

    @Override
    public String toString(){
        return "\tla\t" + rd + ", " + symbol;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
