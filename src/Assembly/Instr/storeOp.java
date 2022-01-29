package Assembly.Instr;

import Assembly.Operand.Operand;
import Assembly.Operand.Reg;
import Assembly.Pass;

import java.util.ArrayList;
import java.util.List;

public class storeOp extends Instr {
    public enum storeOpType{
        SB, SH, SW
    }

    public storeOpType type;
    public Operand rd;
    public Operand rs = null, imm = null;
    public String symbol = null;
    public Operand rt = null;

    public storeOp(int bytes, Operand rd_, Operand rs_, Operand imm_){
        if (bytes == 1)
            type = storeOpType.SB;
        else if (bytes == 2)
            type = storeOpType.SH;
        else // if (bytes == 4)
            type = storeOpType.SW;
        rd = rd_;
        rs = rs_;
        imm = imm_;
    }

    public storeOp(int bytes, Operand rd_, String symbol_, Operand rt_){
        if (bytes == 1)
            type = storeOpType.SB;
        else if (bytes == 2)
            type = storeOpType.SH;
        else // if (bytes == 4)
            type = storeOpType.SW;
        rd = rd_;
        symbol = symbol_;
        rt = rt_;
    }

    @Override
    public ArrayList<Reg> def() {
        if (symbol == null) return new ArrayList<>();
        else return new ArrayList<>(List.of((Reg) rt));
    }

    @Override
    public ArrayList<Reg> use() {
        ArrayList<Reg> ret = new ArrayList<>(List.of((Reg) rd));
        if (symbol == null) ret.add((Reg) rs);
        return ret;
    }

    @Override
    public void push_def(ArrayList<Reg> def) {
        if (symbol != null)
            rt = def.get(0);
    }

    @Override
    public void push_use(ArrayList<Reg> use) {
        rd = use.get(0);
        if (symbol == null) rs = use.get(1);
    }

    @Override
    public String toString() {
        return "\t" + type.name().toLowerCase() + "\t" + rd + ", "
                + (symbol != null ? symbol + ", " + rt : imm + "(" + rs + ")");
    }

    @Override
    public void accept(Pass visitor) {
        visitor.visit(this);
    }
}
