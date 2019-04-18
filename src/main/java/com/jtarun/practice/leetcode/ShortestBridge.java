package com.jtarun.practice.leetcode;

import java.util.*;

/** 934
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of
 * 1s not connected to any other 1s.)
 *
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 *
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 *
 * Example 1:
 * Input: [[0,1],[1,0]]
 * Output: 1
 */
public class ShortestBridge {

    private static class Solution {

        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        public int shortestBridge(int[][] A) {
            int m = A.length;
            int n = A[0].length;

            int res = Integer.MAX_VALUE;

            boolean[][] v = new boolean[m][n];
            Queue<int[]> q = new LinkedList<>();
            boolean done = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (A[i][j] == 1) {
                        dfs(A, i, j, m, n, v, q);
                        done = true;
                        break;
                    }

                }
                if (done) break;
            }

            int level = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    int[] t = q.poll();
                    int x1 = t[0], y1 = t[1];

                    for (int[] d : dirs) {

                        int x2 = d[0] + x1;
                        int y2 = d[1] + y1;
                        if (x2 < 0 || y2 < 0 || x2 >= m || y2 >= n || v[x2][y2]) continue;

                        v[x2][y2] = true;
                        if (A[x2][y2] == 1) return level;
                        q.offer(new int[]{x2, y2});
                    }


                }
                level++;
            }

            return level;

        }

        private void dfs(int[][] A, int i, int j, int m, int n, boolean[][] v, Queue<int[]> q) {
            v[i][j] = true;
            q.offer(new int[]{i, j});

            for (int[] d : dirs) {
                int x = d[0] + i;
                int y = d[1] + j;
                if (x < 0 || y < 0 || x >= m || y >= n || v[x][y] || A[x][y] == 0) continue;

                dfs(A, x, y, m, n, v, q);

            }

        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[][] a = {{0,1},{1,0}};
        int[][] a = {{0,1,0},{0,0,0},{0,0,1}};

        int res = sol.shortestBridge(a);
        System.out.println(res);
    }

}
