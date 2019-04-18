package com.jtarun.practice.leetcode;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching
 * with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 */
public class RegexMatching {

  private static class Solution {
    public boolean isMatch(String s, String p) {
      int n = s.length();
      int m = p.length();
      boolean[][] r = new boolean[n+1][m+1];

      for (int i = 0; i <= n; i++) {
        char c = '\0';
        if ( i > 0) {
          c = s.charAt(i-1);
        }
        for (int j = 0; j <= m; j++) {
          r[i][j] = false;
          char d = '\0';
          if ( j > 0) {
            d = p.charAt(j-1);
          }

          if ( i == 0 && j == 0) {
            r[i][j] = true;
          } else if ( i == 0) {
            if ( j == 1) {
              r[i][j] = false;
            } else if (d == '*') {
              r[i][j] = r[i][j-2];
            }
          } else if (j == 0) {
            r[i][j] = false;
          } else {
            if (c == d || d == '.') {
              r[i][j] = r[i-1][j-1];
            } else if (d == '*') {
              char x = p.charAt(j-2);
              r[i][j] = r[i][j-2] || ((x == c || x == '.') && r[i-1][j]);
            }
          }
        }
      }

      return r[n][m];
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.isMatch("aa", "a"));
    System.out.println(sol.isMatch("aa", "a*"));
    System.out.println(sol.isMatch("ab", ".*"));
    System.out.println(sol.isMatch("aab", "c*a*b"));
    System.out.println(sol.isMatch("mississippi", "mis*is*p*."));
  }

}
