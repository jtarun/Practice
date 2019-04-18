package com.jtarun.practice.leetcode;

/** 416
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 */
public class CanPartitionArrayIntoEqualSubsets {
    private static class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int n : nums) sum += n;
            if ((sum & 0x1) == 1) return false;
            int target = sum >>> 1;

            boolean[] dp = new boolean[target+1];
            dp[0] = true;
            for (int n : nums) {
                for (int i = target; i >= n; i--) {
                    dp[i] = dp[i] || dp[i-n];
                }
            }

            return dp[target];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100
        };
        boolean res = sol.canPartition(nums);
        System.out.println(res);
    }

}
