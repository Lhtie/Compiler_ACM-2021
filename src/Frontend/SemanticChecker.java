package Frontend;

import AST.*;
import Util.FlowController;
import Util.Scope;
import Util.Type;
import Util.error.semanticError;
import Util.globalScope;

import java.util.ArrayList;
import java.util.Objects;

public class SemanticChecker implements ASTVisitor {
    private globalScope gScope;
    private Scope currentScope;
    private Type retType;
    private FlowController flowController;

    public SemanticChecker(globalScope scope){
        gScope = scope;
        currentScope = scope;
    }

    private static boolean isCmpOp(binaryExprNode.binaryOpType Op){
        return Op == binaryExprNode.binaryOpType.LESS_THAN
                || Op == binaryExprNode.binaryOpType.GREATER_THAN
                || Op == binaryExprNode.binaryOpType.LT_EQ
                || Op == binaryExprNode.binaryOpType.GT_EQ
                || Op == binaryExprNode.binaryOpType.EQUALS
                || Op == binaryExprNode.binaryOpType.NOT_EQ
                ;
    }

    private static boolean isArithOp(binaryExprNode.binaryOpType Op){
        return Op == binaryExprNode.binaryOpType.STAR
                || Op == binaryExprNode.binaryOpType.DIV
                || Op == binaryExprNode.binaryOpType.MOD
                || Op == binaryExprNode.binaryOpType.PLUS
                || Op == binaryExprNode.binaryOpType.MINUS
                || Op == binaryExprNode.binaryOpType.LEFT_SHIFT
                || Op == binaryExprNode.binaryOpType.RIGHT_SHIFT
                || Op == binaryExprNode.binaryOpType.AND_OP
                || Op == binaryExprNode.binaryOpType.XOR_OP
                || Op == binaryExprNode.binaryOpType.OR_OP
                ;
    }

    private static boolean isLogicOp(binaryExprNode.binaryOpType Op){
        return Op == binaryExprNode.binaryOpType.OR_LOG
                || Op == binaryExprNode.binaryOpType.AND_LOG
                ;
    }

    @Override
    public void visit(RootNode it) {
        it.define.forEach(x -> x.accept(this));
        if (!gScope.findFunc("main", false))
            throw new semanticError("Semantic Error: no main function defined", it.pos);
        retType = gScope.getRetTypeFromFunc(it.pos, "main");
        if (retType.typeName != Type.typeToken.INT || retType.dim > 0)
            throw new semanticError("Semantic Error: main function need to return int", it.pos);
    }

    @Override
    public void visit(classDefNode it) {
        currentScope = ((globalScope)currentScope).getScopeFromClass(it.pos, it.name);
        gScope = (globalScope) currentScope;
        if (it.constructorDef != null) {
            if (!Objects.equals(it.constructorDef.name, it.name))
                throw new semanticError("Semantic Error: invalid constructor definition", it.pos);
            it.constructorDef.accept(this);
        }
        it.funcDef.forEach(x -> {
            if (Objects.equals(x.name, it.name))
                throw new semanticError("Semantic Error: invalid function name", x.pos);
            x.accept(this);
        });
        gScope = (globalScope) gScope.getParentScope();
        currentScope = currentScope.getParentScope();
    }

    @Override public void visit(constructorDefNode it) {
        currentScope = new Scope(currentScope);
        gScope.addFunc(it.pos, it.name, currentScope,
                new Type(Type.typeToken.VOID, 0, false), new ArrayList<>());
        flowController = new FlowController(it.name);
        it.suite.accept(this);
        currentScope = currentScope.getParentScope();
    }

    @Override
    public void visit(varDefNode it) {
        it.type.accept(this);
        Type type = retType;
        it.varDefArg.forEach(x -> {
            if (gScope.findClass(x.name))
                throw new semanticError("Semantic Error: variable rename with class", x.pos);
            if (gScope.findFunc(x.name, false))
                throw new semanticError("Semantic Error: variable rename with function", x.pos);
            currentScope.addVar(x.pos, x.name, type);
            if (x.isInitialized){
                x.expr.accept(this);
                type.assignChecker(x.pos, gScope, retType);
            }
        });
    }

    @Override
    public void visit(varDefArgNode it) {}

    @Override
    public void visit(funcDefNode it) {
        currentScope = gScope.getScopeFromFunc(it.pos, it.name);
        flowController = new FlowController(it.name);
        it.suite.accept(this);
        if (!Objects.equals(flowController.funcName, "main")) {
            retType = gScope.getRetTypeFromFunc(it.pos, it.name);
            if (retType.typeName != Type.typeToken.VOID && !flowController.returned)
                throw new semanticError("Semantic Error: function " + it.name + " has not returned", it.pos);
        }
        currentScope = currentScope.getParentScope();
    }

