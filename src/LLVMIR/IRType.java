package LLVMIR;

public class IRType {
    public enum typeToken{
        VOID, I, FLOAT, DOUBLE
    }

    public typeToken typeName;
    public int i_N;
    public Boolean isPtr;

    public IRType(typeToken typeName_, int i_N_, Boolean isPtr_){
        typeName = typeName_;
        i_N = i_N_;
        isPtr = isPtr_;
    }
    public IRType(IRType other){
        typeName = other.typeName;
        i_N = other.i_N;
        isPtr = other.isPtr;
    }
}
