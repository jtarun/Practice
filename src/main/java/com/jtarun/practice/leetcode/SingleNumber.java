package com.jtarun.practice.leetcode;


/**
 * 136
 * Given a non-empty array of integers, every element appears twice except for one.
 * Find that single one.
 */
public class SingleNumber {
  private static class Solution {
    public int singleNumber(int[] nums) {
      int res = 0;
      for (int i = 0; i < nums.length; i++) {
        res ^= nums[i];
      }
      return res;
    }
  }
}
