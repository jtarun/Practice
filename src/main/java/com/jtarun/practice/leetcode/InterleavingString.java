package com.jtarun.practice.leetcode;

import java.util.*;

/** 97
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class InterleavingString {

    private static class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int a = s1.length();
            int b = s2.length();
            int c = s3.length();
            if (c != a+b) return false;

            int[][][] dp = new int[a+1][b+1][c+1];
            for (int[][] mat : dp) {
                for (int[] row : mat) Arrays.fill(row, -1);
            }
            dp[0][0][0] = 1;

            return helper(s1, s2, s3, a, b, c, dp);
        }

        private boolean helper(String s1, String s2, String s3, int i, int j, int k, int[][][] dp){

            if (k == 0) return i == 0 && j == 0;
            if (i == 0 && j == 0) return false;
            if (dp[i][j][k] != -1) return dp[i][j][k] == 1;

            boolean res = false;
            if (i == 0) {
                res = s2.substring(0, j).equals(s3.substring(0, k));
            } else if (j == 0) {
                res = s1.substring(0, i).equals(s3.substring(0, k));
            } else {



                char c = s1.charAt(i-1);
                char d = s2.charAt(j-1);
                char e = s3.charAt(k-1);


                if (c == e && c != d) {
                    res = helper(s1, s2, s3, i-1, j, k-1, dp);
                } else if (d == e && c != d) {
                    res = helper(s1, s2, s3, i, j-1, k-1, dp);
                } else if (c == e && d == e) {
                    res = helper(s1, s2, s3, i-1, j, k-1, dp) ||
                            helper(s1, s2, s3, i, j-1, k-1, dp);
                }
            }
            dp[i][j][k] = res ? 1 : 0;

            return res;
        }

    }

}
