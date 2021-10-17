package AST;

import Util.position;

public class basicTypeNode extends ASTNode{
    public enum basicTypeToken{
        BOOL, INT, STRING
    }
    public basicTypeToken basicType;

    public basicTypeNode(position pos, basicTypeToken basicType_){
        super(pos);
        basicType = basicType_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
