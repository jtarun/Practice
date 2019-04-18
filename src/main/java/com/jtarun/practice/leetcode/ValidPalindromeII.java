package com.jtarun.practice.leetcode;

/** 680
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 */
public class ValidPalindromeII {

    private static class Solution {
        public boolean validPalindrome(String s) {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) break;
                i++;
                j--;
            }

            if (j < i || j-i <= 1) return true;

            // eliminating a character either at i or j can lead to palindrome, consider the case ...ab...ab...
            return isPalindrome(s, i, j-1) || isPalindrome(s, i+1, j);
        }

        private boolean isPalindrome(String s, int i, int j) {

            while (i < j) {
                if (s.charAt(i++) != s.charAt(j--)) return false;
            }

            return true;
        }
    }

}
