package AST;

import Util.position;
import Util.Type;

public class basicTypeNode extends ASTNode{
    public Type.typeToken basicType;

    public basicTypeNode(position pos, Type.typeToken basicType_){
        super(pos);
        basicType = basicType_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
