package AST;

import Util.position;

import java.util.ArrayList;

public class argListNode extends ASTNode{
    public ArrayList<ExprNode> expr;

    public argListNode(position pos){
        super(pos);
        expr = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
