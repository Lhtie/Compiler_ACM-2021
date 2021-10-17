package AST;

import Util.position;

import java.beans.Expression;

public class lambdaStmtNode extends ExprNode {
    public parameterListNode parameterList;
    public suiteNode suite;
    public argListNode argList;

    public lambdaStmtNode(position pos, parameterListNode parameterList_,
                          suiteNode suite_, argListNode argList_){
        super(pos);
        parameterList = parameterList_;
        suite = suite_;
        argList = argList_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
