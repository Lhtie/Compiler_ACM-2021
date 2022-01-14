package Assembly.Instr;

import Assembly.Pass;

public abstract class Instr {
    public Instr prv = null, nxt = null;

    public abstract String toString();
    public abstract void accept(Pass visitor);
}
