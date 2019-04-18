package com.jtarun.practice.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/** 785
 * Given an undirected graph, return true if and only if it is bipartite.
 *
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that
 * every edge in the graph has one node in A and another node in B.
 *
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes
 * i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or
 * parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 */
public class IsGraphBipartite {

    private static class Solution {
        public boolean isBipartite(int[][] graph) {
            int m = graph.length;
            if (m == 0) return true;

            Set<Integer> left = new HashSet<>();
            Set<Integer> right = new HashSet<>();

            for (int i = 0; i < graph.length; i++) {
                if (left.contains(i) || right.contains(i) || (graph[i].length == 0)) continue;

                Queue<Integer> q = new LinkedList<>();

                q.offer(i);
                left.add(i);

                boolean odd = true;

                while (!q.isEmpty()) {
                    int size = q.size();
                    while (size-- > 0) {
                        int t = q.poll();

                        for (int child : graph[t]) {
                            if (odd) {
                                if (left.contains(child)) return false;
                                if (right.add(child)) {
                                    q.offer(child);
                                }
                            } else {
                                if (right.contains(child)) return false;
                                if (left.add(child)) {
                                    q.offer(child);
                                }
                            }
                        }
                    }
                    odd = (odd == false);
                }
            }

            return true;
        }
    }

}
