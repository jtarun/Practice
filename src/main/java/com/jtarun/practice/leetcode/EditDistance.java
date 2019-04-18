package com.jtarun.practice.leetcode;

/** 72
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 */
public class EditDistance {

    private static class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m+1][n+1];

            for (int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }

            for (int i = 1; i <= n; i++) {
                dp[0][i] = i;
            }

            for (int i = 1; i <= m; i++) {
                char c = word1.charAt(i-1);
                for (int j = 1; j <= n; j++) {

                    char d = word2.charAt(j-1);

                    if (c == d) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],
                                dp[i][j-1])) + 1;
                    }

                }

            }

            return dp[m][n];
        }
    }

}
