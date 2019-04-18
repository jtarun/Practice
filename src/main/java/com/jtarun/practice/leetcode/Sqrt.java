package com.jtarun.practice.leetcode;

/** 69
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part
 * of the result is returned.
 */
public class Sqrt {

  private static class Solution {

    public int mySqrt(int x) {
      if (x == 0) {
        return 0;
      }
      int lo = 1, hi = x;

      while (lo < hi) {
        int mid = hi - (hi - lo)/2;

        if ((long)mid * (long)mid <= (long)x) {
          lo = mid;
        } else {
          hi = mid-1;
        }

      }

      return lo;
    }

    public int mySqrt2(int x) {
      if (x == 0) return 0;
      int i = 1;
      for (; i <= x; i++) {
        int sq = i * i;
        if (sq == x) {
          return i;
        } else if ((sq > x) || ((sq / i) != i)){
          return i-1;
        }
      }
      return i;
    }
  }


  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.mySqrt(1));
    System.out.println(sol.mySqrt(4));
    System.out.println(sol.mySqrt(8));
    System.out.println(sol.mySqrt(64));
    System.out.println(sol.mySqrt(Integer.MAX_VALUE));
  }

}
