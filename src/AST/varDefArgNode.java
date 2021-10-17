package AST;

import Util.position;

public class varDefArgNode extends ASTNode{
    public String name;
    public ExprNode expr;
    public Boolean isInitialized;

    public varDefArgNode(position pos, String name_){
        super(pos);
        name = name_;
        isInitialized = false;
    }

    public varDefArgNode(position pos, String name_, ExprNode expr_){
        super(pos);
        name = name_;
        expr = expr_;
        isInitialized = true;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
