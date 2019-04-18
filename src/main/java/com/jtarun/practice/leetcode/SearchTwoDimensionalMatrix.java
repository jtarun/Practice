package com.jtarun.practice.leetcode;

/** 74
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class SearchTwoDimensionalMatrix {

    private static class Solution {

        /* Note: This would fail if m * n overflows. Alternate solution is to search in first col and then search in
         the row found. */
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            if ( m == 0) return false;
            int n = matrix[0].length;

            int lo = 0, hi = m*n -1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;

                int i = mid / n;
                int j = mid % n;

                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            return false;
        }
    }

}
