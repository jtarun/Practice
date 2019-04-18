package com.jtarun.practice.leetcode;


/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum
 * length of s is 1000.
 */
public class LongestPalindromeSubstring {

  private static class Solution {
    public String longestPalindrome(String s) {
      int n = s.length();
      if (n <= 1) {
        return s;
      }

      boolean[][] p = new boolean[n][n];

      int max_len = 1, res_i = 0;
      for (int l = 1; l <= n; l++) {
        for (int i = 0; i + l - 1 < n; i++) {
          int j = i + l - 1;
          if (l == 1) {
            p[i][j] = true;
          } else if (l == 2) {
            p[i][j] = s.charAt(i) == s.charAt(j);
          } else if (p[i + 1][j - 1] && (s.charAt(i) == s.charAt(j))) {
            p[i][j] = true;
          } else {
            p[i][j] = false;
          }

          if (p[i][j] && (l > max_len)) {
            max_len = l;
            res_i = i;
          }

        }
      }
      return s.substring(res_i, res_i + max_len);
    }
  }


  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.longestPalindrome("babad"));
    System.out.println(sol.longestPalindrome("cbbd"));
  }

}
