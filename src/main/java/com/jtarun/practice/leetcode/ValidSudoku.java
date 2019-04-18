package com.jtarun.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 36
 */
public class ValidSudoku {
    private static class Solution {
        public boolean isValidSudoku(char[][] b) {
            // validate rows
            Set<Integer> s = new HashSet<>();
            for (int i = 0; i < 9; i++) {

                for (int j = 0; j < 9; j++) {
                    char c = b[i][j];
                    if (c == '.') continue;
                    int d = c - '0';
                    if (!s.add(d)) return false;
                }

                s.clear();
            }

            // validate colums
            for (int j = 0; j < 9; j++) {
                for (int i = 0; i < 9; i++) {
                    char c = b[i][j];
                    if (c == '.') continue;
                    int d = c - '0';
                    if (!s.add(d)) return false;
                }
                s.clear();
            }

            // validate boxes
            for (int i = 0; i < 9; i++) {
                int row = (i / 3) * 3;
                int col = (i * 3) % 9;

                for (int p = row; p < row + 3; p++) {
                    for (int q = col; q < col + 3; q++) {
                        char c = b[p][q];
                        if (c == '.') continue;
                        int d = c - '0';
                        if (!s.add(d)) return false;
                    }
                }
                s.clear();
            }

            return true;
        }
    }
}
