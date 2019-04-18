package com.jtarun.practice.leetcode;

import java.util.*;

/** 474
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
 *
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with
 * strings consisting of only 0s and 1s.
 *
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s.
 * Each 0 and 1 can be used at most once.
 *
 * Note:
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 * Example 1:
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 *
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 * Example 2:
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 *
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */
public class OnesAndZeroes {

    private static class Solution {

        //O(m*n) space
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m+1][n+1];

            for (String str : strs) {
                int[] cnt = count(str);
                int zeroes = cnt[0];
                int ones = cnt[1];

                for (int i = m; i >= zeroes; i--) {
                    for (int j = n; j >= ones; j--) {

                        dp[i][j] = Math.max(dp[i][j], dp[i-zeroes][j-ones] + 1);

                    }
                }

            }

            return dp[m][n];
        }

        // O(m*n*len(strs)) space
        public int findMaxFormRec(String[] strs, int m, int n) {

            int[][] count = new int[strs.length][2];
            for (int i = 0; i < strs.length; i++) {
                int[] c = count(strs[i]);
                count[i][0] = c[0];
                count[i][1] = c[1];
            }

            int[][][] dp = new int[strs.length][m+1][n+1];

            for (int[][] two : dp) {
                for (int[] one : two) Arrays.fill(one, -1);
            }

            return helper(strs, 0, m, n, count, dp);
        }

        private int helper(String[] strs, int i, int m, int n, int[][] count, int[][][] dp) {
            if (i == strs.length) return 0;

            if (dp[i][m][n] != -1) return dp[i][m][n];

            int res = 0;
            if ((m-count[i][0]) >= 0 && (n-count[i][1]) >= 0)
                res = 1 + helper(strs, i+1, m-count[i][0], n-count[i][1], count, dp);
            res = Math.max(res, helper(strs, i+1, m, n, count, dp));

            dp[i][m][n] = res;
            return res;
        }

        private int[] count(String s) {

            int[] res = new int[2];
            for (int i = 0; i <s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0') res[0]++;
                else res[1]++;
            }

            return res;
        }
    }

}
