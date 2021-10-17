package AST;

import Util.position;

public class forStopNode extends ASTNode{
    public ExprNode expr;

    public forStopNode(position pos, ExprNode expr_){
        super(pos);
        expr = expr_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
