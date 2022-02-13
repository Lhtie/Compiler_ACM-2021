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

    public ArrayList<phyReg> calleeRegs, callerRegs;

    public AsmMod(){
        fns = new ArrayList<>();
        dts = new ArrayList<>();
        regs = new ArrayList<>();
        calleeRegs = new ArrayList<>();
        callerRegs = new ArrayList<>();
        for (int i = 0; i < 32; ++i)
            regs.add(new phyReg(phyRegName.get(i)));

        calleeRegs.add(regs.get(9));
        for (int i = 18; i <= 27; ++i)
            calleeRegs.add(regs.get(i));
        for (int i = 5; i <= 7; ++i)
            callerRegs.add(regs.get(i));
        for (int i = 10; i <= 17; ++i)
            callerRegs.add(regs.get(i));
        for (int i = 28; i <= 31; ++i)
            callerRegs.add(regs.get(i));
    }

    public AsmFn addFn(String name){
        AsmFn ret = new AsmFn(fns.size(), name, this);
        fns.add(ret);
        return ret;
    }
}
