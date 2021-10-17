package AST;

import Util.position;

public class primaryNode extends ExprNode{
    public enum primaryTypeToken{
        THIS, NULL, INT, BOOL, STRING, IDENTIFIER
    }

    public primaryTypeToken primaryType;
    public String primaryCtx;

    public primaryNode(position pos, primaryTypeToken primaryType_, String primaryCtx_){
        super(pos);
        primaryType = primaryType_;
        primaryCtx = primaryCtx_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
