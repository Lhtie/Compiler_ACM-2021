package LLVMIR.Entity;

import LLVMIR.Type.*;

public class constant extends Entity {
    public enum constantType{
        I1, I32, I64, NULL, VOID, STRING
    }

    public constantType constType;
    public boolean i1;
    public int i32;
    public long i64;
    public String str;

    public constant(IRType type_, long integer){
        super(type_);
        if (type_ instanceof baseType){
            if (((baseType) type_).typeName == baseType.typeToken.VOID)
                constType = constantType.VOID;
            else if (((baseType) type_).i_N == 1){
                constType = constant.constantType.I1;
                i1 = (integer & 1) == 1;
            } else if (((baseType) type_).i_N == 32) {
                constType = constant.constantType.I32;
                i32 = (int) integer;
            } else {
                constType = constantType.I64;
                i64 = integer;
            }
        }
        else if (type_ instanceof ptrType){
            constType = constantType.NULL;
        }
    }

    public constant(IRType type_, String str_){
        super(type_);
        constType = constantType.STRING;
        str = str_;
    }

    @Override
    public String getValue() {
        return switch (constType) {
            case I1 -> Boolean.toString(i1);
            case I32 -> Integer.toString(i32);
            case I64 -> Long.toString(i64);
            case NULL -> "null";
            case VOID -> null;
            case STRING -> "c\"" + str + "\\00\"";
        };
    }

    @Override
    public String toString(){
        if (constType == constantType.VOID)
            return super.toString();
        else return super.toString() + " " + getValue();
    }
}
