package Util.Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class Node {
    public HashSet<Node> succ, pred;

    public Node() {
        succ = new HashSet<>();
        pred = new HashSet<>();
    }

    public ArrayList<Node> succ(){
        return new ArrayList<>(succ);
    }

    public ArrayList<Node> pred(){
        return new ArrayList<>(pred);
    }

    public ArrayList<Node> adj(){
        ArrayList<Node> ret = new ArrayList<>(succ);
        ret.addAll(pred);
        return ret;
    }

    public int outDegree(){
        return succ.size();
    }

    public int inDegree(){
        return pred.size();
    }

    public int degree(){
        return outDegree() + inDegree();
    }

    public boolean goesTo(Node n){
        return succ.contains(n);
    }

    public boolean comesFrom(Node n){
        return pred.contains(n);
    }

    public boolean adj(Node n){
        return goesTo(n) || comesFrom(n);
    }
}
