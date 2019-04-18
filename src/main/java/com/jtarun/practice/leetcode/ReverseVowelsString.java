package com.jtarun.practice.leetcode;

/**
 * 345.
 * Write a function that takes a string as input and reverse only the vowels of a string.
 */
public class ReverseVowelsString {
  private static class Solution {
    public String reverseVowels(String s) {
      int n = s.length();
      char[] res = new char[n];
      int i = 0, j = n-1;
      while (i <= j) {
        if (i == j) {
          res[i] = s.charAt(i);
          break;
        }
        while ( i < j && !vowel(s.charAt(i))) {
          res[i] = s.charAt(i);
          i++;
        }
        while (i < j && !vowel(s.charAt(j))) {
          res[j] = s.charAt(j);
          j--;
        }

        if (i < j) {
          res[j] = s.charAt(i);
          res[i] = s.charAt(j);
          i++;
          j--;
        }
      }

      return new String(res);
    }

    private boolean vowel(char c) {
      return c=='a' || c=='e' || c=='i' || c=='o' || c == 'u' ||
          c=='A' || c=='E' || c=='I' || c=='O' || c == 'U';
    }
  }

}
