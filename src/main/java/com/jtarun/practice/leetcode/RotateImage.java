package com.jtarun.practice.leetcode;

/** 48
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {

    private static class Solution {
        public void rotate(int[][] matrix) {
            int x = 0, y = 0;
            int n = matrix.length;
            if (n == 0) return;

            while (n > 1) {
                for (int i = 0; i < n-1; i++) {
                    int a = matrix[x][y+i];
                    int b = matrix[x+i][y+n-1];
                    int c = matrix[x+n-1][y+n-1-i];
                    int d = matrix[x+n-1-i][y];

                    matrix[x+i][y+n-1] = a;
                    matrix[x+n-1][y+n-1-i] = b;
                    matrix[x+n-1-i][y] = c;
                    matrix[x][y+i] = d;
                }
                x++;
                y++;
                n -= 2;
            }

        }
    }

}
