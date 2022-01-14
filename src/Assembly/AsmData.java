package Assembly;

public class AsmData {
    public enum dataType{
        ZERO, BYTE, WORD, STRING
    }

    public boolean isConst;
    public String name;
    public dataType type;
    public int val;
    public String str;

    public AsmData(boolean isConst_, String name_, int value, boolean isBoolean){
        isConst = isConst_;
        name = name_;
        type = isBoolean ? dataType.ZERO : dataType.WORD;
        val = value;
    }

    public AsmData(boolean isConst_, String name_, String value){
        isConst = isConst_;
        name = name_;
        type = dataType.STRING;
        str = value;
    }

    @Override
    public String toString(){
        String ret = "\t.section\t" + (isConst ? ".rodata" : ".sdata") + "\n";
        ret += "\t.p2align\t2\n";
        if (type != dataType.STRING) {
            ret += "\t.globl\t" + name + "\n";
            ret += name + ":\n";
        } else ret += name + ":\n";
        ret += "\t." + type.name().toLowerCase() + "\t";
        switch (type){
            case ZERO, BYTE, WORD -> ret += val;
            case STRING -> ret += "\"" + str + "\"";
        }
        ret += "\n";
        return ret;
    }
}
