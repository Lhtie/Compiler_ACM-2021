package Assembly.Instr;

import Assembly.Pass;

public class j extends Instr {
    public String offset;

    public j(String offset_){
        offset = offset_;
    }

    @Override
    public String toString(){
        return "\tj\t" + offset;
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
