package com.littlebee.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class TwoQueueToImplementStack {
    // create all the public interfaces for stack
    Queue<Integer> queue;
    Queue<Integer> help;

    public TwoQueueToImplementStack() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void add(int num) {
        queue.add(num);
    }

    public int peek() {
        if (queue.isEmpty()) throw new NoSuchElementException();
        while (queue.size() > 1) {
            help.add(queue.poll());
        }
        int ans = queue.poll();
        help.add(ans);
        Queue<Integer> tmp = help;
        help = queue;
        queue = tmp;
        return ans;
    }

    public int poll() {
        if (queue.isEmpty()) throw new NoSuchElementException("stack is empty");
        while (queue.size() > 1) {
            help.add(queue.poll());
        }
        int ans = queue.poll();
        Queue<Integer> tmp = help;
        help = queue;
        queue = tmp;
        return ans;
    }

}
