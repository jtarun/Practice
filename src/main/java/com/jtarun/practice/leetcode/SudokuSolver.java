package com.jtarun.practice.leetcode;

/** 37
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 */
public class SudokuSolver {

    private static class Solution {
        public void solveSudoku(char[][] b) {
            helper(b, 0);
        }

        private boolean helper(char[][] b, int ind) {
            if (ind >= 81) return true;

            int r = ind / 9;
            int c = ind % 9;
            if (b[r][c] != '.') return helper(b, ind+1);

            for (int i = 1; i <= 9; i++) {
                if (valid(b, r, c, i)) {
                    b[r][c] = (char)('0' + i);
                    if (helper(b, ind+1)) return true;
                    b[r][c] = '.';
                }
            }

            return false;
        }

        private boolean valid(char[][] b, int r, int c, int n) {
            char num = (char)('0' + n);
            for (int i = 0; i < 9; i++) {
                if (b[r][i] == num) return false;
            }

            for (int i = 0; i < 9; i++) {
                if (b[i][c] == num) return false;
            }

            int x = r - r%3;
            int y = c - c%3;

            for (int i = x; i < x+3; i++) {
                for (int j = y; j < y+3; j++) {
                    if (b[i][j] == num) return false;
                }
            }

            return true;
        }
    }

}
