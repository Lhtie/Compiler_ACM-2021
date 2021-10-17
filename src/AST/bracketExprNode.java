package AST;

import Util.position;

public class bracketExprNode extends ExprNode{
    public ExprNode expr;

    public bracketExprNode(position pos, ExprNode expr_){
        super(pos);
        expr = expr_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
