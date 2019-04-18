package com.jtarun.practice.leetcode;

import java.util.*;

/** 44
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 */
public class WildcardMatching {

    class Solution {
        public boolean isMatch(String s, String p) {
            int[][] dp = new int[s.length()][p.length()];
            for (int[] row : dp) Arrays.fill(row, -1);
            return helper(s, p, s.length()-1, p.length()-1, dp);
        }

        private boolean helper(String s, String p, int i, int j, int[][] dp) {
            if (i < 0 && j < 0) return true;
            if (j < 0) return false;
            if (i < 0) {
                for (int k = j;  k >= 0; k--) if (p.charAt(k) != '*') return false;
                return true;
            }

            if (dp[i][j] != -1) return dp[i][j] == 0 ? false : true;

            char c = s.charAt(i);
            char d = p.charAt(j);

            boolean res = false;
            if (c == d || d == '?') res = helper(s, p, i-1, j-1, dp);
            else if (d == '*') {
                res = helper(s, p, i, j-1, dp) || helper(s, p, i-1, j, dp) ;
            }

            dp[i][j] = !res ? 0 : 1;

            return res;
        }

    }
}
