package com.jtarun.practice.leetcode;

import java.util.*;

/** 51
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack
 * each other.
 */
public class NQueens {

    private static class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            char[][] board = new char[n][n];
            for (char[] row : board) {
                Arrays.fill(row, '.');
            }
            helper(board, 0, n, res);
            return res;
        }

        private void helper(char[][] board, int c, int n, List<List<String>> res) {
            if (c == n) {
                List<String> sol = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        sb.append(board[i][j]);
                    }
                    sol.add(sb.toString());
                }
                res.add(sol);
                return;
            }

            for (int r = 0; r < n; r++) {
                if (valid(board, r, c, n)) {
                    board[r][c] = 'Q';
                    helper(board, c+1, n, res);
                    board[r][c] = '.';
                }
            }

        }

        private boolean valid(char[][] board, int r, int c, int n){
            if (c == 0) return true;

            for (int i = 0; i < c; i++) {
                if (board[r][i] == 'Q') return false;
            }

            int x = r-1, y = c-1;
            while (x >= 0 && y >= 0) {
                if (board[x][y] == 'Q') return false;
                x--;
                y--;
            }

            x = r+1; y = c-1;
            while (y >= 0 && x < n) {
                if (board[x][y] == 'Q') return false;
                x++;
                y--;
            }

            return true;
        }

    }

}
