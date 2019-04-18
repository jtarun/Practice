package com.jtarun.practice.leetcode;

/** 52
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack
 * each other.
 */
public class NQueensII {

    private static class Solution {
        public int totalNQueens(int n) {
            int[][] b = new int[n][n];
            int[] res = new int[1];
            helper(b, 0, n, res);
            return res[0];
        }

        private void helper(int[][] b, int c, int n, int[] res) {
            if (c == n) {
                res[0]++;
                return;
            }

            for (int r = 0; r < n; r++) {
                if (valid(b, r, c, n)) {
                    b[r][c] = 1;
                    helper(b, c+1, n, res);
                    b[r][c] = 0;
                }
            }
        }

        private boolean valid(int[][] b, int r, int c, int n) {
            if (c == 0) return true;

            for (int i = 0; i < c; i++) {
                if (b[r][i] == 1) return false;
            }

            int x = r-1, y = c-1;
            while (x >= 0 && y >= 0) {
                if (b[x--][y--] == 1) return false;
            }

            x = r+1;
            y = c-1;
            while (x < n && y >= 0) {
                if (b[x++][y--] == 1) return false;
            }

            return true;
        }
    }
}
