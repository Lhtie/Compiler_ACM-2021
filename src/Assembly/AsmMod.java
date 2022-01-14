package Assembly;

import Assembly.Operand.*;

import java.util.ArrayList;
import java.util.Arrays;

public class AsmMod {
    public static ArrayList<String> phyRegName = new ArrayList<>(Arrays.asList(
            "zero", "ra", "sp", "gp", "tp", "t0", "t1", "t2", "s0", "s1",
            "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7",
            "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "s11", "t3", "t4", "t5", "t6"));

    public ArrayList<AsmFn> fns;
    public ArrayList<AsmData> dts;
    public ArrayList<phyReg> regs;

    public AsmMod(){
        fns = new ArrayList<>();
        dts = new ArrayList<>();
        regs = new ArrayList<>();
        for (int i = 0; i < 32; ++i)
            regs.add(new phyReg(phyRegName.get(i)));
    }

    public AsmFn addFn(String name){
        AsmFn ret = new AsmFn(fns.size(), name, this);
        fns.add(ret);
        return ret;
    }
}
