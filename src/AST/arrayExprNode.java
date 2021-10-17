package AST;

import Util.position;

public class arrayExprNode extends ExprNode{
    public ExprNode title, index;

    public arrayExprNode(position pos, ExprNode title_, ExprNode index_){
        super(pos);
        title = title_;
        index = index_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
