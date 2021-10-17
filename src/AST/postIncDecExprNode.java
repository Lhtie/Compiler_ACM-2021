package AST;

import Util.position;

public class postIncDecExprNode extends ExprNode{
    public enum postIncDecOpType{
        PLUSPLUS, MINUSMINUS
    }

    public postIncDecOpType postIncDecOp;
    public ExprNode expr;

    public postIncDecExprNode(position pos, postIncDecOpType postIncDecOp_, ExprNode expr_){
        super(pos);
        postIncDecOp = postIncDecOp_;
        expr = expr_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
