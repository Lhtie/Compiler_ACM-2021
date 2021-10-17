package AST;

import Util.position;

import java.util.ArrayList;

public class varDefNode extends StmtNode{
    public typeNode type;
    public ArrayList<varDefArgNode> varDefArg;

    public varDefNode(position pos, typeNode type_){
        super(pos);
        type = type_;
        varDefArg = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
