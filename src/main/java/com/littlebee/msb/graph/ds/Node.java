package com.littlebee.msb.graph.ds;

import java.util.ArrayList;

/**
 * How to define the graph's node, this is very important
 *
 */
public class Node {
    // 图分成有向图和无向图，图的遍历也分成了bfs和dfs  e.g. 4->5->6, current node is 5, so in is 1 and to is 1
    public int value;
    public int in; // 入度的数量 number of in-degree
    public int out; // 出度的数量 number of out-degree
    public ArrayList<Node> nexts; // neighbors e.g. neighbors are the 6
    public ArrayList<Edge> edges; // edges has 4,5 and 5,6

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
