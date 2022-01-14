package Assembly.Instr;

import Assembly.Pass;

public class callPse extends Instr {
    public String symbol;

    public callPse(String symbol_){
        symbol = symbol_;
    }

    @Override
    public String toString(){
        return "\tcall\t" + symbol;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
