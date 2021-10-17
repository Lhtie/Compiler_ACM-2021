package AST;

import Util.position;

public class globalVarDefNode extends DefineNode{
    public varDefNode varDef;

    public globalVarDefNode(position pos, varDefNode varDef_){
        super(pos);
        varDef = varDef_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
