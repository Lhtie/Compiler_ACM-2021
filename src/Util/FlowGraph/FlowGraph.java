package Util.FlowGraph;

import Util.Graph.Graph;
import Util.Graph.Node;

import java.util.HashSet;

public abstract class FlowGraph<T> extends Graph {
    public abstract HashSet<T> kill(Node node);
    public abstract HashSet<T> gen(Node node);
}
