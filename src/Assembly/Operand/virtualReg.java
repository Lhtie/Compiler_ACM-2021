package Assembly.Operand;

public class virtualReg extends Reg {
    public int index;
    public int bytes;

    public virtualReg(int index_, int bytes_) {
        index = index_;
        bytes = bytes_;
    }

    @Override
    public String toString(){
        return "%" + index;
    }
}
