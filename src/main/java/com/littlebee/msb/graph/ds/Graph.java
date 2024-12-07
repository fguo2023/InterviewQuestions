package com.littlebee.msb.graph.ds;;

import java.util.*;

public class Graph {
    public Map<Integer, Node> nodes;  // 这样在做的目的是在这个图中，非常方便能找到node根据它的value
    public Set<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
