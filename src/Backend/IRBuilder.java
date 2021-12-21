package Backend;

import AST.*;
import LLVMIR.BasicBlock;
import LLVMIR.Class;
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

import java.util.*;

public class IRBuilder implements ASTVisitor {
    private HashMap<String, Entity> strCollector;
    private ArrayList<BasicBlock> loopFlowCollector;
    private globalScope gScope;
    private Scope currentScope;
    private Module topModule;
    private Function currentFn;
    private BasicBlock currentBlock;
    private int currentStrNum;
    private Entity retEntity;
    private Function retFunc;
    private boolean retFuncInCl;
    private IRType type;

    private boolean isGlobalVarDef;
    private Function globalVarInitFn;

    public IRBuilder(globalScope scope, Module module){
        strCollector = new HashMap<>();
        loopFlowCollector = new ArrayList<>();
        gScope = scope;
        currentScope = scope;
        topModule = module;
        currentStrNum = 0;
        isGlobalVarDef = false;
    }

    private Entity loadPtrType(Entity ptr) {
        register val = new register(false, ((ptrType) ptr.type).type, currentFn.getRegId());
        currentBlock.stmts.add(new load(val, ptr));
        return val;
    }

    private boolean isString(Entity x){
        return x.type instanceof ptrType p && p.type instanceof baseType q && q.i_N == 8;
    }

    private boolean isNull(Entity x){
        return x instanceof constant c && c.constType == constant.constantType.NULL;
    }

    @Override
    public void visit(RootNode it) {
        topModule.gVars.add(new constStmt("@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @__cxx_global_var_init, i8* null }]"));
        globalVarInitFn = new Function(1, new baseType(baseType.typeToken.VOID), "__cxx_global_var_init", new ArrayList<>(), new BasicBlock("0"));
        topModule.fns.add(globalVarInitFn);

        it.define.forEach(x -> x.accept(this));
        for (Map.Entry<String, Entity> entry : strCollector.entrySet()){
            topModule.gVars.add(new global(entry.getValue(), global.defineType.CONSTANT,
                    new constant(((ptrType) entry.getValue().type).type, entry.getKey())));
        }

        globalVarInitFn.entry.stmts.add(new ret(new constant(new baseType(baseType.typeToken.VOID))));
    }

    @Override
    public void visit(classDefNode it) {
        currentScope = ((globalScope)currentScope).getScopeFromClass(it.pos, it.name);
        gScope = (globalScope) currentScope;
        if (it.constructorDef != null)
            it.constructorDef.accept(this);
        else {
            ArrayList<Entity> parameters = new ArrayList<>();
            parameters.add(new register(false, new ptrType(new classType(gScope.currentClass)), "0"));
            BasicBlock block = new BasicBlock("1");
            block.stmts.add(new ret(new constant(new baseType(baseType.typeToken.VOID))));
            Function fn = new Function(2, new baseType(baseType.typeToken.VOID),
                    "class." + it.name, parameters, block);
            gScope.addFunc(fn.identifier, fn);
            topModule.fns.add(fn);
        }
        it.funcDef.forEach(x -> x.accept(this));
        gScope = (globalScope) gScope.getParentScope();
        currentScope = currentScope.getParentScope();
    }

    @Override
    public void visit(constructorDefNode it) {
        currentScope = new Scope(currentScope);
        int regNum = 0;
        ArrayList<Entity> parameters = new ArrayList<>();
        parameters.add(new register(false, new ptrType(new classType(gScope.currentClass)),
                Integer.toString(regNum++)));
        gScope.classEntity = parameters.get(0);
        currentBlock = new BasicBlock(Integer.toString(regNum++));
        currentFn = new Function(regNum, new baseType(baseType.typeToken.VOID),
                "class." + it.name, parameters, currentBlock);
        topModule.fns.add(currentFn);
        gScope.addFunc(currentFn.identifier, currentFn);
        it.suite.accept(this);
        if (!currentBlock.branched){
            Entity ret = new constant(currentFn.retType);
            currentBlock.stmts.add(new ret(ret));
        }
        currentScope = currentScope.getParentScope();
    }

