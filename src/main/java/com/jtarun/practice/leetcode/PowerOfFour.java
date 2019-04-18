package com.jtarun.practice.leetcode;

/* 342
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 */
public class PowerOfFour {
  private static class Solution {
    public boolean isPowerOfFour(int n) {
      return ((n&(n-1)) == 0) && ((n & 0x55555555) != 0);
    }
  }
}
