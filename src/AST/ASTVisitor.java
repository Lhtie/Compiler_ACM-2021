package AST;

public interface ASTVisitor {
    void visit(RootNode it);

    void visit(classDefNode it);
    void visit(constructorDefNode it);
    void visit(varDefNode it);
    void visit(varDefArgNode it);
    void visit(funcDefNode it);
    void visit(basicTypeNode it);
    void visit(typeNode it);
    void visit(funcTypeNode it);
    void visit(parameterListNode it);
    void visit(parameterNode it);
    void visit(globalVarDefNode it);

    void visit(suiteNode it);
    void visit(blockNode it);

    void visit(ifStmtNode it);
    void visit(elseStmtNode it);
    void visit(whileStmtNode it);
    void visit(forStmtNode it);
    void visit(forInitNode it);
    void visit(forStopNode it);
    void visit(returnStmtNode it);
    void visit(breakStmtNode it);
    void visit(continueStmtNode it);

    void visit(preIncDecExprNode it);
    void visit(funcCallExprNode it);
    void visit(arrayExprNode it);
    void visit(binaryExprNode it);
    void visit(postIncDecExprNode it);
    void visit(unaryExprNode it);
    void visit(bracketExprNode it);
    void visit(primaryNode it);
    void visit(argListNode it);
    void visit(creatorNode it);
    void visit(creatorSizeNode it);
    void visit(lambdaStmtNode it);
}
