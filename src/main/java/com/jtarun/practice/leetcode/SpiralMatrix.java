package com.jtarun.practice.leetcode;

import java.util.*;

/** 54
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {

    private static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            int m = matrix.length;
            if (m == 0) return res;
            int n = matrix[0].length;

            int x = 0, y = 0;
            while (m > 0 && n > 0) {
                for (int i = y; i < y+n; i++) res.add(matrix[x][i]);
                for (int i = x+1; i < x + m; i++) res.add(matrix[i][y+n-1]);
                if (m > 1)
                    for (int i = y+n-2; i >= y; i--)res.add(matrix[x+m-1][i]);
                if (n > 1)
                    for (int i = x+m-2; i > x; i--) res.add(matrix[i][y]);
                x++;
                y++;
                m -= 2;
                n -= 2;
            }

            return res;
        }
    }

}
