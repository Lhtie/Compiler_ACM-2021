package LLVMIR.Entity;

import LLVMIR.Type.*;
import AST.binaryExprNode;

public class constant extends Entity {
    public enum constantType{
        I1, I8, I32, I64, NULL, VOID, STRING, UNDEF
    }

    public constantType constType;
    public boolean i1;
    public int i8, i32;
    public long i64;
    public String str;

    public constant(IRType type_){
        super(false, type_);
        if (type_ instanceof baseType) {
            if (((baseType) type_).typeName == baseType.typeToken.VOID)
                constType = constantType.VOID;
            else if (((baseType) type_).typeName == baseType.typeToken.I) {
                if (((baseType) type_).i_N == 1) {
                    constType = constant.constantType.I1;
                    i1 = false;
                } else if (((baseType) type_).i_N == 8){
                    constType = constant.constantType.I8;
                    i8 = 0;
                } else if (((baseType) type_).i_N == 32) {
                    constType = constant.constantType.I32;
                    i32 = 0;
                } else {
                    constType = constantType.I64;
                    i64 = 0;
                }
            }
        } else if (type_ instanceof ptrType)
            constType = constantType.NULL;
    }

    public constant(IRType type_, long integer){
        super(false, type_);
        assert(type_ instanceof baseType);
        int i_N = ((baseType) type_).i_N;
        assert(i_N == 8 || i_N == 32 || i_N == 64);
        if (i_N == 8){
            constType = constant.constantType.I8;
            i8 = 0;
        } else if (i_N == 32) {
            constType = constant.constantType.I32;
            i32 = (int) integer;
        } else {
            constType = constantType.I64;
            i64 = integer;
        }
    }

    public constant(IRType type_, boolean bool){
        super(false, type_);
        assert(type_ instanceof baseType && ((baseType) type_).i_N == 1);
        constType = constantType.I1;
        i1 = bool;
    }

    public constant(IRType type_, String str_){
        super(false, type_);
        assert(type_ instanceof arrayType);
        constType = constantType.STRING;
        str = str_;
    }

    public constant(IRType type_, constantType constType_){
        super(false, type_);
        constType = constType_;
    }

    public boolean isInteger(){
        return constType == constantType.I8 || constType == constantType.I32 || constType == constantType.I64;
    }

    public boolean isBoolean(){
        return constType == constantType.I1;
    }

    public int getIntVal(){
        if (isInteger())
            return constType == constantType.I32 ? i32 : i8;
        else if (isBoolean())
            return i1 ? 1 : 0;
        return 0;
    }

    public Entity neg(){
        assert(isInteger());
        return new constant(type, constType == constantType.I64 ? -i64 : -getIntVal());
    }

    public Entity not(){
        if (isBoolean())
            return new constant(type, !i1);
        else {
            assert(isInteger());
            return new constant(type, constType == constantType.I64 ? ~i64 : ~getIntVal());
        }
    }

