package AST;

import Util.position;

import javax.swing.text.StyledEditorKit;

public class funcTypeNode extends ASTNode{
    public typeNode type;
    public Boolean isVoid;

    public funcTypeNode(position pos, Boolean isVoid_){
        super(pos);
        isVoid = isVoid_;
    }

    public funcTypeNode(position pos, Boolean isVoid_, typeNode type_){
        super(pos);
        isVoid = isVoid_;
        type = type_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
