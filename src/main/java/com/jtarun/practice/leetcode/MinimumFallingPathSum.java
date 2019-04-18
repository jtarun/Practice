package com.jtarun.practice.leetcode;

/** 931
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 *
 * A falling path starts at any element in the first row, and chooses one element from each row.
 * The next row's choice must be in a column that is different from the previous row's column by at most one.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 * Explanation:
 * The possible falling paths are:
 */
public class MinimumFallingPathSum {

    private static class Solution {
        public int minFallingPathSum(int[][] A) {
            int n = A.length;
            int[][] dp = new int[n][n];

            for (int i = 0; i < n; i++) {
                dp[n-1][i] = A[n-1][i];
            }

            for (int i = n-2; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    int left = (j-1 >= 0) ? dp[i+1][j-1] : Integer.MAX_VALUE;
                    int right = (j+1 < n) ? dp[i+1][j+1] : Integer.MAX_VALUE;
                    int center = dp[i+1][j];

                    dp[i][j] = Math.min(center, Math.min(left, right)) + A[i][j];
                }
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) res = Math.min(res, dp[0][i]);

            return res;
        }
    }

    private static void print(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] a =  {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(sol.minFallingPathSum(a));
    }

}