    @Override
    public void visit(globalVarDefNode it) {
        isGlobalVarDef = true;
        it.varDef.accept(this);
        isGlobalVarDef = false;
    }

    @Override
    public void visit(varDefNode it) {
        it.type.accept(this);
        it.varDefArg.forEach(x -> {
            if (isGlobalVarDef) {
                Entity res = new globalEntity(new ptrType(type), x.name, false);
                topModule.gVars.add(new global(res, global.defineType.GLOBAL, new constant(type)));
                currentScope.addRegister(x.name, res);
                if (x.isInitialized){
                    currentBlock = new BasicBlock("0");
                    Function fn = new Function(1, new baseType(baseType.typeToken.VOID),
                            "__cxx_global_var_init." + globalVarInitFn.getRegId(),
                            new ArrayList<>(), currentBlock);
                    currentFn = fn;
                    globalVarInitFn.entry.stmts.add(new call(null, fn, new ArrayList<>()));
                    x.expr.accept(this);
                    if (retEntity.islValue)
                        retEntity = loadPtrType(retEntity);
                    if (isNull(retEntity))
                        retEntity.type = ((ptrType) res.type).type;
                    currentBlock.stmts.add(new store(retEntity, res));
                    currentBlock.stmts.add(new ret(new constant(new baseType(baseType.typeToken.VOID))));
                    topModule.fns.add(fn);
                }
            } else {
                Entity res = new register(true, new ptrType(type), currentFn.getRegId());
                currentBlock.stmts.add(new alloca(res, type));
                currentScope.addRegister(x.name, res);
                if (x.isInitialized) {
                    x.expr.accept(this);
                    if (retEntity.islValue)
                        retEntity = loadPtrType(retEntity);
                    if (isNull(retEntity))
                        retEntity.type = ((ptrType) res.type).type;
                    currentBlock.stmts.add(new store(retEntity, res));
                }
            }
        });
    }

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
    public void visit(basicTypeNode it) {}

    @Override
    public void visit(varDefArgNode it) {}

    @Override
    public void visit(funcDefNode it) {
        currentFn = gScope.getFunc(it.name);
        currentBlock = currentFn.entry;
        if (gScope.getParentScope() != null)
            gScope.classEntity = currentFn.parameters.get(0);

        currentScope = gScope.getScopeFromFunc(it.pos, it.name);
        it.parameterList.accept(this);
        currentFn.retEntity = new register(true, new ptrType(currentFn.retType), currentFn.getRegId());
        currentBlock.stmts.add(new alloca(currentFn.retEntity, currentFn.retType));
        it.suite.accept(this);
        currentScope = currentScope.getParentScope();

        if (!currentBlock.branched){
            Entity ret = new constant(currentFn.retType);
            currentBlock.stmts.add(new store(ret, currentFn.retEntity));
            currentFn.retBlocks.add(currentBlock);
        }
        currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
        currentFn.retBlocks.forEach(x -> {x.stmts.add(new br(currentBlock.label));});
        currentBlock.stmts.add(new ret(loadPtrType(currentFn.retEntity)));
    }

    @Override
    public void visit(funcTypeNode it) {}

    @Override
    public void visit(parameterListNode it) {
        it.parameter.forEach(x -> x.accept(this));
    }

