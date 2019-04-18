package com.jtarun.practice.leetcode;

/** 892
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 *
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 *
 * Return the total surface area of the resulting shapes.
 *
 *
 *
 * Example 1:
 *
 * Input: [[2]]
 * Output: 10
 * Example 2:
 *
 * Input: [[1,2],[3,4]]
 * Output: 34
 */
public class SurfaceAreaOf3DShapes {

    private static class Solution {
        public int surfaceArea(int[][] grid) {
            int  n = grid.length;
            if (n == 0) return 0;

            int res = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int x = grid[i][j];
                    if (x == 0) continue;

                    int top = i-1 >= 0 ? grid[i-1][j] : 0;
                    int left = j-1 >= 0 ? grid[i][j-1] : 0;
                    int right = j+1 < n ? grid[i][j+1] : 0;
                    int bottom = i+1 < n ? grid[i+1][j] : 0;

                    if (x > top) res += x - top;
                    if (x > bottom) res += x - bottom;
                    if (x > left) res += x - left;
                    if (x > right) res += x - right;

                    res += 2;

                }
            }

            return res;

        }
    }

}
