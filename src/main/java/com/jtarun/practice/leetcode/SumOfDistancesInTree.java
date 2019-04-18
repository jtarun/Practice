package com.jtarun.practice.leetcode;

import java.util.*;

/** 834
 * An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.
 *
 * The ith edge connects nodes edges[i][0] and edges[i][1] together.
 *
 * Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.
 */
public class SumOfDistancesInTree {

    private static class Solution {

        public int[] sumOfDistancesInTree(int n, int[][] edges) {
            if (n == 0) return new int[]{};
            if (n == 1) return new int[]{0};

            Map<Integer, List<Integer>> h = new HashMap<>();
            for (int[] edge : edges) {
                h.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                h.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            }

            int[] res = new int[n];
            boolean[] v = new boolean[n];
            int[] count = new int[n];
            helper(h, 0, v, count, res);

            v = new boolean[n];
            childHelper(h, 0, v, count, res);

            return res;
        }

        private void helper(Map<Integer, List<Integer>> h, int i, boolean[] v, int[] count, int[] res) {
            if (v[i] || h.get(i) == null) return;

            v[i] = true;
            count[i] = 1;
            res[i] = 0;
            for (int child : h.get(i)) {
                if (!v[child]) {
                    helper(h, child, v, count, res);
                    count[i] += count[child];
                    res[i] += res[child] + count[child];
                }
            }

        }

        private void childHelper(Map<Integer, List<Integer>> h, int i, boolean[] v, int[] count, int[] res) {
            if (v[i] || h.get(i) == null) return;
            v[i] = true;

            for (int child : h.get(i)) {
                if (v[child]) continue;

                // parent's distance - (child's distance + count[child]) + (n - count[child]) + child's distance.
                res[child] = res[i] - count[child] + (res.length - count[child]);
                childHelper(h, child, v, count, res);
            }
        }

        // TLE
        public int[] sumOfDistancesInTree2(int n, int[][] edges) {
            if (n == 0) return new int[]{};
            Map<Integer, List<Integer>> h = new HashMap<>();
            for (int[] edge : edges) {
                h.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                h.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            }

            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                boolean[] v = new boolean[n];
                int[] sum = new int[1];
                dfs(h, i, 0, v, sum);
                res[i] = sum[0];
            }

            return res;
        }

        private void dfs(Map<Integer, List<Integer>> h, int i, int d, boolean[] v, int[] sum) {
            if ((h.get(i) == null) || v[i]) return;

            sum[0] += d;
            v[i] = true;
            for (int child : h.get(i) ) {
                if (!v[child]) dfs(h, child, d+1, v, sum);
            }

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] res = sol.sumOfDistancesInTree(6, new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}});

        for (int x : res) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

}
