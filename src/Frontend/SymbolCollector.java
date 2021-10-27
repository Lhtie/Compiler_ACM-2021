package Frontend;

import AST.*;
import Util.Scope;
import Util.Type;
import Util.error.semanticError;
import Util.globalScope;
import Util.position;

import java.util.ArrayList;

public class SymbolCollector implements ASTVisitor {
    private globalScope gScope;
    private Scope currentScope;
    private ArrayList<Type> parameters;
    private Type retType;

    public SymbolCollector(Scope scope){
        gScope = (globalScope) scope;
        currentScope = scope;
    }

    private void BuiltInFunc(position pos, globalScope currentScope){
        Scope funcScope = new Scope(currentScope);
        funcScope.addVar(pos, "str", new Type(Type.typeToken.STRING, 0, true));
        ArrayList<Type> funcPara = new ArrayList<>();
        funcPara.add(new Type(Type.typeToken.STRING, 0, true));
        currentScope.addFunc(pos, "print", funcScope,
                new Type(Type.typeToken.VOID, 0, false), funcPara);
        funcScope = new Scope(currentScope);
        funcScope.addVar(pos, "str", new Type(Type.typeToken.STRING, 0, true));
        funcPara = new ArrayList<>();
        funcPara.add(new Type(Type.typeToken.STRING, 0, true));
        currentScope.addFunc(pos, "println", funcScope,
                new Type(Type.typeToken.VOID, 0, false), funcPara);
        funcScope = new Scope(currentScope);
        funcScope.addVar(pos, "n", new Type(Type.typeToken.INT, 0, true));
        funcPara = new ArrayList<>();
        funcPara.add(new Type(Type.typeToken.INT, 0, true));
        currentScope.addFunc(pos, "printInt", funcScope,
                new Type(Type.typeToken.VOID, 0, false), funcPara);
        funcScope = new Scope(currentScope);
        funcScope.addVar(pos, "n", new Type(Type.typeToken.INT, 0, true));
        funcPara = new ArrayList<>();
        funcPara.add(new Type(Type.typeToken.INT, 0, true));
        currentScope.addFunc(pos, "printlnInt", funcScope,
                new Type(Type.typeToken.VOID, 0, false), funcPara);
        currentScope.addFunc(pos, "getString", new Scope(),
                new Type(Type.typeToken.STRING, 0, true), new ArrayList<>());
        currentScope.addFunc(pos, "getInt", new Scope(),
                new Type(Type.typeToken.INT, 0, true), new ArrayList<>());
        funcScope = new Scope(currentScope);
        funcScope.addVar(pos, "i", new Type(Type.typeToken.INT, 0, true));
        funcPara = new ArrayList<>();
        funcPara.add(new Type(Type.typeToken.INT, 0, true));
        currentScope.addFunc(pos, "toString", funcScope,
                new Type(Type.typeToken.STRING, 0, true), funcPara);
    }

    @Override
    public void visit(RootNode it) {
        it.define.forEach(x -> {
            if (x instanceof classDefNode){
                globalScope newScope = new globalScope(currentScope, ((classDefNode) x).name);
                ((globalScope)currentScope).addClass(it.pos, ((classDefNode) x).name, newScope);
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

        globalScope newScope = new globalScope(currentScope, "_ARRAY");
        ((globalScope)currentScope).addClass(it.pos, "_ARRAY", newScope);
        newScope.addFunc(it.pos, "size", new Scope(),
                new Type(Type.typeToken.INT, 0, true), new ArrayList<>());

        newScope = new globalScope(currentScope, "string");
        ((globalScope)currentScope).addClass(it.pos, "string", newScope);
        newScope.addFunc(it.pos, "length", new Scope(),
                new Type(Type.typeToken.INT, 0, true), new ArrayList<>());
        Scope funcScope = new Scope(newScope);
        funcScope.addVar(it.pos, "left", new Type(Type.typeToken.INT, 0, true));
        funcScope.addVar(it.pos, "right", new Type(Type.typeToken.INT, 0, true));
        ArrayList<Type> funcPara = new ArrayList<>();
        funcPara.add(new Type(Type.typeToken.INT, 0, true));
        funcPara.add(new Type(Type.typeToken.INT, 0, true));
        newScope.addFunc(it.pos, "substring", funcScope,
                new Type(Type.typeToken.STRING, 0, true), funcPara);
        newScope.addFunc(it.pos, "parseInt", new Scope(),
                new Type(Type.typeToken.INT, 0, true), new ArrayList<>());
        funcScope = new Scope(newScope);
        funcScope.addVar(it.pos, "pos", new Type(Type.typeToken.INT, 0, true));
        funcPara = new ArrayList<>();
        funcPara.add(new Type(Type.typeToken.INT, 0, true));
        newScope.addFunc(it.pos, "ord", funcScope,
                new Type(Type.typeToken.INT, 0, true), funcPara);

        BuiltInFunc(it.pos, gScope);
    }

    @Override
    public void visit(classDefNode it) {
        currentScope = ((globalScope) currentScope).getScopeFromClass(it.pos, it.name);
        gScope = (globalScope) currentScope;
        it.funcDef.forEach(x -> x.accept(this));
        it.varDef.forEach(x -> x.accept(this));
        gScope = (globalScope) gScope.getParentScope();
        currentScope = currentScope.getParentScope();
    }

    @Override
    public void visit(funcDefNode it) {
        Type type;
        if (it.funcType.isVoid)
            type = new Type(Type.typeToken.VOID, 0, false);
        else {
            it.funcType.type.accept(this);
            type = retType;
        }
        Scope newScope = new Scope(currentScope);
        currentScope = newScope;
        it.parameterList.accept(this);
        currentScope = currentScope.getParentScope();
        ((globalScope)currentScope).addFunc(it.pos, it.name, newScope, type, parameters);
    }

    @Override
    public void visit(varDefNode it) {
        it.type.accept(this);
        Type type = retType;
        it.varDefArg.forEach(x -> {
            if (gScope.findClass(x.name))
                throw new semanticError("Semantic Error: variable rename with class", x.pos);
            currentScope.addVar(x.pos, x.name, type);
            if (x.isInitialized)
                throw new semanticError("Semantic Error: cannot initialize in class", it.pos);
        });
    }

    @Override
    public void visit(varDefArgNode it) {}

    @Override
    public void visit(typeNode it) {
        if (it.classId != null) {
            if (!gScope.findClass(it.classId))
                throw new semanticError("Semantic Error: cannot find class " + it.classId, it.pos);
            retType = new Type(it.classId, it.dim, true);
        } else retType = new Type(it.basicType.basicType, it.dim, true);
    }

    @Override
    public void visit(parameterListNode it) {
        parameters = new ArrayList<>();
        it.parameter.forEach(x -> x.accept(this));
    }

    @Override
    public void visit(parameterNode it) {
        it.type.accept(this);
        currentScope.addVar(it.pos, it.name, retType);
        parameters.add(retType);
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