    @Override
    public void visit(basicTypeNode it) {}

    @Override
    public void visit(typeNode it) {
        if (it.classId != null) {
            if (!gScope.findClass(it.classId))
                throw new semanticError("Semantic Error: cannot find class " + it.classId, it.pos);
            retType = new Type(it.classId, it.dim, true);
        } else retType = new Type(it.basicType.basicType, it.dim, true);
    }

    @Override
    public void visit(funcTypeNode it) {}

    @Override
    public void visit(parameterListNode it) {}

    @Override
    public void visit(parameterNode it) {}

    @Override
    public void visit(globalVarDefNode it) {
        it.varDef.accept(this);
    }

    @Override
    public void visit(suiteNode it) {
        it.block.forEach(x -> x.accept(this));
    }

    @Override
    public void visit(blockNode it){
        if (it.suite != null) {
            currentScope = new Scope(currentScope);
            it.suite.accept(this);
            currentScope = currentScope.getParentScope();
        } else if (it.stmt != null)
            it.stmt.accept(this);
    }

    @Override
    public void visit(ifStmtNode it) {
        it.expr.accept(this);
        if (retType.typeName != Type.typeToken.BOOL || retType.dim > 0)
            throw new semanticError("Semantic Error: if-condition need to be boolean", it.pos);
        boolean returned = true;
        flowController.returned = false;
        currentScope = new Scope(currentScope);
        it.block.accept(this);
        currentScope = currentScope.getParentScope();
        returned &= flowController.returned;
        if (it.elseStmt != null){
            flowController.returned = false;
            it.elseStmt.accept(this);
            returned &= flowController.returned;
        }
        flowController.returned = returned;
    }

    @Override
    public void visit(elseStmtNode it) {
        currentScope = new Scope(currentScope);
        it.block.accept(this);
        currentScope = currentScope.getParentScope();
    }

    @Override
    public void visit(whileStmtNode it) {
        it.expr.accept(this);
        if (retType.typeName != Type.typeToken.BOOL || retType.dim > 0)
            throw new semanticError("Semantic Error: while-condition need to be boolean", it.pos);
        flowController.loopIn();
        currentScope = new Scope(currentScope);
        it.block.accept(this);
        currentScope = currentScope.getParentScope();
        flowController.loopOut();
    }

    @Override
    public void visit(forStmtNode it) {
        flowController.loopIn();
        currentScope = new Scope(currentScope);
        if (it.forInit != null)
            it.forInit.accept(this);
        if (it.forStop != null)
            it.forStop.accept(this);
        if (it.expr != null)
            it.expr.accept(this);
        it.block.accept(this);
        currentScope = currentScope.getParentScope();
        flowController.loopOut();
    }

    @Override
    public void visit(forInitNode it) {
        if (it.varDef != null)
            it.varDef.accept(this);
        if (it.expr != null)
            it.expr.accept(this);
    }

    @Override
    public void visit(forStopNode it) {
        it.expr.accept(this);
        if (retType.typeName != Type.typeToken.BOOL || retType.dim > 0)
            throw new semanticError("Semantic Error: for-condition need to be boolean", it.pos);
    }

    @Override
    public void visit(returnStmtNode it) {
        if (it.expr != null)
            it.expr.accept(this);
        else retType = new Type(Type.typeToken.VOID, 0, false);
        flowController.returnFunc(it.pos, gScope, retType);
    }

    @Override
    public void visit(breakStmtNode it) {
        flowController.breakLoop(it.pos);
    }

    @Override
    public void visit(continueStmtNode it) {
        flowController.continueLoop(it.pos);
    }

    @Override
    public void visit(funcCallExprNode it) {
        it.expr.accept(this);
        if (retType.typeName != Type.typeToken.FUNC)
            throw new semanticError("Semantic Error: cannot call as a function", it.pos);
        ArrayList<Type> funcParameters = retType.funcParameters;
        Type funcRetType = retType.funcRetType;
        if (it.argList.expr.size() != funcParameters.size())
            throw new semanticError("Semantic Error: size of parameters cannot match", it.pos);
        for (int i = 0; i < it.argList.expr.size(); ++i) {
            it.argList.expr.get(i).accept(this);
            Type funcParaType = funcParameters.get(i);
            funcParaType.assignChecker(it.argList.pos, gScope, retType);
        }
        retType = new Type(funcRetType);
        retType.islValue = false;
    }

