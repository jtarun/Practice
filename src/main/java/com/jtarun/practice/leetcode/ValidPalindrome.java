package com.jtarun.practice.leetcode;

/**
 * 125
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters
 * and ignoring cases.
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 */
public class ValidPalindrome {
  private static class Solution {
    public boolean isPalindrome(String s) {
      int i = 0, j = s.length() - 1;
      if (s.isEmpty()) {
        return true;
      }

      while ( i < j) {

        while (i < j && !character(s.charAt(i))) {
          i++;
        }

        while (i < j && !character(s.charAt(j))) {
          j--;
        }

        if ( i < j) {
          if (toLower(s.charAt(i)) != toLower(s.charAt(j))) {
            return false;
          }
          i++;
          j--;
        }
      }

      return true;
    }

    private char toLower(char c) {
      if ( c >= 'A' && c <= 'Z') {
        return (char)(c + 32);
      }
      return c;
    }

    private boolean character(char c) {

      return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');

    }
  }
}
