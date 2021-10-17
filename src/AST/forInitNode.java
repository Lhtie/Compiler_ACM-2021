package AST;

import Util.position;

public class forInitNode extends ASTNode{
    public varDefNode varDef;
    public ExprNode expr;

    public forInitNode(position pos, varDefNode varDef_, ExprNode expr_){
        super(pos);
        varDef = varDef_;
        expr = expr_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
