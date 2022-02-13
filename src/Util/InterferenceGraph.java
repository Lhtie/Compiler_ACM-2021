package Util;

import Assembly.Instr.Instr;
import org.antlr.v4.runtime.misc.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class InterferenceGraph {
    public HashSet<Pair<Integer, Integer> > adjSet = new HashSet<>();
    public HashMap<Integer, HashSet<Integer> > adjList = new HashMap<>();
    public HashMap<Integer, Integer> degree = new HashMap<>();
    public HashMap<Integer, HashSet<Instr> > moveList;
    public HashMap<Integer, Integer> alias, color;

    private int nonPreColoredNum, N;

    public InterferenceGraph(int nonPreColoredNum_, int N_) {
        nonPreColoredNum = nonPreColoredNum_;
        N = N_;
        for (int i = 0; i < nonPreColoredNum; ++i){
            adjList.put(i, new HashSet<>());
            degree.put(i, 0);
        }
        moveList = new HashMap<>();
        for (int i = 0; i < N; ++i)
            moveList.put(i, new HashSet<>());
        alias = new HashMap<>();
        color = new HashMap<>();
        for (int i = nonPreColoredNum; i < N; ++i) {
            degree.put(i, Integer.MAX_VALUE);
            color.put(i, i - nonPreColoredNum);
        }
    }

    private boolean isPreColored(int index){
        return index >= nonPreColoredNum;
    }

    public void AddEdge(int u,  int v){
        if (!adjSet.contains(new Pair<>(u, v)) && u != v) {
            adjSet.add(new Pair<>(u, v));
            adjSet.add(new Pair<>(v, u));
            if (!isPreColored(u)){
                adjList.get(u).add(v);
                int deg = degree.get(u);
                degree.put(u, deg + 1);
            }
            if (!isPreColored(v)){
                adjList.get(v).add(u);
                int deg = degree.get(v);
                degree.put(v, deg + 1);
            }
        }
    }
}
