package Util;

import Util.error.semanticError;

import java.util.ArrayList;
import java.util.Objects;

public class Type {
    public enum typeToken{
        BOOL, INT, VOID, STRING, CLASS, FUNC, THIS, NULL
    }

    public typeToken typeName;
    public String identifier;
    public int dim;
    public boolean islValue;
    public Type funcRetType;
    public ArrayList<Type> funcParameters;

    public Type(typeToken type, int dim_, boolean islValue_){
        typeName = type;
        dim = dim_;
        islValue = islValue_;
    }

    public Type(String id, int dim_, boolean islValue_){
        typeName = typeToken.CLASS;
        identifier = id;
        dim = dim_;
        islValue = islValue_;
    }

    public Type(String id, Type retType, ArrayList<Type> parameters){
        typeName = typeToken.FUNC;
        identifier = id;
        funcRetType = retType;
        funcParameters = parameters;
        dim = 0;
        islValue = false;
    }

    public Type(Type other){
        typeName = other.typeName;
        identifier = other.identifier;
        dim = other.dim;
        islValue = other.islValue;
        if (other.funcRetType == null)
            funcRetType = null;
        else funcRetType = new Type(other.funcRetType);
        if (other.funcParameters == null)
            funcParameters = null;
        else funcParameters = new ArrayList<>(other.funcParameters);
    }

    public boolean referable(){
        return typeName == typeToken.CLASS
                || typeName == typeToken.STRING
                || typeName == typeToken.THIS
                || dim > 0
                ;
    }

    public void typeMatcher(position pos, Type other){
        if (this.typeName != other.typeName)
            throw new semanticError("Semantic Error: type unmatched", pos);
        if (this.typeName == Type.typeToken.CLASS) {
            if (other.identifier == null || !other.identifier.equals(this.identifier))
                throw new semanticError("Semantic Error: class name unmatched", pos);
        }
        if (this.dim != other.dim)
            throw new semanticError("Semantic Error: dimension unmatched", pos);
    }

    public void assignChecker(position pos, globalScope gScope, Type other){
        if (!this.islValue)
            throw new semanticError("Semantic Error: cannot assign to rvalue", pos);
        if(other.typeName == Type.typeToken.NULL){
            if (!this.referable() || this.typeName == typeToken.STRING && this.dim == 0)
                throw new semanticError("Semantic Error: cannot assign null", pos);
        } else if (other.typeName == typeToken.THIS){
            if (this.typeName != typeToken.CLASS)
                throw new semanticError("Semantic Error: cannot assign this to non-class", pos);
            if (!Objects.equals(this.identifier, gScope.identifier))
                throw new semanticError("Semantic Error: class name not matched", pos);
        } else this.typeMatcher(pos, other);
    }
}
