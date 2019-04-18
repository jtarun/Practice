package com.jtarun.practice.leetcode;

/* 231
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {
  private static class Solution {
    public boolean isPowerOfTwo(int n) {
      if (n <= 0) return false;
      return (n & (n-1)) == 0;
    }
  }
}
