package AST;

import Util.position;

public class constructorDefNode extends ASTNode{
    public String name;
    public suiteNode suite;

    public constructorDefNode(position pos, String name_, suiteNode suite_){
        super(pos);
        name = name_;
        suite = suite_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
