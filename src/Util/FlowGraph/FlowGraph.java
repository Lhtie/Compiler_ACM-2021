package Util.FlowGraph;

import Util.Graph.Graph;
import Util.Graph.Node;

import java.util.ArrayList;

public abstract class FlowGraph<T> extends Graph {
    public abstract ArrayList<T> def(Node node);
    public abstract ArrayList<T> use(Node node);
    public abstract boolean isMove(Node node);
}