    @Override
    public void visit(arrayExprNode it) {
        it.index.accept(this);
        if (retType.typeName != Type.typeToken.INT || retType.dim > 0)
            throw new semanticError("Semantic Error: index need to be int", it.pos);
        it.title.accept(this);
        retType.dim--;
        if (retType.dim < 0)
            throw new semanticError("Semantic Error: dimension not matched", it.pos);
    }

    @Override
    public void visit(binaryExprNode it) {
        if (it.binaryOp == binaryExprNode.binaryOpType.DOT){
            it.lhs.accept(this);
            if (!retType.referable())
                throw new semanticError("Semantic Error: there is no inner content", it.pos);
            globalScope gScope_ = gScope;
            Scope currentScope_ = currentScope;
            if (retType.dim > 0)
                gScope = (globalScope) gScope.getScopeFromClass(it.pos, "_ARRAY");
            else if (retType.typeName == Type.typeToken.STRING)
                gScope = (globalScope) gScope.getScopeFromClass(it.pos, "string");
            else if (retType.typeName == Type.typeToken.CLASS)
                gScope = (globalScope) gScope.getScopeFromClass(it.pos, retType.identifier);
            currentScope = gScope;
            it.rhs.accept(this);
            currentScope = currentScope_;
            gScope = gScope_;
        } else {
            it.lhs.accept(this);
            Type lhsType = retType;
            it.rhs.accept(this);
            Type rhsType = retType;
            if (it.binaryOp == binaryExprNode.binaryOpType.ASSIGN) {
                lhsType.assignChecker(it.rhs.pos, gScope, rhsType);
                retType.islValue = false;
            } else {
                if (lhsType.dim > 0 || lhsType.typeName == Type.typeToken.CLASS){
                    if (it.binaryOp != binaryExprNode.binaryOpType.NOT_EQ && it.binaryOp != binaryExprNode.binaryOpType.EQUALS)
                        throw new semanticError("Semantic Error: can only compare with == or !=", it.pos);
                    if (rhsType.typeName != Type.typeToken.NULL)
                        lhsType.typeMatcher(it.pos, rhsType);
                    retType = new Type(Type.typeToken.BOOL, 0, false);
                } else if (rhsType.dim > 0 || rhsType.typeName == Type.typeToken.CLASS){
                    if (it.binaryOp != binaryExprNode.binaryOpType.NOT_EQ && it.binaryOp != binaryExprNode.binaryOpType.EQUALS)
                        throw new semanticError("Semantic Error: can only compare with == or !=", it.pos);
                    if (lhsType.typeName != Type.typeToken.NULL)
                        rhsType.typeMatcher(it.pos, lhsType);
                    retType = new Type(Type.typeToken.BOOL, 0, false);
                } else {
                    if (lhsType.typeName == Type.typeToken.INT) {
                        lhsType.typeMatcher(it.pos, rhsType);
                        if (isCmpOp(it.binaryOp))
                            retType = new Type(Type.typeToken.BOOL, 0, false);
                        else if (isArithOp(it.binaryOp))
                            retType = new Type(Type.typeToken.INT, 0, false);
                        else throw new semanticError("Semantic Error: int can only compare and calc", it.pos);
                    } else if (lhsType.typeName == Type.typeToken.BOOL) {
                        lhsType.typeMatcher(it.pos, rhsType);
                        if (it.binaryOp == binaryExprNode.binaryOpType.NOT_EQ || it.binaryOp == binaryExprNode.binaryOpType.EQUALS
                                || isLogicOp(it.binaryOp))
                            retType = new Type(Type.typeToken.BOOL, 0, false);
                        else throw new semanticError("Semantic Error: boolean can only compare with == or != and logic calc", it.pos);
                    } else if (lhsType.typeName == Type.typeToken.STRING){
                        lhsType.typeMatcher(it.pos, rhsType);
                        if (it.binaryOp == binaryExprNode.binaryOpType.PLUS)
                            retType = new Type(Type.typeToken.STRING, 0, false);
                        else if(isCmpOp(it.binaryOp))
                            retType = new Type(Type.typeToken.BOOL, 0, false);
                        else throw new semanticError("Semantic Error: string can only plus or compare", it.pos);
                    } else throw new semanticError("Semantic Error: invalid binary expression", it.pos);
                }
            }
        }
    }

    @Override
    public void visit(preIncDecExprNode it) {
        it.expr.accept(this);
        if (retType.typeName != Type.typeToken.INT || retType.dim > 0)
            throw new semanticError("Semantic Error: ++ or -- need to be operated on int", it.pos);
    }

