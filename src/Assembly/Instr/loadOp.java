package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Pass;

public class loadOp extends Instr {
    public enum loadOpType{
        LB, LH, LW, LBU, LHU
    }

    public loadOpType type;
    public Operand rd;
    public Operand rs = null, imm = null;
    public String symbol = null;

    public loadOp(int bytes, Operand rd_, Operand rs_, Operand imm_){
        if (bytes == 1)
            type = loadOpType.LB;
        else if (bytes == 2)
            type = loadOpType.LH;
        else // if (bytes == 4)
            type = loadOpType.LW;
        rd = rd_;
        rs = rs_;
        imm = imm_;
    }

    public loadOp(int bytes, Operand rd_, String symbol_){
        if (bytes == 1)
            type = loadOpType.LB;
        else if (bytes == 2)
            type = loadOpType.LH;
        else // if (bytes == 4)
            type = loadOpType.LW;
        rd = rd_;
        symbol = symbol_;
    }

    @Override
    public String toString() {
        return "\t" + type.name().toLowerCase() + "\t" + rd + ", " +
                (symbol != null ? symbol : imm + "(" + rs + ")");
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
