package org.risesun.data.core.source;

import lombok.Getter;

/** @param <T> */
@Getter
public class Node<T> implements Comparable<Node<T>> {
    private T node;
    private int defaultWeight;
    private int currentWeight;

    public Node(T node, int weight) {
        if (null == node) {
            throw new IllegalArgumentException("node is required");
        }

        if (0 >= weight) {
            throw new IllegalArgumentException("weight must be more then zero");
        }

        this.node = node;
        this.defaultWeight = weight;
    }

    void before() {
        currentWeight += defaultWeight;
    }

    void after(int totalWeight) {
        currentWeight -= totalWeight;
    }

    void reload(){
        this.currentWeight = 0;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Node && this.node.equals(((Node) obj).node);
    }

    @Override
    public int compareTo(Node<T> o) {
        if (o == null) {
            return 1;
        }

        return this.currentWeight - o.currentWeight;
    }
}