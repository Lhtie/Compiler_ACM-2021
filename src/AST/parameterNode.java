package AST;

import Util.position;

public class parameterNode extends ASTNode{
    public typeNode type;
    public String name;

    public parameterNode(position pos, typeNode type_, String name_){
        super(pos);
        type = type_;
        name = name_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
