package AST;

import Util.position;

import java.util.ArrayList;

public class classDefNode extends DefineNode{
    public String name;
    public constructorDefNode constructorDef;
    public ArrayList<funcDefNode> funcDef;
    public ArrayList<varDefNode> varDef;

    public classDefNode(position pos, String name_){
        super(pos);
        name = name_;
        funcDef = new ArrayList<>();
        varDef = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
