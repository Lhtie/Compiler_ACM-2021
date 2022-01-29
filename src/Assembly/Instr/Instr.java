package Assembly.Instr;

import Assembly.Operand.Reg;
import Assembly.Pass;

import java.util.ArrayList;

public abstract class Instr {
    public Instr prv = null, nxt = null;

    public abstract ArrayList<Reg> def();
    public abstract ArrayList<Reg> use();
    public abstract void push_def(ArrayList<Reg> def);
    public abstract void push_use(ArrayList<Reg> use);
    public abstract String toString();
    public abstract void accept(Pass visitor);
}
