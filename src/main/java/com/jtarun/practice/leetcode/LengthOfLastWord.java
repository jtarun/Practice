package com.jtarun.practice.leetcode;

/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 */
public class LengthOfLastWord {
  private static class Solution {
    public int lengthOfLastWord(String s) {
      int n = s.length();
      while (n-1 >= 0 && (s.charAt(n-1) == ' ')) {
        n--;
      }

      int i = 0;
      int last = -1;
      while( i < n) {
        if (s.charAt(i) == ' ') {
          last = i;
        }
        i++;
      }

      return n - last - 1;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.lengthOfLastWord("hello world"));
  }
}
