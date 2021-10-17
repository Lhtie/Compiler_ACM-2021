package AST;

import Grammars.MxStarParser;
import Util.position;

public class whileStmtNode extends LoopStmtNode{
    public ExprNode expr;
    public blockNode block;

    public whileStmtNode(position pos, ExprNode expr_, blockNode block_) {
        super(pos);
        expr = expr_;
        block = block_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
