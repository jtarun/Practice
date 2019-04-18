package com.jtarun.practice.leetcode;

/*
 * 367
 * Given a positive integer num, write a function which returns True if num is a perfect square
 * else False.
 */
public class PerfectSquare {
  private static class Solution {
    public boolean isPerfectSquare(int num) {
      if (num <= 3) {
        return num == 1;
      }

      int lo = 2, hi = num/2;
      while ( lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        long sq = (long)mid * (long)mid;

        if (sq == num) {
          return true;
        } else if (sq < num) {
          lo = mid+1;
        } else {
          hi = mid-1;
        }
      }

      return false;
    }

  }


  public static void main(String[] args) {
    Solution sol = new Solution();
    //System.out.println(sol.isPerfectSquare(16));
    //System.out.println(sol.isPerfectSquare(81));
    System.out.println(sol.isPerfectSquare(808201));
  }

}
