package com.jtarun.practice.leetcode;

import java.util.*;

/** 115
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 *
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 *
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 *
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 */
public class DistinctSubsequences {

    private static class Solution {
        public int numDistinct(String s, String t) {
            int[][] dp = new int[s.length()][t.length()];
            for (int[] row : dp) Arrays.fill(row, -1);
            return helper(s, t, s.length()-1, t.length() - 1, dp);
        }

        private int helper(String s, String t, int i, int j, int[][] dp) {
            if (j < 0) return 1;
            if (i < 0) return 0;

            if (dp[i][j] != -1) return dp[i][j];

            int res = helper(s, t, i-1, j, dp);
            if (s.charAt(i) == t.charAt(j)) res += helper(s, t, i-1, j-1, dp);

            dp[i][j] = res;

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numDistinct("aai", "ai"));
        //System.out.println(sol.numDistinct("rabbbit", "rabbit"));
    }

}
