package com.jtarun.practice.leetcode;

import java.util.*;

/** 310
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then
 * a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 *
 * Format:
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of
 * undirected edges (each edge is a pair of labels).
 *
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same
 * as [1, 0] and thus will not appear together in edges.
 */
public class MinimumHeightTrees {

    private static class Solution {

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            Map<Integer, Set<Integer>> h = new HashMap<>();
            for (int i = 0; i < n; i++) h.put(i, new HashSet<>());

            for (int[] edge: edges) {
                h.get(edge[0]).add(edge[1]);
                h.get(edge[1]).add(edge[0]);
            }

            List<Integer> leaves = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (h.get(i).size() <= 1) leaves.add(i);
            }

            while (n > 2) {
                List<Integer> newLeaves = new ArrayList<>();
                for (int leaf : leaves) {
                    int j = h.get(leaf).iterator().next();
                    h.get(j).remove(leaf);
                    if (h.get(j).size() == 1) {
                        newLeaves.add(j);
                    }
                }

                n -= leaves.size();
                leaves = newLeaves;
            }

            return leaves;
        }

        // O(n^2) solution, TLE.
        public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
            List<Integer> res = new ArrayList<>();

            Map<Integer, List<Integer>> h = new HashMap<>();
            for (int i = 0; i < n; i++)h.put(i, new ArrayList<>());

            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                h.get(edge[0]).add(edge[1]);
                h.get(edge[1]).add(edge[0]);
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int y = bfs(h, i, min);
                //System.out.println(i + " : " + y);

                if (y == min) {
                    res.add(i);
                } else if (y < min) {
                    res.clear();
                    res.add(i);
                    min = y;
                }
            }

            return res;
        }


        private int bfs(Map<Integer, List<Integer>> tree, Integer root, int maxLevel) {

            Queue<Integer> q = new LinkedList<>();
            int level = -1;
            q.offer(root);
            Set<Integer> visited = new HashSet<>();
            visited.add(root);
            while (!q.isEmpty()) {
                int size = q.size();
                level++;

                if (level > maxLevel) break;

                while (size-- > 0) {
                    for (Integer child :  tree.get(q.poll())) {
                        if (!visited.contains(child)) {
                            q.offer(child);
                            visited.add(child);
                        }
                    }
                }
            }

            return level;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = {{0,1},{0,2},{0,3},{3,4}};
        sol.findMinHeightTrees(5, edges).forEach(x -> System.out.println(x + " "));
    }

}
