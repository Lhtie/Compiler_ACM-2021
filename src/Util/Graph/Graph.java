// class for directed graphs
package Util.Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class Graph {
    public HashSet<Node> nodes;

    public Graph() {
        nodes = new HashSet<>();
    }

    public ArrayList<Node> nodes(){
        return new ArrayList<>(nodes);
    }

    public Node newNode(){
        Node ret = new Node();
        nodes.add(ret);
        return ret;
    }

    public void addEdge(Node from, Node to){
        if (from != to && !from.succ.contains(to)){
            from.succ.add(to);
            to.pred.add(from);
        }
    }

    public void rmEdge(Node from, Node to){
        if (from != to && from.succ.contains(to)){
            from.succ.remove(to);
            to.pred.remove(from);
        }
    }
}
