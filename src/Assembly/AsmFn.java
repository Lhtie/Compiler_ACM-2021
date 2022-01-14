package Assembly;

import Assembly.Operand.Reg;
import Assembly.Operand.virtualReg;

import java.util.ArrayList;
import java.util.HashMap;

public class AsmFn {
    public int index;
    public String name;
    public AsmBlock entry;
    public ArrayList<AsmBlock> blocks;

    public Integer offset = 0;
    public HashMap<Reg, Integer> stackOffset;
    public int maxOverCall = 0;

    private int virtualRegNum = 0;

    public AsmFn(int index_, String name_, AsmMod topAsmMod){
        index = index_;
        name = name_;
        entry = new AsmBlock(".LBB" + index_ + "_0");
        blocks = new ArrayList<>();
        stackOffset = new HashMap<>();
        stackOffset.put(topAsmMod.regs.get(1), offset += 4);
        stackOffset.put(topAsmMod.regs.get(8), offset += 4);
    }

    public AsmBlock addBlock(){
        AsmBlock ret = new AsmBlock(".LBB" + index + "_" + (blocks.size() + 1));
        blocks.add(ret);
        return ret;
    }

    public virtualReg addVReg(int bytes){
        return new virtualReg(virtualRegNum++, bytes);
    }

    public void alloc(Reg reg, int bytes){
        stackOffset.put(reg, offset += bytes);
    }
}
