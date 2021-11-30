package LLVMIR.Entity;

import LLVMIR.IRType;

public class constant extends Entity {
    public int i32;

    public constant(IRType type_, int i32_){
        super(type_);
        i32 = i32_;
    }
}
