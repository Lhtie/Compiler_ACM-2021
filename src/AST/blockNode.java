package AST;

import Util.position;

public class blockNode extends ASTNode{
    public suiteNode suite;
    public StmtNode stmt;

    public blockNode(position pos, suiteNode suite_, StmtNode stmt_){
        super(pos);
        suite = suite_;
        stmt = stmt_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
