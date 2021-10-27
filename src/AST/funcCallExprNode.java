package AST;

import Util.position;

public class funcCallExprNode extends ExprNode{
    public ExprNode expr;
    public argListNode argList;

    public funcCallExprNode(position pos, ExprNode expr_, argListNode argList_){
        super(pos);
        expr = expr_;
        argList = argList_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
