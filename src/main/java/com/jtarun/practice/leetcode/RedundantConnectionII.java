package com.jtarun.practice.leetcode;

import java.util.*;

public class RedundantConnectionII {
    private static class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            Map<Integer, List<Integer>> h = new HashMap<>();
            Map<Integer, List<Integer>> parents = new HashMap<>();
            Integer twoParentNode = null;
            for (int[] edge : edges) {

                h.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                parents.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);

                if (parents.get(edge[1]).size() > 1) {
                    twoParentNode = edge[1];
                }
            }

            Set<Integer> cycleNodes = cycleNodes(edges.length, h, parents);
            boolean cycle = cycleNodes.size() > 0;

            if (twoParentNode == null) {
                // return the last edge that leads to cycle
                for (int i = edges.length - 1; i >= 0; i--) {
                    int[] edge = edges[i];
                    if (cycleNodes.contains(edge[0]) && cycleNodes.contains(edge[1])) return edge;
                }
            }

            if (!cycle) {
                for (int i = edges.length-1; i >= 0; i--) {
                    int[] edge = edges[i];
                    if (edge[1] == twoParentNode) return edge;
                }
            }

            for (int i = edges.length-1; i>= 0; i--) {
                int[] edge = edges[i];
                if (edge[1] == twoParentNode && cycleNodes.contains(edge[0])){
                    return edge;
                }
            }

            return new int[2];
        }

        Set<Integer> cycleNodes(int n, Map<Integer, List<Integer>> h, Map<Integer, List<Integer>> parents) {
            Set<Integer> res = new HashSet<>();
            int[] color = new int[n+1];
            int[] child = new int[n+1];
            helper(h, color, child, 1, res);
            return res;
        }

        void helper(Map<Integer, List<Integer>> h, int[] color, int[] childPtr, int i, Set<Integer> res) {
            if (i >= color.length) return;

            if (h.get(i) == null) {
                color[i] = 2;
                return;
            }

            color[i] = 1;
            for (int child : h.get(i)) {
                if (color[child] == 0) {
                    color[child] = 1;
                    childPtr[i] = child;
                    helper(h, color, childPtr, child, res);
                } else if (color[child] == 1) {
                    // cycle is detected.
                    if (res.isEmpty()) {
                        childPtr[i] = child;
                        while (!res.contains(i)) {
                            res.add(i);
                            i = childPtr[i];
                        }
                    }
                }
            }

            color[i] = 2;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = {{2,1},{3,1},{4,2},{1,4}};
        int[] ans = sol.findRedundantDirectedConnection(edges);
        System.out.println(ans[0] + ", " + ans[1]);
    }


}
