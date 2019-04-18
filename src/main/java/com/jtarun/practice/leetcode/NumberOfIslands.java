package com.jtarun.practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/** 200
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 */
public class NumberOfIslands {

    private static class Solution {

        private class Pair {
            int x;
            int y;
            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int numIslands(char[][] grid) {
            int m = grid.length;
            if ( m == 0) return 0;
            int n = grid[0].length;

            boolean[][] v = new boolean[m][n];
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '0' || v[i][j]) continue;

                    res++;
                    Queue<Pair> q = new LinkedList<>();
                    q.offer(new Pair(i, j));
                    v[i][j] = true;
                    while (!q.isEmpty()) {
                        Pair p = q.poll();

                        if ((p.x - 1 >= 0) && !v[p.x-1][p.y] && (grid[p.x-1][p.y] == '1')){
                            v[p.x-1][p.y] = true;
                            q.offer(new Pair(p.x-1, p.y));
                        }
                        if ((p.x +1 < m)   && !v[p.x+1][p.y] && (grid[p.x+1][p.y] == '1')) {
                            v[p.x+1][p.y] = true;
                            q.offer(new Pair(p.x+1, p.y));
                        }
                        if ((p.y - 1 >= 0) && !v[p.x][p.y-1] && (grid[p.x][p.y-1] == '1')) {
                            v[p.x][p.y-1] = true;
                            q.offer(new Pair(p.x, p.y-1));
                        }
                        if ((p.y+1 < n)    && !v[p.x][p.y+1] && (grid[p.x][p.y+1] == '1')){
                            v[p.x][p.y+1] = true;
                            q.offer(new Pair(p.x, p.y+1));
                        }
                    }
                }
            }

            return res;
        }


        public int numIslands2(char[][] grid) {
            int m = grid.length;
            if ( m == 0) return 0;
            int n = grid[0].length;

            boolean[][] v = new boolean[m][n];

            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!v[i][j] && grid[i][j] == '1') {
                        dfs(grid, i, j, m, n, v);
                        cnt++;
                    }
                }
            }

            return cnt;
        }

        private void dfs(char[][] grid, int i, int j, int m, int n, boolean[][] v) {
            if (i < 0 || j < 0 || i >= m || j >= n) return;
            if (grid[i][j] == '0') return;

            if (v[i][j]) return;

            v[i][j] = true;

            dfs(grid, i+1, j, m, n, v);
            dfs(grid, i, j+1, m, n, v);
            dfs(grid, i-1, j, m, n, v);
            dfs(grid, i, j-1, m, n, v);
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] grid = {
                {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
                {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
                {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
                {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
                {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}
        };

        System.out.println(sol.numIslands(grid));
    }

}
