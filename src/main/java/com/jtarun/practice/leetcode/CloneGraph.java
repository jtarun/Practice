package com.jtarun.practice.leetcode;

import java.util.*;

public class CloneGraph {


    private static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    private static class Solution {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if (node == null) return null;
            Map<Integer, UndirectedGraphNode> h = new HashMap<>();

            Queue<UndirectedGraphNode> q = new LinkedList<>();
            UndirectedGraphNode cloneRoot = new UndirectedGraphNode(node.label);
            q.add(node);
            h.put(node.label, cloneRoot);

            while (!q.isEmpty()) {
                UndirectedGraphNode t = q.poll();

                UndirectedGraphNode cloneNode = h.get(t.label);
                for ( UndirectedGraphNode child : t.neighbors) {
                    if (!h.containsKey(child.label)) {
                        UndirectedGraphNode cloneChild = new UndirectedGraphNode(child.label);
                        q.offer(child);
                        h.put(child.label, cloneChild);
                    }
                    cloneNode.neighbors.add(h.get(child.label));
                }

            }

            return cloneRoot;
        }
    }

}
