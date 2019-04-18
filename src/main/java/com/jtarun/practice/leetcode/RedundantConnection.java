package com.jtarun.practice.leetcode;

import java.util.*;

/** 684
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one
 * additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge
 * that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v,
 * that represents an undirected edge connecting nodes u and v.
 *
 * Return an edge that can be removed so that the resulting graph   is a tree of N nodes. If there are multiple answers,
 * return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format,
 * with u < v.
 */
public class RedundantConnection {

    private static class Solution {

        public int[] findRedundantConnection(int[][] edges) {
            UF uf = new UF(edges.length+1);
            for (int[] edge : edges) {
                uf.union(edge[0], edge[1]);
                if (uf.cycle()) return edge;
            }
            return new int[2];
        }

        private class UF {
            int[] parent;
            boolean cycle;
            UF(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            void union(int i, int j) {
                int p1 = find(i);
                int p2 = find(j);
                if (p1 != p2) {
                    parent[p1] = p2;
                } else {
                    cycle = true;
                }
            }

            boolean cycle() {
                return cycle;
            }

            int find(int i) {
                while (i != parent[i]) {
                    i = parent[i];
                }
                return i;
            }
        }


        public int[] findRedundantConnection2(int[][] edges) {
            int n = edges.length;
            Map<Integer, List<Integer>> h = new HashMap<>();
            for (int[] edge : edges) {
                h.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                h.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            }

            int[] out = new int[n+1];
            List<Integer> leaves = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                out[i] = h.get(i).size();
                if (out[i] <= 1) {
                    leaves.add(i);
                }
            }

            Set<Integer> processed = new HashSet<>();
            int left = n;
            while (left > 0 && leaves.size() != 0) {
                left -= leaves.size();
                processed.addAll(leaves);
                List<Integer> newLeaves = new ArrayList<>();
                for (int leaf : leaves) {
                    for (int parent : h.get(leaf)) {
                        if (!processed.contains(parent)) {
                            out[parent]--;
                            if (out[parent] <= 1) {
                                newLeaves.add(parent);
                            }
                        }
                    }
                }
                leaves = newLeaves;
            }

            Set<Integer> circleNodes = new HashSet<>();
            for (int i = 1; i <= n; i++) if (!processed.contains(i)) circleNodes.add(i);

            int[] res = new int[2];
            for (int i = n-1; i >= 0; i--) {
                int[] edge = edges[i];

                if (circleNodes.contains(edge[0]) && circleNodes.contains(edge[1])) {
                    res = edge;
                    break;
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = {{1,3},{3,4},{1,5},{3,5},{2,3}};

        int[] res = sol.findRedundantConnection(edges);
        System.out.println(res[0] + ", " + res[1]);
    }

}
