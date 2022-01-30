package Util.FlowGraph;

import Assembly.AsmBlock;
import Assembly.AsmFn;
import Assembly.AsmMod;
import Assembly.Instr.Instr;
import Assembly.Operand.Reg;
import Assembly.Instr.*;
import Util.Graph.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class AsmFlowGraph extends FlowGraph<Reg> {
    public AsmMod topAsmMod;
    public AsmFn fn;

    public HashMap<Node, Instr> toInstr = new HashMap<>();
    public HashMap<Instr, Node> toNode = new HashMap<>();
    public HashMap<Instr, Integer> loopDepth = new HashMap<>();

    private HashMap<String, Instr> entryInstr = new HashMap<>();
    private HashMap<Node, String> belongBlock = new HashMap<>();
    private HashSet<Node> visited;

    private void newNode(AsmBlock bb){
        for (Instr iter = bb.head; iter != null; iter = iter.nxt){
            Node n = super.newNode();
            toInstr.put(n, iter);
            toNode.put(iter, n);
            loopDepth.put(iter, 0);
            belongBlock.put(n, bb.label);
        }
    }

    private void build(AsmBlock bb){
        for (Instr iter = bb.head; iter != null; iter = iter.nxt) {
            if (iter instanceof j)
                super.addEdge(toNode.get(iter), toNode.get(entryInstr.get(((j) iter).offset)));
            else {
                if (iter instanceof brPseOp)
                    super.addEdge(toNode.get(iter), toNode.get(entryInstr.get(((brPseOp) iter).offset)));
                if (iter.nxt != null)
                    super.addEdge(toNode.get(iter), toNode.get(iter.nxt));
            }
        }
    }

    public AsmFlowGraph(AsmMod topAsmMod_, AsmFn fn_){
        topAsmMod = topAsmMod_;
        fn = fn_;
        newNode(fn.entry);
        fn.blocks.forEach(bb -> {
            entryInstr.put(bb.label, bb.head);
            newNode(bb);
        });
        build(fn.entry);
        fn.blocks.forEach(this::build);
    }

    public Instr instr(Node n){
        return toInstr.get(n);
    }

    public Node node(Instr i) {
        return toNode.get(i);
    }

    private void bfs(Node start, ArrayList<Node> order){
        order.add(start);
        int head = 0;
        while (head < order.size()) {
            Node x = order.get(head);
            x.succ.forEach(to -> {
                if (!visited.contains(to)) {
                    order.add(to);
                    visited.add(to);
                } else {
                    String label1 = belongBlock.get(to), label2 = belongBlock.get(x);
                    int l = Integer.parseInt(label1.substring(label1.indexOf('_') + 1));
                    int r = Integer.parseInt(label2.substring(label2.indexOf('_') + 1));
                    if (l <= r)
                        for (int i = l; i <= r; ++i){
                            AsmBlock bb = i == 0 ? fn.entry : fn.blocks.get(i - 1);
                            for (Instr iter = bb.head; iter != null; iter = iter.nxt){
                                int t = loopDepth.get(iter);
                                loopDepth.put(iter, t + 1);
                            }
                        }
                }
            });
            head++;
        }
    }

    public ArrayList<Node> getOrder(Instr entry){
        visited = new HashSet<>();
        visited.add(toNode.get(entry));
        ArrayList<Node> ret = new ArrayList<>();
        bfs(toNode.get(entry), ret);
        Collections.reverse(ret);
        return ret;
    }

    @Override
    public ArrayList<Reg> def(Node node) {
        Instr instr = toInstr.get(node);
        ArrayList<Reg> ret = instr.def();
        if (instr instanceof callPse)
            ret.addAll(topAsmMod.callerRegs);
        return ret;
    }

    @Override
    public ArrayList<Reg> use(Node node) {
        Instr instr = toInstr.get(node);
        ArrayList<Reg> ret = instr.use();
        ret.removeIf(reg -> reg == topAsmMod.regs.get(0));
        if (instr instanceof retPse)
            ret.addAll(topAsmMod.calleeRegs);
        return ret;
    }

    @Override
    public boolean isMove(Node node) {
        return toInstr.get(node) instanceof mv;
    }
}