    @Override
    public void visit(parameterNode it) {
        Entity val = currentScope.getRegister(it.name, false, currentBlock, currentFn);
        Entity ptr = new register(true, new ptrType(val.type), currentFn.getRegId());
        currentBlock.stmts.add(new alloca(ptr, val.type));
        currentBlock.stmts.add(new store(val, ptr));
        currentScope.addRegister(it.name, ptr);
    }

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
            currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
            BasicBlock eb1 = currentBlock;
            currentScope = new Scope(currentScope);
            it.block.accept(this);
            currentScope = currentScope.getParentScope();
            BasicBlock b1 = currentBlock;
            if (it.elseStmt == null){
                currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
                ob.stmts.add(new br(cmpRes, eb1.label, currentBlock.label));
                if (!b1.branched)
                    b1.stmts.add(new br(currentBlock.label));
                else loopFlowCollector.add(b1);
            } else {
                currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
                BasicBlock eb2 = currentBlock;
                it.elseStmt.accept(this);
                BasicBlock b2 = currentBlock;
                currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
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
        currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
        BasicBlock cbEntry = currentBlock;
        ob.stmts.add(new br(cbEntry.label));
        it.expr.accept(this);
        if (retEntity.islValue)
            retEntity = loadPtrType(retEntity);
        Entity cond = retEntity;
        BasicBlock cbExit = currentBlock;
        currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
        BasicBlock bbEntry = currentBlock;
        currentScope = new Scope(currentScope);
        it.block.accept(this);
        currentScope = currentScope.getParentScope();
        BasicBlock bbExit = currentBlock;
        currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
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
        currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
        BasicBlock cbEntry = currentBlock;
        ob.stmts.add(new br(cbEntry.label));
        if (it.forStop != null)
            it.forStop.accept(this);
        Entity cond = retEntity;
        BasicBlock cbExit = currentBlock;
        currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
        BasicBlock bbEntry = currentBlock;
        it.block.accept(this);
        BasicBlock bbExit = currentBlock;
        currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
        BasicBlock ibEntry = currentBlock;
        if (it.expr != null)
            it.expr.accept(this);
        BasicBlock ibExit = currentBlock;
        ibExit.stmts.add(new br(cbEntry.label));
        currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
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
        if (it.expr != null) {
            it.expr.accept(this);
            if (retEntity.islValue)
                retEntity = loadPtrType(retEntity);
            if (isNull(retEntity))
                retEntity.type = currentFn.retType;
        } else
            retEntity = new constant(new baseType(baseType.typeToken.VOID));
        currentBlock.stmts.add(new store(retEntity, currentFn.retEntity));
        currentFn.retBlocks.add(currentBlock);
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
        register res = new register(false, type, currentFn.getRegId());
        currentBlock.stmts.add(new binaryOp(res, binaryOp.binaryOpType.ADD,
                val, new constant(type, it.preIncDecOp == preIncDecExprNode.preIncDecOpType.PLUSPLUS ? 1 : -1)));
        currentBlock.stmts.add(new store(res, retEntity));
    }

    @Override
    public void visit(postIncDecExprNode it) {
        it.expr.accept(this);
        Entity val = loadPtrType(retEntity);
        IRType type = val.type;
        register res = new register(false, type, currentFn.getRegId());
        currentBlock.stmts.add(new binaryOp(res, binaryOp.binaryOpType.ADD,
                val, new constant(type, it.postIncDecOp == postIncDecExprNode.postIncDecOpType.PLUSPLUS ? 1 : -1)));
        currentBlock.stmts.add(new store(res, retEntity));
        retEntity = val;
    }

    @Override
    public void visit(funcCallExprNode it) {
        retEntity = gScope.classEntity;
        it.expr.accept(this);
        ArrayList<Entity> parameters = new ArrayList<>();
        if (retFuncInCl)
            parameters.add(retEntity);
        Function fn = retFunc;
        for (int i = 0; i < it.argList.expr.size(); ++i){
            ExprNode x = it.argList.expr.get(i);
            x.accept(this);
            if (retEntity.islValue)
                retEntity = loadPtrType(retEntity);
            if (isNull(retEntity))
                retEntity.type = fn.parameters.get(i).type;
            parameters.add(retEntity);
        }
        if (fn.retType instanceof baseType base && base.typeName == baseType.typeToken.VOID)
            retEntity = null;
        else retEntity = new register(false, fn.retType, currentFn.getRegId());
        call instr = new call(retEntity, fn, parameters);
        currentBlock.stmts.add(instr);
    }

