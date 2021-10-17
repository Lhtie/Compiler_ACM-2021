package AST;

import Util.position;

import java.util.ArrayList;

public class creatorNode extends ExprNode{
    public String classId;
    public basicTypeNode basicType;
    public ArrayList<creatorSizeNode> creatorSize;

    public creatorNode(position pos, String classId_, basicTypeNode basicType_){
        super(pos);
        classId = classId_;
        basicType = basicType_;
        creatorSize = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
