package com.jtarun.practice.leetcode;


// https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary:-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently

/** 371
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 */
public class SumWithoutAddition {
  private static class Solution {
    public int getSum(int a, int b) {
      return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
  }
}
