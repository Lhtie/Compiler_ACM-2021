package Assembly.Instr;

import Assembly.Pass;

public class ret extends Instr {
    @Override
    public String toString(){
        return "\tret";
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
