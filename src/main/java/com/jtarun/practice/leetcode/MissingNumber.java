package com.jtarun.practice.leetcode;


/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 */
public class MissingNumber {

  private static class Solution {
    public int missingNumber(int[] nums) {
      int n = nums.length;
      int res = 0;
      for (int i = 0; i < n; i++) {
        res ^= (nums[i] ^ (i+1));
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.missingNumber(new int[]{3,0,1}));
    System.out.println(sol.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
  }

}
