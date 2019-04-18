package com.jtarun.practice.leetcode;

/** 486
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the
 * array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not
 * be available for the next player. This continues until all the scores have been chosen. The player with the maximum
 * score wins.
 *
 * Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his
 * score.
 */
public class PredictTheWinner {

    private static class Solution {

        public boolean PredictTheWinner(int[] nums) {
            int n = nums.length;
            if (n <= 2) return true;

            int[][] dp = new int[n][n]; //how much can first-to-move player make over other player.
            for (int i = 0; i < n; i++) dp[i][i] = nums[i];

            for (int l = 2; l <= n; l++) {
                for (int i = 0; i+l-1 < n; i++) {
                    int j = i+l-1;

                    dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);

                }
            }

            return dp[0][n-1] >= 0;
        }

        public boolean PredictTheWinner2(int[] nums) {
            int n = nums.length;
            if (n <= 2) return true;

            int[][] dp = new int[n][n];

            for (int i = 0; i < n; i++) dp[i][i] = nums[i];
            for (int l = 2; l <= n; l++) {

                for (int i = 0; i+l-1 < n; i++) {
                    int j = i+l-1;

                    int a = i+1 < n && j-1 >= 0 ? dp[i+1][j-1] : 0;
                    int b = i+2 < n ? dp[i+2][j] : 0;
                    int c = j-2 >= 0 ? dp[i][j-2] : 0;

                    dp[i][j] = Math.max(nums[i] + Math.min(a, b), nums[j] + Math.min(a, c));

                }

            }

            int max = dp[0][n-1], sum = 0;
            for (int num : nums) sum += num;

            return max >= sum-max;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.PredictTheWinner(new int[]{1,5,2}));
    }

}
