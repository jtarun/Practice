package com.jtarun.practice.leetcode;

import java.util.*;

/** 329
 * Given an integer matrix, find the length of the longest increasing path.
 *
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or
 * move outside of the boundary (i.e. wrap-around is not allowed).
 */
public class LongestIncreasingPathInMatrix {

    private static class Solution {
        int[][] dirs = {{1,0}, {-1, 0}, {0,1}, {0, -1}};

        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length;
            if (m == 0) return 0;
            int n = matrix[0].length;

            int[][] dp = new int[m][n];
            int res = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    res = Math.max(res, dfs(matrix, i, j, m, n, dp));

                }
            }

            return res;
        }

        private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] dp) {
            if (dp[i][j] != 0) return dp[i][j];

            int res = 1;
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if ( x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;

                res = Math.max(res, 1 + dfs(matrix, x, y, m, n, dp));
            }

            return (dp[i][j] = res);
        }

        private static class Node {
            int val;
            int ind;
            List<Node> adj;
            Node(int val, int ind) {
                this.val = val;
                this.ind = ind;
                this.adj = new ArrayList<>();
            }
        }

        public int longestIncreasingPath2(int[][] matrix) {
            int m = matrix.length;
            if (m == 0) return 0;
            int n = matrix[0].length;

            Map<Integer, Node> h = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int ind = ind(i, j, n);
                    h.put(ind, new Node(matrix[i][j], ind));
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int ind = ind(i,j,n);
                    for (Integer neighbour : getNeighbours(i, j, m, n)) {
                        if (h.get(neighbour).val > h.get(ind).val)
                            h.get(neighbour).adj.add(h.get(ind));
                        else h.get(ind).adj.add(h.get(neighbour));
                    }
                }
            }

            List<Node> nodes = new ArrayList<>(h.values());
            Comparator<Node> cmp = (a, b) -> Integer.compare(a.val, b.val);
            Collections.sort(nodes, cmp);

            int[] dp = new int[m*n];
            int max = 1;
            for (int i = 0; i < m*n; i++) {
                Node node = nodes.get(i);
                if ( i == 0) {
                    dp[node.ind] = 1;
                    continue;
                }
                int maxNeighbour = 1;
                for (Node neighbour : node.adj) {
                    if (neighbour.val >= node.val) continue;
                    maxNeighbour = Math.max(maxNeighbour, dp[neighbour.ind] + 1);
                }
                dp[node.ind] = maxNeighbour;
                max = Math.max(dp[node.ind], max);
            }

            return max;
        }

        private List<Integer> getNeighbours(int i, int j, int m, int n) {

            List<Integer> res = new ArrayList<>();
            if (isValid(i-1, j, m, n)) res.add(ind(i-1,j,n));
            if (isValid(i+1, j, m, n)) res.add(ind(i+1,j,n));
            if (isValid(i, j-1, m, n)) res.add(ind(i,j-1,n));
            if (isValid(i, j+1, m, n)) res.add(ind(i,j+1,n));

            return res;
        }

        private boolean isValid(int i, int j, int m, int n ) {
            return (i >= 0 && j >= 0 && i < m && j < n);
        }

        private int ind(int i, int j, int n) {
            return i * n + j;
        }
    }

}
