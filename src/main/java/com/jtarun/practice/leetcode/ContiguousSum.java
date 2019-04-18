package com.jtarun.practice.leetcode;


/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 */
public class ContiguousSum {
  private static class Solution {
    public int maxSubArray(int[] nums) {

      int n = nums.length;

      int cur_sum = 0, max_sum = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        cur_sum = Math.max(nums[i] + cur_sum, nums[i]);
        max_sum = Math.max(cur_sum, max_sum);
      }
      return max_sum;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
  }
}
