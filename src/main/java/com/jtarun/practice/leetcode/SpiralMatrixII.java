package com.jtarun.practice.leetcode;

/** 59
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 */
public class SpiralMatrixII {

    private static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];

            int x = 0, y = 0, next = 0;
            while (n > 0) {
                for (int i = y; i < y+n; i++) res[x][i] = ++next;
                if (n == 1) break;
                for (int i = x+1; i < x+n; i++) res[i][y+n-1] = ++next;
                for (int i = y+n-2; i >= y; i--) res[x+n-1][i] = ++next;
                for (int i = x+n-2; i>x; i--) res[i][y] = ++next;

                x++;
                y++;
                n-=2;
            }

            return res;
        }
    }

}
