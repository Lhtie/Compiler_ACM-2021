package LLVMIR.Type;

public class ptrType extends IRType{
    public IRType type;

    public ptrType(IRType type_){
        type = type_;
    }

    @Override
    public String toString(){
        return type + "*";
    }

    @Override
    public int getBytes() {
        return 4;
    }
}
