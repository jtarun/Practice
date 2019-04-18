package com.jtarun.practice.leetcode;

import java.util.*;

/** 802
 * In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.
 * If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.
 *
 * Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.
 * More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at
 * a terminal node in less than K steps.
 *
 * Which nodes are eventually safe?  Return them as an array in sorted order.
 *
 * The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in
 * the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.
 */
public class FindEventualSafeStates {

    private static class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            List<Integer> res = new ArrayList<>();

            if (n == 0) return res;

            int[] out = new int[n];
            List<Integer> leaves = new ArrayList<>();
            Map<Integer, List<Integer>> parents = new HashMap<>();
            for (int i = 0; i < n; i++) {
                out[i] = graph[i].length;
                if (out[i] == 0) leaves.add(i);
                for (int x : graph[i]) {
                    parents.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
                }
            }

            while (n > 0 && leaves.size() > 0) {
                n -= leaves.size();
                res.addAll(leaves);

                List<Integer> newLeaves = new ArrayList<>();
                for (int leaf : leaves) {
                    if (parents.get(leaf) == null) continue;
                    for (int parent : parents.get(leaf)) {
                        out[parent]--;
                        if (out[parent] == 0) {
                            newLeaves.add(parent);
                        }
                    }
                }
                leaves = newLeaves;
            }

            Collections.sort(res);

            return res;
        }
    }

}
