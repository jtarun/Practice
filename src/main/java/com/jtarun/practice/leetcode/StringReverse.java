package com.jtarun.practice.leetcode;


/** 344
 * Write a function that takes a string as input and returns the string reversed.
 */
public class StringReverse {

  private static class Solution {
    public String reverseString(String s) {
      int n = s.length();
      if ( n == 0) {
        return "";
      }
      char[] reverse = new char[n];
      for (int i = n-1; i >= 0; i--) {
        reverse[n-1 - i] = s.charAt(i);
      }
      return new String(reverse);
    }
  }

}
