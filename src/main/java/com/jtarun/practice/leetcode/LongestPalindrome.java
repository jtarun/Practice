package com.jtarun.practice.leetcode;


/** 409
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {

    private static class Solution {
        public int longestPalindrome(String s) {
            int[] cnt = new int[130];

            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - '\0']++;
            }

            int res = 0;
            for (int i = 0; i < 26; i++) {
                res += (cnt['A' + i] >> 1) << 1;
                res += (cnt['a' + i] >> 1) << 1;
            }

            if (res != s.length()) res++;

            return res;
        }
    }

}
