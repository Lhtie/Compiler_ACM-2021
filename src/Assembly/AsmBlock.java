package Assembly;

import Assembly.Instr.Instr;

import java.util.HashMap;

public class AsmBlock {
    public Instr head = null, tail = null;
    public String label;
    public HashMap<AsmBlock, Instr> prevInstr;

    public AsmBlock(String label_) {
        label = label_;
        prevInstr = new HashMap<>();
    }

    public void insert_before(Instr pos, Instr x){
        if (pos.prv == null) head = x;
        else pos.prv.nxt = x;
        x.prv = pos.prv;
        x.nxt = pos;
        pos.prv = x;
    }

    public void insert_after(Instr pos, Instr x){
        if (pos.nxt == null) tail = x;
        else pos.nxt.prv = x;
        x.nxt = pos.nxt;
        x.prv = pos;
        pos.nxt = x;
    }

    public void push_back(Instr x){
        if (head == null) head = tail = x;
        else insert_after(tail, x);
    }

    public void push_front(Instr x){
        if (head == null) head = tail = x;
        else insert_before(head, x);
    }
}
