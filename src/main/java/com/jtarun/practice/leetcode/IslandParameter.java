package com.jtarun.practice.leetcode;

/** 463
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 *
 *
 * Example:
 *
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 *
 */
public class IslandParameter {

    private static class Solution {
        public int islandPerimeter(int[][] grid) {
            int res = 0;
            int m = grid.length;
            if (m == 0) return 0;
            int n = grid[0].length;

            int[][] dirs = {{1,0}, {0,1}, {0,-1}, {-1, 0}};

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 1) continue;
                    int cnt = 4;
                    for (int[] d : dirs) {

                        int x = d[0] + i;
                        int y = d[1] + j;

                        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1) continue;
                        cnt--;
                    }
                    res += cnt;
                }
            }

            return res;
        }
    }

}
