package com.jtarun.practice.leetcode;

import java.util.Arrays;

/** 698
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into
 * k non-empty subsets whose sums are all equal.
 */
public class PartitionIntoKEqualSubsets {

    private static class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (k == 1) return true;
            int sum = 0;
            for (int n : nums) sum += n;

            if (sum % k != 0) return false;

            sum /= k;
            Arrays.sort(nums);

            if (nums[nums.length-1] > sum) return false;

            return dfs(nums, sum, new int[k], nums.length-1);
        }

        private boolean dfs(int[] nums, int target, int[] sum, int ind) {
            if (ind == -1) {
                for (int n : sum) if (n != target) return false;
                return true;
            }

            int v = nums[ind];
            for (int k = 0; k < sum.length; k++) {
                if (sum[k] + v > target) continue;

                sum[k] += v;
                if (dfs(nums, target, sum, ind-1)) return true;
                sum[k] -= v;
            }

            return false;
        }
    }

}
