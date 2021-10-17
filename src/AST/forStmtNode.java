package AST;

import Util.position;

public class forStmtNode extends LoopStmtNode{
    public forInitNode forInit;
    public forStopNode forStop;
    public ExprNode expr;
    public blockNode block;

    public forStmtNode(position pos, forInitNode forInit_, forStopNode forStop_,
                       ExprNode expr_, blockNode block_){
        super(pos);
        forInit = forInit_;
        forStop = forStop_;
        expr = expr_;
        block = block_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
