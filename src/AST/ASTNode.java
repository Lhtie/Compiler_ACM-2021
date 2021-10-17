package AST;

import Util.position;

abstract public class ASTNode{
    public position pos;

    public ASTNode(position pos_) {
        pos = pos_;
    }

    abstract public void accept(ASTVisitor visitor);
}