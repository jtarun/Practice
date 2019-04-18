package com.jtarun.practice.leetcode;


import java.util.Arrays;

/** 16
 * Given an array nums of n integers and an integer target, find three integers in nums such that
 * the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {
  private static class Solution {
    public int threeSumClosest(int[] nums, int target) {
      int n = nums.length;
      Arrays.sort(nums);
      int res = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
      for (int i = 0; i < n-2; i++) {

        int j = i+1;
        int k = n-1;
        while (j < k) {
          int sum = nums[i] + nums[j] + nums[k];
          if (Math.abs(sum - target) < min) {
            min = Math.abs(sum - target);
            res = sum;
          }

          if (sum == target) {
            return sum;
          } else if (sum > target){
            k--;
          } else {
            j++;
          }
        }
      }

      return res;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
  }

}
