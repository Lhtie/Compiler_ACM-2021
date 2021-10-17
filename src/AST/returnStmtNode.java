package AST;

import Util.position;

public class returnStmtNode extends FlowStmtNode{
    public ExprNode expr;

    public returnStmtNode(position pos, ExprNode expr_){
        super(pos);
        expr = expr_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
