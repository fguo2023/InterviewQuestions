package com.littlebee.msb.graph;

import com.littlebee.msb.graph.ds.Node;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Graph_DFS {
    public static void dfs(Node node) {
        if (node == null) return;
        Stack<Node> stack = new Stack<Node>();
        Set<Node> set = new HashSet<Node>(); // same as bfs, to prevent node from visiting multiple times and forming a cycle
        stack.push(node);
        set.add(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts){
                if (!set.contains(next)) {
                    stack.push(cur); // the push order here is very important, cur must be pushed ahead of next, 这里要好好理解push的顺序，才能保证算法的正确性
                    stack.push(next);
                    set.add(next); // not add the cur
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
