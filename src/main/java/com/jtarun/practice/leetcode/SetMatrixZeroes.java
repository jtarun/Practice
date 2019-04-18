package com.jtarun.practice.leetcode;


/** 73
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 */
public class SetMatrixZeroes {

    private static class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            if (m == 0) return;
            int n = matrix[0].length;


            boolean firstRow = false;
            boolean firstCol = false;

            for (int i = 0; i < n; i++) {
                if (matrix[0][i] == 0) firstRow = true;
            }

            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) firstCol = true;
            }

            if (matrix[0][0] == 0) {
                firstCol = true;
                firstRow = true;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }

            for (int i = 1; i < m; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0) {
                    for (int i = 0; i < m; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (firstCol) {
                for (int i = 0; i < m; i++) matrix[i][0] = 0;
            }

            if (firstRow) {
                for (int i = 0; i < n; i++) matrix[0][i] = 0;
            }
        }
    }

}
