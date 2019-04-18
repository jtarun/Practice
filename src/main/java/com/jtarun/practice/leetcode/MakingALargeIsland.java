package com.jtarun.practice.leetcode;

import java.util.*;

/** 827
 * In a 2D grid of 0s and 1s, we change at most one 0 to a 1.
 *
 * After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).
 */
public class MakingALargeIsland {

    private static class Solution {
        public int largestIsland(int[][] grid) {
            int m = grid.length;
            if (m == 0) return 0;
            int n = grid[0].length;
            if (n == 0) return 0;

            UF uf = new UF(m * n);
            boolean[][] v = new boolean[m][n];
            Map<Integer, Integer> rootCount = new HashMap<>();
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if ((grid[i][j] == 1) && !v[i][j]) {
                        int[] cnt = new int[]{1};
                        dfs(grid, i, j, m, n, v, uf, cnt);
                        rootCount.put(uf.find(index(i, j, n)), cnt[0]);
                        res = Math.max(res, cnt[0]);
                    }
                }
            }
            if (res == m*n) return res;
            res++;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) continue;

                    Set<Integer> roots = new HashSet<>();
                    for (int t = 0; t < xdirs.length; t++) {
                         int x2 = i + xdirs[t];
                         int y2 = j + ydirs[t];

                         if (x2 < 0 || y2 < 0 || x2 >= m || y2 >= n || grid[x2][y2] == 0) continue;

                         roots.add(uf.find(index(x2, y2, n)));

                    }

                    if (roots.size() <= 1) continue;

                    int total = 1;
                    for (int root : roots) {
                        total += rootCount.get(root);
                    }
                    res = Math.max(res, total);
                }
            }

            return res;
        }

        private int[] xdirs = {0, 1, -1, 0};
        private int[] ydirs = {1, 0, 0, -1};
        private void dfs(int[][] grid, int i, int j, int m, int n, boolean[][] v, UF uf, int[] cnt) {

            v[i][j] = true;

            for (int p = 0; p < xdirs.length; p++) {
                int x2 = i + xdirs[p];
                int y2 = j + ydirs[p];
                if (x2 < 0 || y2 < 0 || x2 >= m || y2 >= n || v[x2][y2] || grid[x2][y2] == 0) continue;

                cnt[0]++;
                uf.union(index(i, j, n), index(x2, y2, n));
                dfs(grid, x2, y2, m, n, v, uf, cnt);
            }
        }

        private int index(int x, int y, int n) {
            return x * n + y;
        }

        private class UF {
            int[] parent;
            UF(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) parent[i] = i;
            }

            void union(int i, int j) {
                int x = find(i);
                int y = find(j);
                if (x != y) parent[x] = y;
            }

            int find(int i) {
                while (i != parent[i]) {
                    i = parent[i];
                }
                return i;
            }
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {{1,0}, {0,1}};
        int res = sol.largestIsland(grid);
        System.out.println(res);
    }
}
