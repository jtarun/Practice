package com.jtarun.practice.leetcode;

/*
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
public class PlusOne {
  private static class Solution {
    public int[] plusOne(int[] digits) {
      int n = digits.length;
      if (n == 0) {
        return digits;
      }
      int carry = 1;
      for (int i = n-1; i >= 0; i--) {
        int sum = digits[i] + carry;
        carry = sum / 10;
        digits[i] = sum % 10;
      }

      if (carry == 0) {
        return digits;
      }

      int[] ret = new int[n+1];
      ret[0] = carry;
      for (int i = 0; i < n; i++) {
        ret[i+1] = digits[i];
      }
      return ret;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    print(sol.plusOne(new int[]{1, 2, 3}));
    print(sol.plusOne(new int[]{4,3,2,1}));
    print(sol.plusOne(new int[]{9}));
    print(sol.plusOne(new int[]{0}));
    print(sol.plusOne(new int[]{1, 9, 9}));
    print(sol.plusOne(new int[]{9,9,9}));

  }

  private static void print(int[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + ", ");
    }
    System.out.println();
  }
}
