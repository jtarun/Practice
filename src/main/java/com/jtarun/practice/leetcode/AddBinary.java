package com.jtarun.practice.leetcode;

/** 67
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 */
public class AddBinary {

  private static class Solution {
    public String addBinary(String a, String b) {
      int n = a.length();
      int m = b.length();
      int i = n-1, j = m-1;
      StringBuilder sb = new StringBuilder();
      int carry = 0;
      while (i >= 0 || j >= 0) {
        int sum = carry;
        if (i >= 0) {
          sum += a.charAt(i) - '0';
          i--;
        }
        if (j >= 0) {
          sum += b.charAt(j) - '0';
          j--;
        }
        sb.append(sum % 2);
        carry = sum / 2;
      }

      if (carry != 0) {
        sb.append(carry);
      }

      return sb.reverse().toString();
    }
  }

  public static void main(String[] args) {
    Solution sol =  new Solution();
    System.out.println(sol.addBinary("11", "1"));
    System.out.println(sol.addBinary("1010", "1011"));
  }

}
