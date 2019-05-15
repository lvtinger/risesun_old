package org.risesun.data.test;

import org.junit.Test;
import org.risesun.data.core.source.Node;
import org.risesun.data.core.source.WeightRoundRobin;

import java.util.LinkedList;
import java.util.List;

public class TestWeightRoundRobin {
    @Test
    public void test(){
        List<Node<String>> nodes = new LinkedList<>();
        nodes.add(new Node<>("a", 4));
        nodes.add(new Node<>("b", 2));
        nodes.add(new Node<>("c", 1));

        WeightRoundRobin<String> roundRobin = new WeightRoundRobin<>(nodes);

        for (int i = 0; i < 7; i++) {
            System.out.println(roundRobin.roundRobin());
        }
        if (roundRobin.remove("a")) {
            System.out.println("remove element of [a] success!!!");
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(roundRobin.roundRobin());
        }
        if (roundRobin.attach("d", 3)) {
            System.out.println("attach element of [d] success!!!");
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(roundRobin.roundRobin());
        }
    }
}
