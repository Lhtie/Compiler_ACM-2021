package AST;

import Util.position;

public class elseStmtNode extends ASTNode{
    public blockNode block;

    public elseStmtNode(position pos, blockNode block_){
        super(pos);
        block = block_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
