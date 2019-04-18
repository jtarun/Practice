package com.jtarun.practice.leetcode;

/** 63
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 */
public class UniquePaths {

    private static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            if (m == 0) return 0;
            int n = obstacleGrid[0].length;
            if (n== 0) return 0;
            if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;


            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else if (obstacleGrid[i][j] == 0){
                        int top = i > 0 ? dp[i-1][j] : 0;
                        int left = j > 0 ? dp[i][j-1] : 0;
                        dp[i][j] = top + left;
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }

}
