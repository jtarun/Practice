package com.jtarun.practice.leetcode;

/** 566
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one
 * with different size but keep its original data.
 *
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing
 * the row number and column number of the wanted reshaped matrix, respectively.
 *
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing
 * order as they were.
 *
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix;
 * Otherwise, output the original matrix.
 *
 * Example 1:
 * Input:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using
 * the previous list.
 */
public class ReshapeTheMatrix {

    private static class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int m = nums.length;
            if (m == 0) return nums;
            int n = nums[0].length;
            if (n == 0) return nums;

            if (m*n != r*c) return nums;

            int[][] res = new int[r][c];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    int ind = i*n + j;
                    int x = ind / c;
                    int y = ind % c;
                    res[x][y] = nums[i][j];

                }
            }

            return res;
        }
    }

}
