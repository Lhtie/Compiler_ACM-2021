package AST;

import Util.position;

public class funcDefNode extends DefineNode{
    public funcTypeNode funcType;
    public String name;
    public parameterListNode parameterList;
    public suiteNode suite;

    public funcDefNode(position pos, funcTypeNode funcType_, String name_,
                       parameterListNode parameterList_, suiteNode suite_){
        super(pos);
        funcType = funcType_;
        name = name_;
        parameterList = parameterList_;
        suite = suite_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
