package com.jtarun.practice.leetcode;

/** 130
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 */
public class SurroundedRegions {

    private static class Solution {
        public void solve(char[][] board) {
            int m = board.length;
            if (m == 0) return;
            int n = board[0].length;

            boolean[][] v = new boolean[m][n];
            for (int i = 0; i < n; i++) {
                if (board[0][i] == 'O' && !v[0][i])
                    dfs(board, 0, i, m, n, v);
            }

            for (int i = 0; i < m; i++) {
                if (board[i][n-1] == 'O' && !v[i][n-1])
                    dfs(board, i, n-1, m, n, v);
            }

            for (int i = 0; i < n; i++) {
                if (board[m-1][i] == 'O' && !v[m-1][i])
                    dfs(board, m-1, i, m, n, v);
            }

            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O' && !v[i][0])
                    dfs(board, i, 0, m, n, v);
            }

            for (int i = 1; i < m-1; i++) {
                for (int j = 1; j < n-1; j++) {
                    if (board[i][j] == 'O' && !v[i][j]) board[i][j] = 'X';
                }
            }
        }

        private void dfs(char[][] board, int i, int j, int m, int n, boolean[][] v) {
            if (i < 0 || j < 0 || i >= m || j >= n || v[i][j] || (board[i][j] == 'X')) return;

            v[i][j] = true;

            dfs(board, i+1, j, m, n, v);
            dfs(board, i-1, j, m, n, v);
            dfs(board, i, j+1, m, n, v);
            dfs(board, i, j-1, m, n, v);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] board = {
                {'X','O','O','X','X','X','O','X','O','O'},
                {'X','O','X','X','X','X','X','X','X','X'},
                {'X','X','X','X','O','X','X','X','X','X'},
                {'X','O','X','X','X','O','X','X','X','O'},
                {'O','X','X','X','O','X','O','X','O','X'},
                {'X','X','O','X','X','O','O','X','X','X'},
                {'O','X','X','O','O','X','O','X','X','O'},
                {'O','X','X','X','X','X','O','X','X','X'},
                {'X','O','O','X','X','O','X','X','O','O'},
                {'X','X','X','O','O','X','O','X','X','O'}
        };

        print(board);
        sol.solve(board);
        print(board);

    }

    private static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
    }
}
