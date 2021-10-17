package AST;

import Util.position;

public class preIncDecExprNode extends ExprNode{
    public enum preIncDecOpType{
        PLUSPLUS, MINUSMINUS
    }

    public preIncDecOpType preIncDecOp;
    public ExprNode expr;

    public preIncDecExprNode(position pos, preIncDecOpType preIncDecOp_, ExprNode expr_){
        super(pos);
        preIncDecOp = preIncDecOp_;
        expr = expr_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