    @Override
    public void visit(arrayExprNode it) {
        it.title.accept(this);
        Entity arrPtr = loadPtrType(retEntity);
        it.index.accept(this);
        if (retEntity.islValue)
            retEntity = loadPtrType(retEntity);
        Entity offset = retEntity;
        IRType type = ((ptrType) arrPtr.type).type;
        Entity res = new register(true, arrPtr.type, currentFn.getRegId());
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
                Entity res = new register(false, retEntity.type, currentFn.getRegId());
                currentBlock.stmts.add(new binaryOp(res, binaryOp.binaryOpType.SUB,
                        new constant(retEntity.type, 0), retEntity));
                retEntity = res;
            }
        } else if (it.unaryOp == unaryExprNode.unaryOpType.NOT_OP
            || it.unaryOp == unaryExprNode.unaryOpType.NOT_LOG){
            if (retEntity instanceof constant){
                retEntity = ((constant) retEntity).not();
            } else {
                Entity res = new register(false, retEntity.type, currentFn.getRegId());
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
            it.lhs.accept(this);
            if (retEntity.islValue)
                retEntity = loadPtrType(retEntity);
            globalScope gScope_ = gScope;
            Scope currentScope_ = currentScope;
            if (((ptrType) retEntity.type).type instanceof classType cl)
                currentScope = gScope.getScopeFromClass(it.pos, cl.className);
            else if (((ptrType) retEntity.type).type instanceof baseType bs && bs.i_N == 8)
                currentScope = gScope.getScopeFromClass(it.pos, "class.string");
            else {
                currentScope = gScope.getScopeFromClass(it.pos, "class.__array");
                Entity res = new register(false, new ptrType(new baseType(baseType.typeToken.I, 8)),
                        currentFn.getRegId());
                currentBlock.stmts.add(new convertOp(convertOp.convertType.BITCAST, res, retEntity));
                retEntity = res;
            }
            gScope = (globalScope) currentScope;
            Entity classEntity_ = gScope.classEntity;
            gScope.classEntity = retEntity;
            it.rhs.accept(this);
            gScope.classEntity = classEntity_;
            currentScope = currentScope_;
            gScope = gScope_;
        } else if (it.binaryOp == binaryExprNode.binaryOpType.ASSIGN){
            it.rhs.accept(this);
            if (retEntity.islValue)
                retEntity = loadPtrType(retEntity);
            Entity res = retEntity;
            it.lhs.accept(this);
            if (isNull(res))
                res.type = ((ptrType) retEntity.type).type;
            currentBlock.stmts.add(new store(res, retEntity));
        } else if (it.isCmpOp() || it.isArithOp()){
            it.lhs.accept(this);
            Entity l = retEntity;
            it.rhs.accept(this);
            Entity r = retEntity;
            if (l.islValue) l = loadPtrType(l);
            if (r.islValue) r = loadPtrType(r);
            if (isString(l) && isString(r)){
                if (it.isArithOp()){
                    retEntity = new register(false, new ptrType(new baseType(baseType.typeToken.I, 8)),
                            currentFn.getRegId());
                    currentBlock.stmts.add(new call(retEntity, topModule.string_add, new ArrayList<>(List.of(l, r))));
                } else {
                    retEntity = new register(false, new baseType(baseType.typeToken.I, 1),
                            currentFn.getRegId());
                    ArrayList<Entity> p = new ArrayList<>(List.of(l, r));
                    switch(it.binaryOp){
                        case EQUALS -> currentBlock.stmts.add(new call(retEntity, topModule.string_eq, p));
                        case NOT_EQ -> currentBlock.stmts.add(new call(retEntity, topModule.string_ne, p));
                        case LESS_THAN -> currentBlock.stmts.add(new call(retEntity, topModule.string_lt, p));
                        case LT_EQ -> currentBlock.stmts.add(new call(retEntity, topModule.string_le, p));
                        case GREATER_THAN -> currentBlock.stmts.add(new call(retEntity, topModule.string_gt, p));
                        case GT_EQ -> currentBlock.stmts.add(new call(retEntity, topModule.string_ge, p));
                    }
                }
                return ;
            }
            if (l instanceof constant && r instanceof constant){
                retEntity = ((constant) l).binaryOp(it, r);
            } else {
                if (isNull(l)) l.type = r.type;
                else if (isNull(r)) r.type = l.type;
                IRType type = it.isCmpOp() ? new baseType(baseType.typeToken.I, 1) : l.type;
                retEntity = new register(false, type, currentFn.getRegId());
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
                currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
                BasicBlock eb = currentBlock;
                it.rhs.accept(this);
                if (retEntity.islValue)
                    retEntity = loadPtrType(retEntity);
                Entity re = retEntity;
                BasicBlock rb = currentBlock;
                currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
                retEntity = new register(false, new baseType(baseType.typeToken.I, 1),
                        currentFn.getRegId());
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
        if (it.primaryType == primaryNode.primaryTypeToken.THIS)
            retEntity = currentFn.parameters.get(0);
        else if (it.primaryType == primaryNode.primaryTypeToken.NULL)
            retEntity = new constant(new ptrType(null));
        else if (it.primaryType == primaryNode.primaryTypeToken.INT)
            retEntity = new constant(new baseType(baseType.typeToken.I, 32), Integer.parseInt(it.primaryCtx));
        else if (it.primaryType == primaryNode.primaryTypeToken.BOOL)
            retEntity = new constant(new baseType(baseType.typeToken.I, 1), it.primaryCtx.equals("true"));
        else if (it.primaryType == primaryNode.primaryTypeToken.STRING){
            IRType i8 = new baseType(baseType.typeToken.I, 8);
            String ctx = it.primaryCtx;
            ctx = ctx.replace("\\n", "\\0A").replace("\\\"", "\\22").replace("\\\\", "\\5C");
            int cnt = 0;
            for (int i = 0; i < ctx.length(); ++i)
                cnt += ctx.charAt(i) == '\\' ? 2 : 0;
            IRType arrType = new arrayType(ctx.length() - cnt + 1, i8);
            Entity strPtr;
            if (!strCollector.containsKey(ctx)){
                strPtr = new globalEntity(new ptrType(arrType), ".str." + (currentStrNum++), true);
                strCollector.put(ctx, strPtr);
            }
            else strPtr = strCollector.get(ctx);
            retEntity = new register(false, new ptrType(i8), currentFn.getRegId());
            currentBlock.stmts.add(new convertOp(convertOp.convertType.BITCAST, retEntity, strPtr));
        }
        else {  // identifier
            if (it.isFuncId) {
                retFuncInCl = gScope.findFunc(it.primaryCtx, false) && gScope.getParentScope() != null;
                retFunc = gScope.getFunc(it.primaryCtx);
            } else retEntity = currentScope.getRegister(it.primaryCtx, true, currentBlock, currentFn);
        }
    }

    @Override
    public void visit(argListNode it) {}

    private Entity mallocArray(ArrayList<Entity> creatorSize, int cur, IRType base){
        int dim = creatorSize.size() - cur;
        Entity size = creatorSize.get(cur), bytes;
        long baseBytes = 8;
        if (dim <= 1)
            baseBytes = base instanceof ptrType ? 8 : ((baseType) base).i_N == 1 ? 1 : 4;
        if (size instanceof constant tmp)
            bytes = new constant(new baseType(baseType.typeToken.I, 64),
                    (tmp.constType == constant.constantType.I32 ? tmp.i32 : tmp.i64) * baseBytes + 4);
        else {
            Entity operand = new register(false, new baseType(baseType.typeToken.I, 64),
                    currentFn.getRegId());
            currentBlock.stmts.add(new convertOp(convertOp.convertType.SEXT, operand, size));
            Entity bytes_ = new register(false, operand.type, currentFn.getRegId());
            currentBlock.stmts.add(new binaryOp(bytes_, binaryOp.binaryOpType.MUL, operand,
                    new constant(operand.type, baseBytes)));
            bytes = new register(false, operand.type, currentFn.getRegId());
            currentBlock.stmts.add(new binaryOp(bytes, binaryOp.binaryOpType.ADD, bytes_,
                    new constant(operand.type, 4)));
        }
        Entity ptr = new register(false, new ptrType(new baseType(baseType.typeToken.I, 8)),
                currentFn.getRegId());
        ArrayList<Entity> parameters = new ArrayList<>(List.of(bytes));
        currentBlock.stmts.add(new call(ptr, topModule.malloc, parameters));
        Entity head = new register(false, new ptrType(new baseType(baseType.typeToken.I, 32)),
                currentFn.getRegId());
        currentBlock.stmts.add(new convertOp(convertOp.convertType.BITCAST, head, ptr));
        currentBlock.stmts.add(new store(size, head));
        head = new register(false, new ptrType(new baseType(baseType.typeToken.I, 8)),
                currentFn.getRegId());
        getelementptr instr = new getelementptr(head, true, new baseType(baseType.typeToken.I, 8), ptr);
        instr.addOffset(new constant(new baseType(baseType.typeToken.I, 32), 4));
        currentBlock.stmts.add(instr);

        IRType type = base;
        for (int i = 0; i < dim; ++i)
            type = new ptrType(type);
        Entity begin = new register(false, type, currentFn.getRegId());
        currentBlock.stmts.add(new convertOp(convertOp.convertType.BITCAST, begin, head));
        if (dim <= 1)
            return begin;
        Entity end = new register(false, type, currentFn.getRegId());
        instr = new getelementptr(end, true, ((ptrType) type).type, begin);
        instr.addOffset(size);
        currentBlock.stmts.add(instr);
        BasicBlock ob = currentBlock;
        currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
        BasicBlock bbEntry = currentBlock;
        Entity phiRes = new register(false, type, currentFn.getRegId());
        currentBlock.stmts.add(new phi(phiRes));
        Entity ctx = mallocArray(creatorSize, cur + 1, base);
        BasicBlock bbExit = currentBlock;
        currentBlock.stmts.add(new store(ctx, phiRes));
        Entity nxt = new register(false, type, currentFn.getRegId());
        instr = new getelementptr(nxt, true, ((ptrType) type).type, phiRes);
        instr.addOffset(new constant(new baseType(baseType.typeToken.I, 64), 1));
        currentBlock.stmts.add(instr);
        Entity cmp = new register(false, new baseType(baseType.typeToken.I, 1), currentFn.getRegId());
        currentBlock.stmts.add(new icmp(cmp, icmp.compareType.EQ, nxt, end));
        currentFn.blocks.add(currentBlock = new BasicBlock(currentFn.getRegId()));
        ob.stmts.add(new br(bbEntry.label));
        phi phi = (phi) bbEntry.stmts.get(0);
        phi.add(begin, ob.label);
        phi.add(nxt, bbExit.label);
        bbExit.stmts.add(new br(cmp, currentBlock.label, bbEntry.label));
        return begin;
    }

    @Override
    public void visit(creatorNode it) {
        if (it.creatorSize.size() == 0){    // new class
            assert(it.classId != null);
            Class cl = gScope.getClass(it.classId);
            Entity ptr = new register(false, new ptrType(new baseType(baseType.typeToken.I, 8)),
                    currentFn.getRegId());
            ArrayList<Entity> parameters = new ArrayList<>();
            parameters.add(new constant(new baseType(baseType.typeToken.I, 64), cl.bytes));
            currentBlock.stmts.add(new call(ptr, topModule.malloc, parameters));
            retEntity = new register(false, new ptrType(new classType(cl)), currentFn.getRegId());
            currentBlock.stmts.add(new convertOp(convertOp.convertType.BITCAST, retEntity, ptr));
            globalScope classScope = (globalScope) gScope.getScopeFromClass(it.pos, cl.className);
            parameters = new ArrayList<>(List.of(retEntity));
            currentBlock.stmts.add(new call(null, classScope.getFunc(cl.identifier), parameters));
        } else {    // new array
            IRType type;
            if (it.classId != null)
                type = new ptrType(new classType(gScope.getClass(it.classId)));
            else if (it.basicType.basicType == Type.typeToken.STRING)
                type = new ptrType(new baseType(baseType.typeToken.I, 8));
            else if (it.basicType.basicType == Type.typeToken.BOOL)
                type = new baseType(baseType.typeToken.I, 1);
            else    // it.basicType.basicType == Type.typeToken.INT
                type = new baseType(baseType.typeToken.I, 32);
            ArrayList<Entity> creatorSize = new ArrayList<>();
            it.creatorSize.forEach(x -> {
                if (x.expr == null)
                    return ;
                x.expr.accept(this);
                if (retEntity.islValue)
                    retEntity = loadPtrType(retEntity);
                creatorSize.add(retEntity);
            });
            for (int i = creatorSize.size(); i < it.creatorSize.size(); ++i)
                type = new ptrType(type);
            retEntity = mallocArray(creatorSize, 0, type);
        }
    }

    @Override
    public void visit(creatorSizeNode it) {}

    @Override
    public void visit(lambdaStmtNode it) {}
}
