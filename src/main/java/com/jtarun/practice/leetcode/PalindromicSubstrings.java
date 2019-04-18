package com.jtarun.practice.leetcode;

/** 647
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they
 * consist of same characters.
 *
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 */
public class PalindromicSubstrings {

    private static class Solution {
        public int countSubstrings(String s) {
            int n = s.length();
            int res = n;
            if (n <= 1) return res;

            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
                if (i < n-1 && s.charAt(i) == s.charAt(i+1)) {
                    dp[i][i+1] = 1;
                    res++;
                }
            }

            for (int l = 3; l <= n; l++) {
                for (int i = 0; i + l -1 < n; i++) {
                    int j = i+l-1;
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i+1][j-1] == 1) ? 1 : 0;
                    res += dp[i][j];
                }
            }

            return res;
        }
    }

}
