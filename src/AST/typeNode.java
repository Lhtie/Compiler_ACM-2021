package AST;

import Util.position;

public class typeNode extends ASTNode{
    public String classId;
    public basicTypeNode basicType;
    public int dim;

    public typeNode(position pos, String classId_, basicTypeNode basicType_, int dim_){
        super(pos);
        classId = classId_;
        basicType = basicType_;
        dim = dim_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

