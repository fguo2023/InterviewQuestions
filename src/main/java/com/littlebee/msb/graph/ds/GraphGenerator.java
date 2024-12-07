package com.littlebee.msb.graph.ds;

/*
  matrix 所有的边
  N * 3
  [weight, from (value) of the node, to (value) of the node] // 一般图的题目都是这么给你的
  [5,1,2] mean from node 1 to node 2, the weight of the edge is 5
 */
public class GraphGenerator {
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        // iterate through the total number of row from the matrix
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            // 如何知道哪些东西需要加上？
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
