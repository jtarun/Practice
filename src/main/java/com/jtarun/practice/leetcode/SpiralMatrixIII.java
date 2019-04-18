package com.jtarun.practice.leetcode;

/** 885
 * On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.
 *
 * Here, the north-west corner of the grid is at the first row and column, and the south-east corner of the grid is
 * at the last row and column.
 *
 * Now, we walk in a clockwise spiral shape to visit every position in this grid.
 *
 * Whenever we would move outside the boundary of the grid, we continue our walk outside the grid (but may return to
 * the grid boundary later.)
 *
 * Eventually, we reach all R * C spaces of the grid.
 *
 * Return a list of coordinates representing the positions of the grid in the order they were visited.
 *
 *
 *
 * Example 1:
 *
 * Input: R = 1, C = 4, r0 = 0, c0 = 0
 * Output: [[0,0],[0,1],[0,2],[0,3]]
 */
public class SpiralMatrixIII {

    private static class Solution {
        public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
            int[][] res = new int[R*C][2];
            int top = r0, bottom = r0+1, left = c0;
            int total = R*C;

            int k = 0;
            while (k < total) {
                if (top >= 0) {
                    int j = left;

                    while (j < C) {
                        res[k][0] = top;
                        res[k][1] = j;
                        //System.out.println(res[k][0] + "," + res[k][1]);
                        k++;
                        j++;
                    }
                }

                if (bottom < R) {
                    int j = C-1;

                    while (j >= 0 && j >= left-1) {
                        res[k][0] = bottom;
                        res[k][1] = j;
                        //System.out.println(res[k][0] + "," + res[k][1]);
                        k++;
                        j--;
                    }
                }

                if (left-1 >= 0) {
                    int i = bottom-1;

                    while (i >= 0 && i >= top) {
                        res[k][0] = i;
                        res[k][1] = left-1;
                        //System.out.println(res[k][0] + "," + res[k][1]);
                        k++;
                        i--;
                    }
                }

                bottom = bottom >= R ? R : bottom+1;
                top--;
                left--;
                if (left < 0) left = 0;

            }

            return res;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[][] res = sol.spiralMatrixIII(1,4,0,0);
        //int[][] res = sol.spiralMatrixIII(4, 1,0,0);
        //int[][] res = sol.spiralMatrixIII(5,6,1,4);
        int[][] res = sol.spiralMatrixIII(3,3,0,0);
        for (int[] x : res) {
            System.out.print("[" + x[0] + "," + x[1] + "], ");
        }
    }
}
