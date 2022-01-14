package Assembly.Operand;

public class phyReg extends Reg {
    public String name;

    public phyReg(String name_){
        name = name_;
    }

    @Override
    public String toString(){
        return name;
    }
}
