package AST;

import Util.position;

abstract public class ExprNode extends StmtNode {
    public ExprNode(position pos){
        super(pos);
    }
}
