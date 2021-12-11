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
    private ArrayList<BasicBlock> loopFlowCollector;
    private globalScope gScope;
    private Scope currentScope;
    private Module topModule;
    private Function currentFn;
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
        currentStrNum = 0;
        isGlobalVarDef = false;
    }

    private Entity loadPtrType(Entity ptr) {
        register val = new register(false, ((ptrType) ptr.type).type, Integer.toString(++currentRegNum));
        currentBlock.stmts.add(new load(val, ptr));
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
            if (isGlobalVarDef) {
                Entity init = new constant(type);
                if (x.isInitialized) {
                    x.expr.accept(this);
                    init = retEntity;
                }
                retEntity = new globalEntity(new ptrType(type), x.name, false);
                topModule.gVars.add(new global(retEntity, global.defineType.GLOBAL, init));
                currentScope.addRegister(x.name, retEntity);
            } else {
                Entity res = new register(true, new ptrType(type), Integer.toString(++currentRegNum));
                currentBlock.stmts.add(new alloca(res, type));
                currentScope.addRegister(x.name, res);
                if (x.isInitialized) {
                    x.expr.accept(this);
                    if (retEntity.islValue)
                        retEntity = loadPtrType(retEntity);
                    currentBlock.stmts.add(new store(retEntity, res));
                }
                retEntity = res;
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
            parameters.add(new register(false, type, x.name));
        });
        currentBlock = new BasicBlock(Integer.toString(currentRegNum = 0));
        topModule.fns.add(currentFn = new Function(retType, it.name, parameters, currentBlock));

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
        } else if (it.stmt != null) {
            if (!currentBlock.branched)
                it.stmt.accept(this);
        }
    }

    @Override
    public void visit(ifStmtNode it) {
        it.expr.accept(this);
        if (retEntity.islValue)
            retEntity = loadPtrType(retEntity);
        if (retEntity instanceof constant){
            if (((constant) retEntity).i1){
                currentScope = new Scope(currentScope);
                it.block.accept(this);
                currentScope = currentScope.getParentScope();
            } else {
                it.elseStmt.accept(this);
            }
        } else {
            Entity cmpRes = retEntity;
            BasicBlock ob = currentBlock;
            currentFn.blocks.add(currentBlock = new BasicBlock(Integer.toString(++currentRegNum)));
            BasicBlock eb1 = currentBlock;
            currentScope = new Scope(currentScope);
            it.block.accept(this);
            currentScope = currentScope.getParentScope();
            BasicBlock b1 = currentBlock;
            if (it.elseStmt == null){
                currentFn.blocks.add(currentBlock = new BasicBlock(Integer.toString(++currentRegNum)));
                ob.stmts.add(new br(cmpRes, eb1.label, currentBlock.label));
                if (!b1.branched)
                    b1.stmts.add(new br(currentBlock.label));
                else loopFlowCollector.add(b1);
            } else {
                currentFn.blocks.add(currentBlock = new BasicBlock(Integer.toString(++currentRegNum)));
                BasicBlock eb2 = currentBlock;
                it.elseStmt.accept(this);
                BasicBlock b2 = currentBlock;
                currentFn.blocks.add(currentBlock = new BasicBlock(Integer.toString(++currentRegNum)));
                ob.stmts.add(new br(cmpRes, eb1.label, eb2.label));
                if (!b1.branched)
                    b1.stmts.add(new br(currentBlock.label));
                else loopFlowCollector.add(b1);
                if (!b2.branched)
                    b2.stmts.add(new br(currentBlock.label));
                else loopFlowCollector.add(b2);
            }
        }
    }

    @Override
    public void visit(elseStmtNode it) {
        currentScope = new Scope(currentScope);
        it.block.accept(this);
        currentScope = currentScope.getParentScope();
    }

    @Override
    public void visit(whileStmtNode it) {
        ArrayList<BasicBlock> LFC_backup = loopFlowCollector;
        loopFlowCollector = new ArrayList<>();
        BasicBlock ob = currentBlock;
        currentFn.blocks.add(currentBlock = new BasicBlock(Integer.toString(++currentRegNum)));
        BasicBlock cbEntry = currentBlock;
        ob.stmts.add(new br(cbEntry.label));
        it.expr.accept(this);
        if (retEntity.islValue)
            retEntity = loadPtrType(retEntity);
        Entity cond = retEntity;
        BasicBlock cbExit = currentBlock;
        currentFn.blocks.add(currentBlock = new BasicBlock(Integer.toString(++currentRegNum)));
        BasicBlock bbEntry = currentBlock;
        currentScope = new Scope(currentScope);
        it.block.accept(this);
        currentScope = currentScope.getParentScope();
        BasicBlock bbExit = currentBlock;
        currentFn.blocks.add(currentBlock = new BasicBlock(Integer.toString(++currentRegNum)));
        cbExit.stmts.add(new br(cond, bbEntry.label, currentBlock.label));
        if (!bbExit.branched)
            bbExit.stmts.add(new br(cbEntry.label));
        else loopFlowCollector.add(bbExit);
        loopFlowCollector.forEach(x -> {
            if (x.flowStatus == BasicBlock.flowStatusType.BREAK)
                 x.stmts.add(new br(currentBlock.label));
            else if (x.flowStatus == BasicBlock.flowStatusType.CONTINUE)
                x.stmts.add(new br(cbEntry.label));
        });
        loopFlowCollector = LFC_backup;
    }

    @Override
    public void visit(forStmtNode it) {
        ArrayList<BasicBlock> LFC_backup = loopFlowCollector;
        loopFlowCollector = new ArrayList<>();
        currentScope = new Scope(currentScope);
        if (it.forInit != null)
            it.forInit.accept(this);
        BasicBlock ob = currentBlock;
        currentFn.blocks.add(currentBlock = new BasicBlock(Integer.toString(++currentRegNum)));
        BasicBlock cbEntry = currentBlock;
        ob.stmts.add(new br(cbEntry.label));
        if (it.forStop != null)
            it.forStop.accept(this);
        Entity cond = retEntity;
        BasicBlock cbExit = currentBlock;
        currentFn.blocks.add(currentBlock = new BasicBlock(Integer.toString(++currentRegNum)));
        BasicBlock bbEntry = currentBlock;
        it.block.accept(this);
        BasicBlock bbExit = currentBlock;
        currentFn.blocks.add(currentBlock = new BasicBlock(Integer.toString(++currentRegNum)));
        BasicBlock ibEntry = currentBlock;
        if (it.expr != null)
            it.expr.accept(this);
        BasicBlock ibExit = currentBlock;
        ibExit.stmts.add(new br(cbEntry.label));
        currentFn.blocks.add(currentBlock = new BasicBlock(Integer.toString(++currentRegNum)));
        if (it.forStop != null)
            cbExit.stmts.add(new br(cond, bbEntry.label, currentBlock.label));
        else cbExit.stmts.add(new br(bbEntry.label));
        if (!bbExit.branched)
            bbExit.stmts.add(new br(ibEntry.label));
        else loopFlowCollector.add(bbExit);
        loopFlowCollector.forEach(x -> {
            if (x.flowStatus == BasicBlock.flowStatusType.BREAK)
                x.stmts.add(new br(currentBlock.label));
            else if (x.flowStatus == BasicBlock.flowStatusType.CONTINUE)
                x.stmts.add(new br(ibEntry.label));
        });
        currentScope = currentScope.getParentScope();
        loopFlowCollector = LFC_backup;
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
        if (retEntity.islValue)
            retEntity = loadPtrType(retEntity);
    }

    @Override
    public void visit(returnStmtNode it) {
        it.expr.accept(this);
        currentBlock.stmts.add(new ret(retEntity));
        currentBlock.branched = true;
        currentBlock.flowStatus = BasicBlock.flowStatusType.RETURN;
    }

    @Override
    public void visit(breakStmtNode it) {
        currentBlock.branched = true;
        currentBlock.flowStatus = BasicBlock.flowStatusType.BREAK;
    }

    @Override
    public void visit(continueStmtNode it) {
        currentBlock.branched = true;
        currentBlock.flowStatus = BasicBlock.flowStatusType.CONTINUE;
    }

    @Override
    public void visit(preIncDecExprNode it) {
        it.expr.accept(this);
        Entity val = loadPtrType(retEntity);
        IRType type = val.type;
        register res = new register(false, type, Integer.toString(++currentRegNum));
        currentBlock.stmts.add(new binaryOp(res, binaryOp.binaryOpType.ADD,
                val, new constant(type, it.preIncDecOp == preIncDecExprNode.preIncDecOpType.PLUSPLUS ? 1 : -1)));
        currentBlock.stmts.add(new store(res, retEntity));
    }

    @Override
    public void visit(postIncDecExprNode it) {
        it.expr.accept(this);
        Entity val = loadPtrType(retEntity);
        IRType type = val.type;
        register res = new register(false, type, Integer.toString(++currentRegNum));
        currentBlock.stmts.add(new binaryOp(res, binaryOp.binaryOpType.ADD,
                val, new constant(type, it.postIncDecOp == postIncDecExprNode.postIncDecOpType.PLUSPLUS ? 1 : -1)));
        currentBlock.stmts.add(new store(res, retEntity));
        retEntity = val;
    }

    @Override
    public void visit(funcCallExprNode it) {

    }

    @Override
    public void visit(arrayExprNode it) {
        it.title.accept(this);
        Entity arrPtr = loadPtrType(retEntity);
        it.index.accept(this);
        if (retEntity.islValue)
            retEntity = loadPtrType(retEntity);
        Entity offset = new register(false, new baseType(baseType.typeToken.I, 64),
                Integer.toString(++currentRegNum));
        currentBlock.stmts.add(new convertOp(convertOp.convertType.SEXT, offset, retEntity));
        IRType type = ((ptrType) arrPtr.type).type;
        Entity res = new register(true, arrPtr.type, Integer.toString(++currentRegNum));
        getelementptr instr = new getelementptr(res, true, type, arrPtr);
        instr.addOffset(offset);
        currentBlock.stmts.add(instr);
        retEntity = res;
    }

    @Override
    public void visit(unaryExprNode it) {
        it.expr.accept(this);
        if (retEntity.islValue)
            retEntity = loadPtrType(retEntity);
        if (it.unaryOp == unaryExprNode.unaryOpType.MINUS) {
            if (retEntity instanceof constant){
                retEntity = ((constant) retEntity).neg();
            } else {
                Entity res = new register(false, retEntity.type, Integer.toString(++currentRegNum));
                currentBlock.stmts.add(new binaryOp(res, binaryOp.binaryOpType.SUB,
                        new constant(retEntity.type, 0), retEntity));
                retEntity = res;
            }
        } else if (it.unaryOp == unaryExprNode.unaryOpType.NOT_OP
            || it.unaryOp == unaryExprNode.unaryOpType.NOT_LOG){
            if (retEntity instanceof constant){
                retEntity = ((constant) retEntity).not();
            } else {
                Entity res = new register(false, retEntity.type, Integer.toString(++currentRegNum));
                Entity oprand;
                if (it.unaryOp == unaryExprNode.unaryOpType.NOT_OP)
                    oprand = new constant(retEntity.type, -1);
                else oprand = new constant(retEntity.type, true);
                currentBlock.stmts.add(new binaryOp(res, binaryOp.binaryOpType.XOR, retEntity, oprand));
                retEntity = res;
            }
        }
    }

    @Override
    public void visit(binaryExprNode it) {
        if (it.binaryOp == binaryExprNode.binaryOpType.DOT){
            // TODO: class element
        } else if (it.binaryOp == binaryExprNode.binaryOpType.ASSIGN){
            it.rhs.accept(this);
            if (retEntity.islValue)
                retEntity = loadPtrType(retEntity);
            Entity res = retEntity;
            it.lhs.accept(this);
            currentBlock.stmts.add(new store(res, retEntity));
        } else if (it.isCmpOp() || it.isArithOp()){
            it.lhs.accept(this);
            Entity l = retEntity;
            it.rhs.accept(this);
            Entity r = retEntity;
            if (l.islValue) l = loadPtrType(l);
            if (r.islValue) r = loadPtrType(r);
            if (l instanceof constant && r instanceof constant){
                retEntity = ((constant) l).binaryOp(it, r);
            } else {
                IRType type = it.isCmpOp() ? new baseType(baseType.typeToken.I, 1) : l.type;
                retEntity = new register(false, type, Integer.toString(++currentRegNum));
                if (it.isCmpOp())
                    currentBlock.stmts.add(new icmp(retEntity, it.binaryOp, l, r));
                else currentBlock.stmts.add(new binaryOp(retEntity, it.binaryOp, l, r));
            }
        } else { // isLogicOp
            it.lhs.accept(this);
            if (retEntity.islValue)
                retEntity = loadPtrType(retEntity);
            boolean determined = false;
            if (retEntity instanceof constant){
                if (it.binaryOp == binaryExprNode.binaryOpType.OR_LOG && ((constant) retEntity).i1){
                    retEntity = new constant(new baseType(baseType.typeToken.I, 1), true);
                    determined = true;
                } else if (it.binaryOp == binaryExprNode.binaryOpType.AND_LOG && !((constant) retEntity).i1){
                    retEntity = new constant(new baseType(baseType.typeToken.I, 1), false);
                    determined = true;
                }
            }
            if (!determined) {
                Entity le = retEntity;
                BasicBlock lb = currentBlock;
                currentFn.blocks.add(currentBlock = new BasicBlock(Integer.toString(++currentRegNum)));
                BasicBlock eb = currentBlock;
                it.rhs.accept(this);
                if (retEntity.islValue)
                    retEntity = loadPtrType(retEntity);
                Entity re = retEntity;
                BasicBlock rb = currentBlock;
                currentFn.blocks.add(currentBlock = new BasicBlock(Integer.toString(++currentRegNum)));
                retEntity = new register(false, new baseType(baseType.typeToken.I, 1),
                        Integer.toString(++currentRegNum));
                if (it.binaryOp == binaryExprNode.binaryOpType.OR_LOG) {
                    lb.stmts.add(new br(le, currentBlock.label, eb.label));
                    rb.stmts.add(new br(currentBlock.label));
                    phi instr = new phi(retEntity);
                    instr.add(new constant(retEntity.type, true), lb.label);
                    instr.add(re, rb.label);
                    currentBlock.stmts.add(instr);
                } else {
                    lb.stmts.add(new br(le, eb.label, currentBlock.label));
                    rb.stmts.add(new br(currentBlock.label));
                    phi instr = new phi(retEntity);
                    instr.add(new constant(retEntity.type, false), lb.label);
                    instr.add(re, rb.label);
                    currentBlock.stmts.add(instr);
                }
            }
        }
    }

    @Override
    public void visit(bracketExprNode it) {
        it.expr.accept(this);
    }

    @Override
    public void visit(primaryNode it) {
        if (it.primaryType == primaryNode.primaryTypeToken.NULL)
            retEntity = new constant(new ptrType(null));
        else if (it.primaryType == primaryNode.primaryTypeToken.INT)
            retEntity = new constant(new baseType(baseType.typeToken.I, 32), Integer.parseInt(it.primaryCtx));
        else if (it.primaryType == primaryNode.primaryTypeToken.BOOL)
            retEntity = new constant(new baseType(baseType.typeToken.I, 1), it.primaryCtx.equals("true"));
        else if (it.primaryType == primaryNode.primaryTypeToken.STRING){
            IRType i8 = new baseType(baseType.typeToken.I, 8);
            IRType arrType = new arrayType(it.primaryCtx.length() + 1, i8);
            Entity strPtr;
            if (!strCollector.containsKey(it.primaryCtx)){
                strPtr = new globalEntity(new ptrType(arrType), ".str." + (currentStrNum++), true);
                strCollector.put(it.primaryCtx, strPtr);
            }
            else strPtr = strCollector.get(it.primaryCtx);
            retEntity = new register(false, new ptrType(i8), Integer.toString(++currentRegNum));
            getelementptr instr = new getelementptr(retEntity, false, arrType, strPtr);
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
