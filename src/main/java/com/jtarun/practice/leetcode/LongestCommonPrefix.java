package com.jtarun.practice.leetcode;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {

  private static class Solution {
    public String longestCommonPrefix(String[] strs) {
      if (strs.length == 0) return "";

      int n = strs[0].length();
      for (int i = 1; i < strs.length; i++) {
        n = Math.min(n, strs[i].length());
      }

      int c = 0;
      while (c < n) {
        char x = strs[0].charAt(c);
        boolean match = true;
        for (int i = 1; i < strs.length; i++) {
          if (x != strs[i].charAt(c)) {
            match = false;
            break;
          }
        }

        if (!match) {
          break;
        }
        c++;
      }

      return strs[0].substring(0, c);
    }

  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    String[] strs = {"flower","flow","flight"};
    System.out.println(sol.longestCommonPrefix(strs));

    String[] strs2= {"dog","racecar","car"};
    System.out.println(sol.longestCommonPrefix(strs2));
  }
}
