package AST;

import Util.position;

import java.util.ArrayList;

public class RootNode extends ASTNode{
    public ArrayList<DefineNode> define;

    public RootNode(position pos) {
        super(pos);
        define = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
