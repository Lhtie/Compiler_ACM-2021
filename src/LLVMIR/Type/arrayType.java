package LLVMIR.Type;

public class arrayType extends IRType{
    // [size x type]
    int size;
    public IRType type;

    public arrayType(int size_, IRType type_){
        size = size_;
        type = type_;
    }

    @Override
    public String toString(){
        return "[" + Integer.toString(size) + " x " + type + "]";
    }
}
