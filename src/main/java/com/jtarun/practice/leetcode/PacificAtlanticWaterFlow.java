package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 417
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height
 * equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 */
public class PacificAtlanticWaterFlow {

    private static class Solution {
        public List<int[]> pacificAtlantic(int[][] matrix) {
            List<int[]> res = new ArrayList<>();
            int m= matrix.length;
            if (m == 0) return res;
            int n = matrix[0].length;
            if (n == 0) return res;

            int PACIFIC = 1, ATLANTIC = 2, BOTH = PACIFIC | ATLANTIC;
            Queue<int[]> q = new LinkedList<>();

            int[][] v = new int[m][n];
            for (int i = 1; i < m-1; i++) {
                v[i][0] |= PACIFIC;
                v[i][n-1] |= ATLANTIC;
                q.offer(new int[]{i, 0});
                q.offer(new int[]{i, n-1});
            }
            for (int i = 1; i < n-1; i++) {
                v[0][i] |= PACIFIC;
                v[m-1][i] |= ATLANTIC;
                q.offer(new int[]{0, i});
                q.offer(new int[]{m-1, i});
            }

            v[0][0] |= PACIFIC;
            q.offer(new int[]{0,0});

            v[m-1][0] = BOTH;
            q.offer(new int[]{m-1, 0});

            v[0][n-1] = BOTH;
            q.offer(new int[]{0, n-1});

            v[m-1][n-1] |= ATLANTIC;
            q.offer(new int[]{m-1, n-1});

            while (!q.isEmpty()) {
                int[] t = q.poll();
                int x1 = t[0], y1 = t[1];

                for (int[] parent : parents(matrix, x1, y1, m, n)) {
                    int x2 = parent[0], y2 = parent[1];
                    if (v[x2][y2] != BOTH && v[x2][y2] != v[x1][y1]) {
                        v[x2][y2] |= v[x1][y1];
                        q.offer(new int[]{x2, y2});
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (v[i][j] == BOTH) {
                        res.add(new int[]{i, j});
                    }
                }
            }

            return res;
        }

        private int[] xdirs = {0, 1, -1, 0};
        private int[] ydirs = {1, 0, 0, -1};
        private List<int[]> parents(int[][] matrix, int x, int y, int m, int n) {
            List<int[]> res = new ArrayList<>();
            for (int i = 0; i < xdirs.length; i++) {
                int x2 = x + xdirs[i];
                int y2 = y + ydirs[i];

                if (x2 < 0 || y2 < 0 || x2 >= m || y2 >= n || (matrix[x2][y2] < matrix[x][y])) continue;

                res.add(new int[]{x2, y2});

            }

            return res;
        }
    }

}
