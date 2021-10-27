package AST;

import Util.position;

import java.util.ArrayList;

public class suiteNode extends ASTNode{
    public ArrayList<blockNode> block;

    public suiteNode(position pos){
        super(pos);
        block = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
