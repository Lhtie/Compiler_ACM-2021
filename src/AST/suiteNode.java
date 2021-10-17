package AST;

import Util.position;

import java.util.ArrayList;

public class suiteNode extends ASTNode{
    public suiteNode suite;
    public ArrayList<StmtNode> stmt;

    public suiteNode(position pos, suiteNode suite_){
        super(pos);
        suite = suite_;
    }

    public suiteNode(position pos){
        super(pos);
        stmt = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
