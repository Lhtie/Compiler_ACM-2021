package Util.FlowGraph;

import Assembly.AsmBlock;
import Assembly.AsmFn;
import Assembly.AsmMod;
import Assembly.Instr.Instr;
import Assembly.Operand.Reg;
import Assembly.Instr.*;
import Assembly.Operand.phyReg;
import Assembly.Operand.virtualReg;
import Util.Graph.Node;

import java.util.*;

public class AsmFlowGraph extends FlowGraph<Reg> {
    public AsmMod topAsmMod;
    public AsmFn fn;
    public HashMap<Instr, Integer> loopDepth = new HashMap<>();
    public HashMap<Node, BitSet> liveIn, liveOut;

    private HashMap<Node, AsmBlock> toBlock = new HashMap<>();
    private HashMap<AsmBlock, Node> toNode = new HashMap<>();
    private HashMap<Node, HashSet<Reg> > killMap = new HashMap<>(), genMap = new HashMap<>();
    private HashMap<String, AsmBlock> blockMap = new HashMap<>();
    private HashMap<Instr, AsmBlock> belongBlock = new HashMap<>();
    private HashSet<Node> visited;
    private ArrayList<Node> order;

    private void Initial(AsmBlock bb){
        Node n = new Node();
        toBlock.put(n, bb);
        toNode.put(bb, n);
        blockMap.put(bb.label, bb);
        for (Instr it = bb.head; it != null; it = it.nxt) {
            loopDepth.put(it, 0);
            belongBlock.put(it, bb);
        }
        HashSet<Reg> kill = new HashSet<>(), gen = new HashSet<>();
        for (Instr it = bb.tail; it != null; it = it.prv) {
            ArrayList<Reg> use = use(it), def = def(it);
            def.forEach(gen::remove);
            kill.addAll(def);
            gen.addAll(use);
        }
        killMap.put(n, kill);
        genMap.put(n, gen);
    }

    private void build(AsmBlock bb){
        for (Instr iter = bb.head; iter != null; iter = iter.nxt)
            if (iter instanceof j)
                super.addEdge(toNode.get(bb), toNode.get(blockMap.get(((j) iter).offset)));
            else if (iter instanceof brPseOp)
                super.addEdge(toNode.get(bb), toNode.get(blockMap.get(((brPseOp) iter).offset)));
    }

    private void bfs(Node start){
        order.add(start);
        int head = 0;
        while (head < order.size()) {
            Node x = order.get(head);
            x.succ.forEach(to -> {
                if (!visited.contains(to)) {
                    order.add(to);
                    visited.add(to);
                } else {
                    String label1 = toBlock.get(to).label, label2 = toBlock.get(x).label;
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

    private void getOrder(AsmBlock entry){
        visited = new HashSet<>();
        visited.add(toNode.get(entry));
        order = new ArrayList<>();
        bfs(toNode.get(entry));
        Collections.reverse(order);
    }

    public AsmFlowGraph(AsmMod topAsmMod_, AsmFn fn_){
        topAsmMod = topAsmMod_;
        fn = fn_;
        Initial(fn.entry);
        fn.blocks.forEach(this::Initial);
        build(fn.entry);
        fn.blocks.forEach(this::build);
        getOrder(fn.entry);
    }

    public boolean withinGraph(AsmBlock b) {
        return order.contains(toNode.get(b));
    }

    public AsmBlock block(Node n){
        return toBlock.get(n);
    }

    public Node node(AsmBlock bb) {
        return toNode.get(bb);
    }

    public ArrayList<Reg> def(Instr instr) {
        ArrayList<Reg> ret = instr.def();
        if (instr instanceof callPse)
            ret.addAll(topAsmMod.callerRegs);
        return ret;
    }

    public ArrayList<Reg> use(Instr instr) {
        ArrayList<Reg> ret = instr.use();
        ret.removeIf(reg -> reg == topAsmMod.regs.get(0));
        if (instr instanceof retPse)
            ret.addAll(topAsmMod.calleeRegs);
        return ret;
    }

    @Override
    public HashSet<Reg> kill(Node node) {
        return killMap.get(node);
    }

    @Override
    public HashSet<Reg> gen(Node node) {
        return genMap.get(node);
    }

    private int index(Reg reg){
        if (reg instanceof virtualReg){
            return ((virtualReg) reg).index;
        } else { // instanceof phyReg
            return fn.virtualRegNum + topAsmMod.regs.indexOf((phyReg) reg);
        }
    }

    public void LivenessAnalysis(int N){
        liveIn = new HashMap<>();
        liveOut = new HashMap<>();
        order.forEach(n -> {
            liveIn.put(n, new BitSet(N));
            liveOut.put(n, new BitSet(N));
        });
        boolean changed = true;
        for (; changed; ){
            changed = false;
            for (Node n : order) {
                BitSet inTmp = (BitSet) liveIn.get(n).clone(), outTmp = (BitSet) liveOut.get(n).clone();
                BitSet outn = liveOut.get(n);
                for (Reg reg : kill(n)) outn.clear(index(reg));
                for (Reg reg : gen(n)) outn.set(index(reg));
                liveIn.put(n, outn);
                if (!outn.equals(inTmp)) changed = true;
                outn = new BitSet(N);
                for (Node to : n.succ)
                    outn.or(liveIn.get(to));
                liveOut.put(n, outn);
                if (!outn.equals(outTmp)) changed = true;
            }
        }
    }
}
