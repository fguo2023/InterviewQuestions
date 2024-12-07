package com.littlebee.msb.graph;

import com.littlebee.msb.graph.ds.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Graph_BFS {
    public static void bfs(Node start) {
        if (start == null) return;
        Queue<Node> queue= new LinkedList<>();
        Set<Node> set = new HashSet<>(); // Use a set to track visited nodes in order to prevent cycles in the graph.
        queue.add(start);
        set.add(start);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.value);
            for(Node next : current.nexts){
                if(!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }
}