    @Override
    public void visit(postIncDecExprNode it) {
        it.expr.accept(this);
        if (retType.typeName != Type.typeToken.INT || retType.dim > 0)
            throw new semanticError("Semantic Error: ++ or -- need to be operated on int", it.pos);
        retType.islValue = false;
    }

    @Override
    public void visit(unaryExprNode it) {
        it.expr.accept(this);
        if (it.unaryOp == unaryExprNode.unaryOpType.NOT_LOG){
            if (retType.typeName != Type.typeToken.BOOL || retType.dim > 0)
                throw new semanticError("Semantic Error: ! need to be operated on boolean", it.pos);
        } else {
            if (retType.typeName != Type.typeToken.INT || retType.dim > 0)
                throw new semanticError("Semantic Error: +, -, ~ need to be operated on int", it.pos);
        }
        retType.islValue = false;
    }

    @Override
    public void visit(bracketExprNode it) {
        it.expr.accept(this);
    }

    @Override
    public void visit(primaryNode it) {
        if (it.primaryType == primaryNode.primaryTypeToken.THIS)
            retType = new Type(Type.typeToken.THIS, 0, false);
        else if (it.primaryType == primaryNode.primaryTypeToken.NULL)
            retType = new Type(Type.typeToken.NULL, 0, false);
        else if (it.primaryType == primaryNode.primaryTypeToken.INT)
            retType = new Type(Type.typeToken.INT, 0, false);
        else if (it.primaryType == primaryNode.primaryTypeToken.BOOL)
            retType = new Type(Type.typeToken.BOOL, 0, false);
        else if (it.primaryType == primaryNode.primaryTypeToken.STRING)
            retType = new Type(Type.typeToken.STRING, 0, false);
        else{
            Scope ret = currentScope.containsKey(it.primaryCtx, true);
            if (ret == null)
                throw new semanticError("Semantic Error: cannot find identifier " + it.primaryCtx, it.pos);
            else if (ret instanceof globalScope && ((globalScope) ret).findFunc(it.primaryCtx, false)) {
                Type type = ((globalScope) ret).getRetTypeFromFunc(it.pos, it.primaryCtx);
                ArrayList<Type> para = ((globalScope) ret).getParametersFromFunc(it.pos, it.primaryCtx);
                retType = new Type(it.primaryCtx, type, para);
            } else retType = new Type(ret.getType(it.pos, it.primaryCtx, false));
        }
    }

    @Override
    public void visit(argListNode it) {}

    @Override
    public void visit(creatorNode it) {
        Type type;
        if (it.classId != null)
            type = new Type(it.classId, it.creatorSize.size(), false);
        else type = new Type(it.basicType.basicType, it.creatorSize.size(), false);
        boolean hasExpr = true;
        for (int i = 0; i < it.creatorSize.size(); ++i){
            creatorSizeNode x = it.creatorSize.get(i);
            if (x.expr == null) hasExpr = false;
            else {
                if (!hasExpr)
                    throw new semanticError("Semantic Error: invalid array create", x.pos);
                x.expr.accept(this);
                if (retType.typeName != Type.typeToken.INT || retType.dim > 0)
                    throw new semanticError("Semantic Error: index need to be int", it.pos);
            }
        }
        retType = type;
    }

    @Override
    public void visit(creatorSizeNode it) {}

    @Override
    public void visit(lambdaStmtNode it) {
        currentScope = new Scope(currentScope);
        ArrayList<Type> funcParameters = new ArrayList<>();
        if (it.parameterList != null){
            it.parameterList.parameter.forEach(x -> {
                x.type.accept(this);
                currentScope.addVar(x.pos, x.name, retType);
                funcParameters.add(retType);
            });
        }
        FlowController backup = flowController;
        flowController = new FlowController("Lambda");
        it.suite.accept(this);
        if (!flowController.returned)
            throw new semanticError("Semantic Error: lambda function not returned", it.pos);
        Type ret = new Type(flowController.retType);
        flowController = backup;
        currentScope = currentScope.getParentScope();
        if (it.argList.expr.size() != funcParameters.size())
            throw new semanticError("Semantic Error: size of lambda parameters cannot match", it.pos);
        for (int i = 0; i < it.argList.expr.size(); ++i){
            it.argList.expr.get(i).accept(this);
            Type funcParaType = funcParameters.get(i);
            funcParaType.assignChecker(it.argList.pos, gScope, retType);
        }
        retType = ret;
        retType.islValue = false;
    }

}
