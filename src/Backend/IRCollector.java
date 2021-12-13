package Backend;

import AST.*;
import LLVMIR.BasicBlock;
import LLVMIR.Class;
import LLVMIR.Entity.Entity;
import LLVMIR.Entity.register;
import LLVMIR.Function;
import LLVMIR.Module;
import LLVMIR.Type.IRType;
import LLVMIR.Type.baseType;
import LLVMIR.Type.ptrType;
import LLVMIR.Type.classType;
import LLVMIR.Type.arrayType;
import Util.Scope;
import Util.Type;
import Util.globalScope;

import java.util.ArrayList;

public class IRCollector implements ASTVisitor {
    private Module topModule;
    private Class currentClass;
    private globalScope gScope;
    private Scope currentScope;
    private ArrayList<Entity> parameters;
    private IRType type;
    private int regNum;

    public IRCollector(Scope scope, Module module){
        topModule = module;
        currentClass = null;
        gScope = (globalScope) scope;
        currentScope = scope;
    }

    @Override
    public void visit(RootNode it) {
        it.define.forEach(x -> {
            if (x instanceof classDefNode) {
                Class cl = new Class("class." + ((classDefNode) x).name);
                topModule.cls.add(cl);
                ((globalScope) currentScope).addClass(((classDefNode) x).name, cl);
            }
        });

        it.define.forEach(x -> {
            if (x instanceof classDefNode)
                x.accept(this);
        });

        it.define.forEach(x -> {
            if (x instanceof funcDefNode)
                x.accept(this);
        });
    }

    @Override
    public void visit(classDefNode it) {
        currentClass = ((globalScope) currentScope).getClass(it.name);
        currentScope = ((globalScope) currentScope).getScopeFromClass(it.pos, it.name);
        gScope = (globalScope) currentScope;
        ((globalScope) currentScope).currentClass = currentClass;
        it.funcDef.forEach(x -> x.accept(this));
        it.varDef.forEach(x -> x.accept(this));
        gScope = (globalScope) gScope.getParentScope();
        currentScope = currentScope.getParentScope();
        currentClass = null;
    }

    @Override
    public void visit(funcDefNode it) {
        regNum = 0;
        currentScope = ((globalScope) currentScope).getScopeFromFunc(it.pos, it.name);
        it.parameterList.accept(this);
        BasicBlock entry = new BasicBlock(Integer.toString(regNum++));
        IRType retTp;
        if (it.funcType.isVoid)
            retTp = new baseType(baseType.typeToken.VOID);
        else {
            it.funcType.type.accept(this);
            retTp = type;
        }
        String identifier = it.name;
        if (currentClass != null)
            identifier = currentClass.identifier + "." + it.name;
        Function fn = new Function(regNum, retTp, identifier, parameters, entry);
        topModule.fns.add(fn);
        currentScope = currentScope.getParentScope();
        ((globalScope) currentScope).addFunc(it.name, fn);
    }

    @Override
    public void visit(varDefNode it) {
        it.type.accept(this);
        it.varDefArg.forEach(x -> {
            currentClass.ctx.put(x.name, currentClass.vars.size());
            currentClass.vars.add(type);
            if (type instanceof baseType) {
                int iN = ((baseType) type).i_N;
                currentClass.bytes += iN == 1 ? 1 : iN / 8;
            } else // if (type instanceof ptrType)
                currentClass.bytes += 8;
        });
    }

    @Override
    public void visit(varDefArgNode it) {}

    @Override
    public void visit(typeNode it) {
        if (it.basicType != null){
            if (it.basicType.basicType == Type.typeToken.BOOL)
                type = new baseType(baseType.typeToken.I, 1);
            else if (it.basicType.basicType == Type.typeToken.INT)
                type = new baseType(baseType.typeToken.I, 32);
            else // if (it.basicType.basicType == Type.typeToken.STRING)
                type = new ptrType(new baseType(baseType.typeToken.I, 8));
        } else type = new ptrType(new classType(gScope.getClass(it.classId)));
        for (int i = 0; i < it.dim; ++i)
            type = new ptrType(type);
    }

    @Override
    public void visit(parameterListNode it) {
        parameters = new ArrayList<>();
        if (currentClass != null)
            parameters.add(new register(false, new ptrType(new classType(currentClass)),
                    Integer.toString(regNum++)));
        it.parameter.forEach(x -> x.accept(this));
    }

    @Override
    public void visit(parameterNode it) {
        it.type.accept(this);
        Entity parameter = new register(false, type, Integer.toString(regNum++));
        parameters.add(parameter);
        currentScope.addRegister(it.name, parameter);
    }

    @Override public void visit(constructorDefNode it) {}
    @Override public void visit(basicTypeNode it) {}
    @Override public void visit(funcTypeNode it) {}
    @Override public void visit(globalVarDefNode it) {}
    @Override public void visit(suiteNode it) {}
    @Override public void visit(blockNode it) {}
    @Override public void visit(ifStmtNode it) {}
    @Override public void visit(elseStmtNode it) {}
    @Override public void visit(whileStmtNode it) {}
    @Override public void visit(forStmtNode it) {}
    @Override public void visit(forInitNode it) {}
    @Override public void visit(forStopNode it) {}
    @Override public void visit(returnStmtNode it) {}
    @Override public void visit(breakStmtNode it) {}
    @Override public void visit(continueStmtNode it) {}
    @Override public void visit(preIncDecExprNode it) {}
    @Override public void visit(funcCallExprNode it) {}
    @Override public void visit(arrayExprNode it) {}
    @Override public void visit(binaryExprNode it) {}
    @Override public void visit(postIncDecExprNode it) {}
    @Override public void visit(unaryExprNode it) {}
    @Override public void visit(bracketExprNode it) {}
    @Override public void visit(primaryNode it) {}
    @Override public void visit(argListNode it) {}
    @Override public void visit(creatorNode it) {}
    @Override public void visit(creatorSizeNode it) {}
    @Override public void visit(lambdaStmtNode it) {}
}
