package com.jtarun.practice.leetcode;

/** 220
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 * absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at
 * most k.
 */
public class ContainsDuplicateIII {

    private static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j - i <= k && j < n; j++) {
                    int diff = Math.abs(nums[i] - nums[j]);
                    if (diff >= 0 && diff <= t) return true;
                }
            }

            return false;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        boolean res = sol.containsNearbyAlmostDuplicate(new int[]{-1,2147483647},1, 2147483647);
        System.out.println(res);
    }
}
