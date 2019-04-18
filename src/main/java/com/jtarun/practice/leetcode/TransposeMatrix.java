package com.jtarun.practice.leetcode;

/** 867
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices
 * of the matrix.
 */
public class TransposeMatrix {

    private static class Solution {
        public int[][] transpose(int[][] A) {
            int m = A.length;
            if (m == 0) return A;
            int n = A[0].length;

            int[][] t = new int[n][m];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    t[j][i] = A[i][j];
                }
            }

            return t;
        }
    }

}
