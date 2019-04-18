package com.jtarun.practice.leetcode;

/** 494
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
 * For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum {

    private static class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int num: nums) sum += num;
            if (S > sum) return 0;

            int target = sum + S;
            if ((target & 0x1) == 1) return 0;
            target = target >>> 1;

            int[] dp = new int[target+1];
            dp[0] = 1;
            for (int num : nums) {
                for (int i = target; i >= num; i--) {
                    dp[i] += dp[i-num];
                }
            }

            return dp[target];
        }


        public int findTargetSumWays2(int[] nums, int S) {
            int n = nums.length;
            if (n == 0) return 0;
            if (S > 1000) return 0;

            int[][][] dp = new int[n+1][2001][2];
            for (int[][] row : dp) {
                for (int[] v : row) {
                    v[0] = -1;
                    v[1] = -1;
                }
            }
            helper(nums, 0, S, dp);
            return dp[0][Math.abs(S)][S > 0 ? 1 : 0];
        }

        private int helper(int[] nums, int i, int S, int[][][] dp) {
            int n = nums.length;
            if (i >= n && S == 0) return 1;
            if (i >= n) return 0;
            int sign = S > 0 ? 1 : 0;
            int absS = Math.abs(S);
            if (dp[i][absS][sign] != -1) return dp[i][absS][sign];

            dp[i][absS][sign] = helper(nums, i+1, S - nums[i], dp) + helper(nums, i+1, S + nums[i], dp);

            return dp[i][absS][sign];
        }

        public int findTargetSumWays3(int[] nums, int S) {
            int n = nums.length;
            if (n == 0) return 0;

            int res = 0;
            int t = 1 << n;
            for (int i = 0; i < t; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    if ((i & (1<<j)) == 0) {
                        sum -= nums[j];
                    } else {
                        sum += nums[j];
                    }
                }
                if (sum == S) res++;
            }

            return res;
        }
    }
}
