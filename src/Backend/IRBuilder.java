package Backend;

import AST.*;
import LLVMIR.BasicBlock;
import LLVMIR.Entity.Entity;
import LLVMIR.Entity.constant;
import LLVMIR.Entity.globalEntity;
import LLVMIR.Entity.register;
import LLVMIR.Function;
import LLVMIR.Module;
import LLVMIR.Stmt.*;
import LLVMIR.Type.*;
import Util.Scope;
import Util.Type;
import Util.globalScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IRBuilder implements ASTVisitor {
    private HashMap<String, Entity> strCollector;
    private globalScope gScope;
    private Scope currentScope;
    private Module topModule;
    private BasicBlock currentBlock;
    private int currentRegNum;
    private int currentStrNum;
    private Entity retEntity;
    private Boolean isGlobalVarDef;
    private IRType type;

    public IRBuilder(globalScope scope, Module module){
        strCollector = new HashMap<>();
        gScope = scope;
        currentScope = scope;
        topModule = module;
        currentRegNum = 0;
        currentStrNum = 0;
        isGlobalVarDef = false;
    }

    private Entity loadPtrType(Entity ptr) {
        IRType type = ((ptrType) ptr.type).type;
        register val = new register(type, Integer.toString(++currentRegNum));
        currentBlock.stmts.add(new load(val, type, ptr));
        return val;
    }

    @Override
    public void visit(RootNode it) {
        it.define.forEach(x -> x.accept(this));
        for (Map.Entry<String, Entity> entry : strCollector.entrySet()){
            topModule.gVars.add(new global(entry.getValue(), global.defineType.CONSTANT,
                    new constant(((ptrType) entry.getValue().type).type, entry.getKey())));
        }
    }

    @Override
    public void visit(classDefNode it) {

    }

    @Override
    public void visit(constructorDefNode it) {

    }

    @Override
    public void visit(globalVarDefNode it) {
        Boolean tmp = isGlobalVarDef;
        isGlobalVarDef = true;
        it.varDef.accept(this);
        isGlobalVarDef = tmp;
    }

    @Override
    public void visit(varDefNode it) {
        it.type.accept(this);
        for (int i = 0; i < it.varDefArg.size(); ++i) {
            varDefArgNode x = it.varDefArg.get(i);
            Entity init = new constant(type, 0);
            if (x.isInitialized) {
                x.expr.accept(this);
                init = retEntity;
            }
            if (isGlobalVarDef) {
                retEntity = new globalEntity(new ptrType(type), Integer.toString(++currentRegNum), false);
                topModule.gVars.add(new global(retEntity, global.defineType.GLOBAL, init));
                currentScope.addRegister(x.name, retEntity);
            } else {
                retEntity = new register(new ptrType(type), Integer.toString(++currentRegNum));
                currentBlock.stmts.add(new alloca(retEntity, type));
                currentScope.addRegister(x.name, retEntity);
            }
        }
    }

    @Override
    public void visit(typeNode it) {
        if (it.basicType != null){
            if (it.basicType.basicType == Type.typeToken.BOOL)
                type = new baseType(baseType.typeToken.I, 1);
            else if (it.basicType.basicType == Type.typeToken.INT)
                type = new baseType(baseType.typeToken.I, 32);
            else type = new ptrType(new baseType(baseType.typeToken.I, 8)); // STRING
            for (int i = 0; i < it.dim; ++i)
                type = new ptrType(type);
        } else type = new classType(it.classId);
    }

    @Override
    public void visit(basicTypeNode it) {}

    @Override
    public void visit(varDefArgNode it) {}

    @Override
    public void visit(funcDefNode it) {
        IRType retType;
        if (it.funcType.isVoid)
            retType = new baseType(baseType.typeToken.VOID);
        else {
            it.funcType.type.accept(this);
            retType = type;
        }
        ArrayList<Entity> parameters = new ArrayList<>();
        it.parameterList.parameter.forEach(x -> {
            x.type.accept(this);
            parameters.add(new register(type, x.name));
        });
        currentBlock = new BasicBlock(it.name + " entry");
        topModule.fns.add(new Function(retType, it.name, parameters, currentBlock));

        currentScope = gScope.getScopeFromFunc(it.pos, it.name);
        it.suite.accept(this);
        currentScope = currentScope.getParentScope();
    }

    @Override
    public void visit(funcTypeNode it) {}

    @Override
    public void visit(parameterListNode it) {}

    @Override
    public void visit(parameterNode it) {}

    @Override
    public void visit(suiteNode it) {
        it.block.forEach(x -> x.accept(this));
    }

    @Override
    public void visit(blockNode it) {
        if (it.suite != null){
            currentScope = new Scope(currentScope);
            it.suite.accept(this);
            currentScope = currentScope.getParentScope();
        } else if (it.stmt != null)
            it.stmt.accept(this);
    }

    @Override
    public void visit(ifStmtNode it) {

    }

    @Override
    public void visit(elseStmtNode it) {

    }

    @Override
    public void visit(whileStmtNode it) {

    }

    @Override
    public void visit(forStmtNode it) {

    }

    @Override
    public void visit(forInitNode it) {

    }

    @Override
    public void visit(forStopNode it) {

    }

    @Override
    public void visit(returnStmtNode it) {

    }

    @Override
    public void visit(breakStmtNode it) {

    }

    @Override
    public void visit(continueStmtNode it) {

    }

    @Override
    public void visit(preIncDecExprNode it) {
        it.expr.accept(this);
        Entity val = loadPtrType(retEntity);
        register res = new register(type, Integer.toString(++currentRegNum));
        currentBlock.stmts.add(new binaryOp(res, binaryOp.binaryOpType.ADD,
                val, new constant(type, 1)));
        currentBlock.stmts.add(new store(res, retEntity));
    }

    @Override
    public void visit(postIncDecExprNode it) {
        it.expr.accept(this);
        Entity val = loadPtrType(retEntity);
        register res = new register(type, Integer.toString(++currentRegNum));
        currentBlock.stmts.add(new binaryOp(res, binaryOp.binaryOpType.ADD,
                val, new constant(type, 1)));
        currentBlock.stmts.add(new store(res, retEntity));
        retEntity = val;
    }

    @Override
    public void visit(funcCallExprNode it) {

    }

    @Override
    public void visit(arrayExprNode it) {
        
    }

    @Override
    public void visit(unaryExprNode it) {
        it.expr.accept(this);
        if (retEntity.type instanceof ptrType)
            retEntity = loadPtrType(retEntity);
        if (it.unaryOp == unaryExprNode.unaryOpType.MINUS) {
            Entity res = new register(retEntity.type, Integer.toString(++currentRegNum));
            currentBlock.stmts.add(new binaryOp(res, binaryOp.binaryOpType.SUB,
                    new constant(retEntity.type, 0), retEntity));
            retEntity = res;
        }
        else if (it.unaryOp == unaryExprNode.unaryOpType.NOT_OP
            || it.unaryOp == unaryExprNode.unaryOpType.NOT_LOG){
            Entity res = new register(retEntity.type, Integer.toString(++currentRegNum));
            currentBlock.stmts.add(new binaryOp(res, binaryOp.binaryOpType.XOR,
                    retEntity, new constant(retEntity.type, -1)));
            retEntity = res;
        }
    }

    @Override
    public void visit(binaryExprNode it) {

    }

    @Override
    public void visit(bracketExprNode it) {
        it.expr.accept(this);
    }

    @Override
    public void visit(primaryNode it) {
        if (it.primaryType == primaryNode.primaryTypeToken.NULL)
            retEntity = new constant(new ptrType(null), 0);
        else if (it.primaryType == primaryNode.primaryTypeToken.INT)
            retEntity = new constant(new baseType(baseType.typeToken.I, 32), Integer.parseInt(it.primaryCtx));
        else if (it.primaryType == primaryNode.primaryTypeToken.BOOL)
            retEntity = new constant(new baseType(baseType.typeToken.I, 1),
                    it.primaryCtx.equals("true") ? 1 : 0);
        else if (it.primaryType == primaryNode.primaryTypeToken.STRING){
            IRType i8 = new baseType(baseType.typeToken.I, 8);
            IRType arrType = new arrayType(it.primaryCtx.length() + 1, i8);
            Entity strPtr;
            if (!strCollector.containsKey(it.primaryCtx)){
                strPtr = new globalEntity(new ptrType(arrType), ".str." + (currentStrNum++), true);
                strCollector.put(it.primaryCtx, strPtr);
            }
            else strPtr = strCollector.get(it.primaryCtx);
            retEntity = new register(new ptrType(i8), Integer.toString(++currentRegNum));
            getelementptr instr = new getelementptr(retEntity, arrType, strPtr);
            instr.addOffset(new constant(new baseType(baseType.typeToken.I, 64), 0));
            currentBlock.stmts.add(instr);
        }
        else {  // identifier
            retEntity = currentScope.getRegister(it.primaryCtx, true);
            // TODO: add function call identifier
        }
    }

    @Override
    public void visit(argListNode it) {

    }

    @Override
    public void visit(creatorNode it) {

    }

    @Override
    public void visit(creatorSizeNode it) {

    }

    @Override
    public void visit(lambdaStmtNode it) {}
}
