package com.jtarun.practice.leetcode;

import java.util.*;

/** 695
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded
 * by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 */
public class MaxAreaOfIsland {

    private static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length;
            if (m == 0) return 0;
            int n = grid[0].length;
            if (n == 0) return 0;

            boolean[][] v = new boolean[m][n];
            int res = 0;
            int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0 || v[i][j]) continue;
                    int cnt = 1;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    v[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] t = q.poll();
                        int x1 = t[0], y1 = t[1];

                        for (int[] d : dirs) {
                            int x2 = x1 + d[0];
                            int y2 = y1 + d[1];

                            if(x2 < 0|| y2 < 0 || x2 >= m || y2 >= n || grid[x2][y2] == 0 || v[x2][y2]) continue;

                            cnt++;
                            q.offer(new int[]{x2, y2});
                            v[x2][y2] = true;
                        }

                    }

                    res = Math.max(res, cnt);
                }
            }

            return res;
        }

    }

}
