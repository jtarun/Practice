package com.jtarun.practice.leetcode;

/** 221
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class MaximalSquare {

    private static class Solution {

        // O(m*n)
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            if (m == 0) return 0;
            int n = matrix[0].length;
            if (n == 0) return 0;

            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] != '0') {

                        int top = i > 0 ? matrix[i-1][j] - '0' : 0;
                        int left = j > 0 ? matrix[i][j-1] - '0' : 0;
                        int diag = i > 0 && j > 0 ? matrix[i-1][j-1] - '0' : 0;
                        int val = Math.min(top, Math.min(left, diag)) + 1;
                        matrix[i][j] = (char)(val + '0');
                        max = Math.max(max, val * val);
                    }
                }
            }

            return max;
        }

        // O(m * n * Min(m,n))
        public int maximalSquare2(char[][] matrix) {
            int m = matrix.length;
            if (m == 0) return 0;
            int n = matrix[0].length;
            if (n == 0) return 0;


            char[][][] res = new char[m][n][Math.min(m, n)+1];

            int area = 0;
            for (int l = 1; l <= Math.min(m,n); l++) {
                for (int i = 0; i+l-1 < m; i++) {
                    for (int j = 0; j+l-1 < n; j++) {

                        if (l == 1) {
                            res[i][j][l] = matrix[i][j];
                        } else {

                            if (res[i][j][l-1] == '1' && res[i+1][j+1][l-1] == '1' && matrix[i+l-1][j] == '1' && matrix[i][j+l-1] == '1') {
                                res[i][j][l] = '1';
                            } else {
                                res[i][j][l] = '0';
                            }

                        }

                        if (res[i][j][l] == '1') area = Math.max(area, l*l);
                    }
                }
            }

            return area;

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] mat = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        int res = sol.maximalSquare(mat);
        System.out.println(res);
    }

}
