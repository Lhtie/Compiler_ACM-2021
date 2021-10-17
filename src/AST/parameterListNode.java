package AST;

import Util.position;

import java.util.ArrayList;

public class parameterListNode extends ASTNode{
    public ArrayList<parameterNode> parameter;

    public parameterListNode(position pos){
        super(pos);
        parameter = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
