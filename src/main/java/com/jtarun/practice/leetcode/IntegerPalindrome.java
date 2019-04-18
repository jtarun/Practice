package com.jtarun.practice.leetcode;

public class IntegerPalindrome {
  private static class Solution {
    public boolean isPalindrome(int x) {
      if (x < 0) return false;

      int n = count(x);
      if (n == 1) return true;

      int i = 0, j = n - 1;
      int pow = (int)Math.pow(10, j);
      while ( i < j) {

        int d1 = x % 10;
        int d2 = x / pow;

        if (d1 != d2) {
          return false;
        }

        x = x % pow;
        x = x / 10;

        pow = pow / 100;
        i++;
        j--;
      }

      return true;
    }

    int count(int x) {
      if (x == 0) return 1;
      int res = 0;
      while (x != 0) {
        res++;
        x = x/10;
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.isPalindrome(121));
    System.out.println(sol.isPalindrome(-121));
    System.out.println(sol.isPalindrome(10));
    System.out.println(sol.isPalindrome(1221));
  }
}
