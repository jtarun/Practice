package com.jtarun.practice.leetcode;

/** 766
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 *
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 *
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * Output: True
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 */
public class ToeplitzMatrix {

    private static class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            for (int c = 0; c < n-1; c++) {
                int pivot = matrix[0][c];

                int x=1, y = c+1;
                while (x < m && y < n) {
                    if (matrix[x++][y++] != pivot) return false;
                }

            }

            for (int r = 1; r < m-1; r++) {
                int pivot = matrix[r][0];

                int x = r+1, y = 1;
                while (x < m && y < n) {
                    if (matrix[x++][y++] != pivot) return false;
                }
            }


            return true;
        }
    }

}
