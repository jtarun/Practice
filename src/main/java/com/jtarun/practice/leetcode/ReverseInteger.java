package com.jtarun.practice.leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed
 * integer range: [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 *
 */
public class ReverseInteger {

  private static class Solution {
    public int reverse(int x) {
      int sign = x < 0 ? -1 : 1;
      int res = 0;

      x = Math.abs(x);
      int prev;
      while (x != 0) {
        prev = res;
        int d = x % 10;
        x = x / 10;
        res = res * 10 + d;

        if ((res - d) / 10 != prev) {
          return 0;
        }
      }

      return res * sign;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.reverse(123));
    System.out.println(sol.reverse(-123));
    System.out.println(sol.reverse(120));
    System.out.println(sol.reverse(0));
    System.out.println(sol.reverse(1534236469));
  }

}
