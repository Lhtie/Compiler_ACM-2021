package LLVMIR;

import java.util.ArrayList;
import LLVMIR.Stmt.*;

public class Module {
    public ArrayList<Stmt> gVars;
    public ArrayList<Function> fns;

    public Module(){
        gVars = new ArrayList<>();
        fns = new ArrayList<>();
    }
}
