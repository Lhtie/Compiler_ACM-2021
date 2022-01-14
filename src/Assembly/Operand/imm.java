package Assembly.Operand;

public class imm extends Operand {
    public int value;

    public imm(int value_){
        value = value_;
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }
}
