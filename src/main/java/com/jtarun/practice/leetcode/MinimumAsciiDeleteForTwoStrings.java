package com.jtarun.practice.leetcode;

/** 712
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
 *
 * Example 1:
 * Input: s1 = "sea", s2 = "eat"
 * Output: 231
 * Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
 * Deleting "t" from "eat" adds 116 to the sum.
 * At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
 */
public class MinimumAsciiDeleteForTwoStrings {

    private static class Solution {
        public int minimumDeleteSum(String a, String b) {
            int m = a.length();
            int n = b.length();

            int[][] dp = new int[m+1][n+1];
            for (int i = 1; i <= m; i++) {
                dp[i][0] = dp[i-1][0] + a.charAt(i-1);
            }

            for (int i = 1; i <= n; i++) {
                dp[0][i] = dp[0][i-1] + b.charAt(i-1);
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (a.charAt(i-1) == b.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j] + a.charAt(i-1), dp[i][j-1] + b.charAt(j-1));
                    }
                }
            }


            return dp[m][n];
        }
    }

}
