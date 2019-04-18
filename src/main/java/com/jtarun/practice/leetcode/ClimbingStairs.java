package com.jtarun.practice.leetcode;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 */
public class ClimbingStairs {

  private static class Solution {
    public int climbStairs(int n) {
      if (n <= 2) return n;

      int first = 1, second = 2;
      for (int i = 3; i <= n; i++) {
        int temp = first + second;
        first = second;
        second = temp;
      }
      return second;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.climbStairs(2));
    System.out.println(sol.climbStairs(3));
    System.out.println(sol.climbStairs(4));
  }

}
