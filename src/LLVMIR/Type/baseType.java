package LLVMIR.Type;

public class baseType extends IRType{
    public enum typeToken{
        VOID, LABEL, I
    }

    public typeToken typeName;
    public int i_N;

    public baseType(typeToken typeName_, int i_N_){
        typeName = typeName_;
        i_N = i_N_;
    }

    public baseType(typeToken typeName_){
        typeName = typeName_;
        i_N = 0;
    }

    @Override
    public String toString(){
        String ret = typeName.name().toLowerCase();
        if (typeName == typeToken.I)
            ret += Integer.toString(i_N);
        return ret;
    }
}
