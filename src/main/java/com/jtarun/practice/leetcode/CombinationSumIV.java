package com.jtarun.practice.leetcode;

import java.util.*;

public class CombinationSumIV {

    private static class Solution {

        public int combinationSum4(int[] nums, int target) {
            if (nums.length == 0) return target == 0 ? 1 : 0;

            int[] dp = new int[target+1];
            dp[0] = 1;

            for (int i = 1; i <= target; i++) {
                for (int num: nums) {
                    dp[i] += i-num >= 0 ? dp[i-num] : 0;
                }
            }

            return dp[target];
        }

        public int combinationSum4_2(int[] nums, int target) {
            int[] dp = new int[target+1];
            Arrays.fill(dp, -1);
            dp[0] = 1;
            Arrays.sort(nums);
            return helper(nums, target, dp);
        }

        private int helper(int[] a, int t, int[] dp) {
            if (dp[t] != -1) {
                return dp[t];
            }

            int res = 0;
            for (int i = 0; i < a.length; i++) {
                if (t-a[i] < 0) break;
                res += helper(a, t - a[i], dp);
            }

            dp[t] = res;
            return res;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //int res = sol.combinationSum4(new int[]{1,2,3}, 4);
        int res = sol.combinationSum4(new int[]{1,2}, 10);
        System.out.println(res);
    }

}
