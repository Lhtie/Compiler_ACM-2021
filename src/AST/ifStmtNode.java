package AST;

import Grammars.MxStarParser;
import Util.position;

public class ifStmtNode extends StmtNode{
    public ExprNode expr;
    public blockNode block;
    public elseStmtNode elseStmt;

    public ifStmtNode(position pos, ExprNode expr_, blockNode block_, elseStmtNode elseStmt_){
        super(pos);
        expr = expr_;
        block = block_;
        elseStmt = elseStmt_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
