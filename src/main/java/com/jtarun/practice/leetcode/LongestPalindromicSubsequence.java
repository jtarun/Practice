package com.jtarun.practice.leetcode;

/** 516
 *  Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input:
 *
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 * Input:
 *
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromicSubsequence {

    private static class Solution {
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            if (n <= 1) return n;

            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i]= 1;
                if (i < n-1) {
                    dp[i][i+1] = s.charAt(i) == s.charAt(i+1) ? 2 : 1;
                }
            }

            for (int l = 3; l <= n; l++) {
                for (int i = 0; i+l-1 < n; i++) {
                    int j = i+l-1;

                    dp[i][j] = Math.max(dp[i+1][j-1] + ((s.charAt(i) == s.charAt(j)) ? 2: 0), Math.max(dp[i][j-1], dp[i+1][j]));

                }
            }

            return dp[0][n-1];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindromeSubseq("abcabcabcabc"));
    }

}