    public Entity binaryOp(binaryExprNode it, Entity other){
        assert(other instanceof constant);
        constant ot = (constant) other;
        if (it.isCmpOp()){
            IRType i1Type = new baseType(baseType.typeToken.I, 1);
            if (it.binaryOp == binaryExprNode.binaryOpType.EQUALS){
                if (isBoolean()){
                    assert(ot.isBoolean());
                    return new constant(i1Type, i1 == ot.i1);
                } else if (isInteger()){
                    assert(ot.isInteger());
                    return new constant(i1Type, constType == constantType.I32 ? i32 == ot.i32 : i64 == ot.i64);
                } else {
                    return new constant(i1Type, constType == ot.constType);
                }
            } else if (it.binaryOp == binaryExprNode.binaryOpType.NOT_EQ){
                if (isBoolean()){
                    assert(ot.isBoolean());
                    return new constant(i1Type, i1 != ot.i1);
                } else if (isInteger()){
                    assert(ot.isInteger());
                    return new constant(i1Type, constType == constantType.I32 ? i32 != ot.i32 : i64 != ot.i64);
                } else {
                    return new constant(i1Type, constType != ot.constType);
                }
            } else {
                assert(isInteger() && ot.isInteger());
                if (it.binaryOp == binaryExprNode.binaryOpType.LESS_THAN)
                    return new constant(i1Type, constType == constantType.I32 ? i32 < ot.i32 : i64 < ot.i64);
                else if (it.binaryOp == binaryExprNode.binaryOpType.GREATER_THAN)
                    return new constant(i1Type, constType == constantType.I32 ? i32 > ot.i32 : i64 > ot.i64);
                else if (it.binaryOp == binaryExprNode.binaryOpType.LT_EQ)
                    return new constant(i1Type, constType == constantType.I32 ? i32 <= ot.i32 : i64 <= ot.i64);
                else // it.binaryOp == binaryExprNode.binaryOpType.GT_EQ)
                    return new constant(i1Type, constType == constantType.I32 ? i32 >= ot.i32 : i64 >= ot.i64);
            }
        } else {
            assert (it.isArithOp() && isInteger() && ot.isInteger());
            if (it.binaryOp == binaryExprNode.binaryOpType.PLUS)
                return new constant(type, constType == constantType.I32 ? i32 + ot.i32 : i64 + ot.i64);
            else if (it.binaryOp == binaryExprNode.binaryOpType.MINUS)
                return new constant(type, constType == constantType.I32 ? i32 - ot.i32 : i64 - ot.i64);
            else if (it.binaryOp == binaryExprNode.binaryOpType.STAR)
                return new constant(type, constType == constantType.I32 ? i32 * ot.i32 : i64 * ot.i64);
            else if (it.binaryOp == binaryExprNode.binaryOpType.DIV) {
                if (constType == constantType.I32)
                    if (ot.i32 == 0) return new constant(type, constantType.UNDEF);
                    else return new constant(type, i32 / ot.i32);
                else if (ot.i64 == 0) return new constant(type, constantType.UNDEF);
                    else return new constant(type, i64 / ot.i64);
            } else if (it.binaryOp == binaryExprNode.binaryOpType.MOD)
                return new constant(type, constType == constantType.I32 ? i32 % ot.i32 : i64 % ot.i64);
            else if (it.binaryOp == binaryExprNode.binaryOpType.LEFT_SHIFT)
                return new constant(type, constType == constantType.I32 ? i32 << ot.i32 : i64 << ot.i64);
            else if (it.binaryOp == binaryExprNode.binaryOpType.RIGHT_SHIFT)
                return new constant(type, constType == constantType.I32 ? i32 >> ot.i32 : i64 >> ot.i64);
            else if (it.binaryOp == binaryExprNode.binaryOpType.OR_OP)
                return new constant(type, constType == constantType.I32 ? i32 | ot.i32 : i64 | ot.i64);
            else if (it.binaryOp == binaryExprNode.binaryOpType.AND_OP)
                return new constant(type, constType == constantType.I32 ? i32 & ot.i32 : i64 & ot.i64);
            else // it.binaryOp == binaryExprNode.binaryOpType.XOR_OP)
                return new constant(type, constType == constantType.I32 ? i32 ^ ot.i32 : i64 ^ ot.i64);
        }
    }

    @Override
    public String getValue() {
        return switch (constType) {
            case I1 -> Boolean.toString(i1);
            case I8 -> Integer.toString(i8);
            case I32 -> Integer.toString(i32);
            case I64 -> Long.toString(i64);
            case NULL -> "null";
            case VOID -> null;
            case STRING -> "c\"" + str + "\\00\"";
            case UNDEF -> "undef";
        };
    }

    @Override
    public String toString(){
        if (constType == constantType.VOID)
            return super.toString();
        else return super.toString() + " " + getValue();
    }
}
