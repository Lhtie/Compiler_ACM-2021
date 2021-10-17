package AST;

import Util.position;

public class creatorSizeNode extends ASTNode{
    public ExprNode expr;

    public creatorSizeNode(position pos, ExprNode expr_){
        super(pos);
        expr = expr_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
