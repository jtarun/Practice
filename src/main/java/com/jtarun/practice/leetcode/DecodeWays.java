package com.jtarun.practice.leetcode;

import java.util.*;

/** 91
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {

    private static class Solution {
        public int numDecodings(String s) {
            int[] dp = new int[s.length()];
            Arrays.fill(dp, -1);
            return helper(s, 0, dp);
        }

        private int helper(String s, int i, int[] dp) {
            if (i == s.length()) return 1;
            if (s.charAt(i) == '0') return 0;

            if (dp[i] != -1) return dp[i];

            int res = helper(s, i+1, dp);
            if (i < s.length() - 1) {
                String v = "" + s.charAt(i) + s.charAt(i+1);
                int x = Integer.parseInt(v);
                if (x <= 26) {
                    res += helper(s, i+2, dp);
                }

            }

            dp[i] = res;

            return res;
        }

    }

}
