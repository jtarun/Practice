package com.jtarun.practice.leetcode;

import java.util.*;

/** 132
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {

    private static class Solution {
        public int minCut(String s) {
            int n = s.length();
            if (n <= 1) return 0;

            boolean[][] p = new boolean[n][n];

            for (int l = 1; l <= n; l++) {
                for (int i = 0; i+l-1 < n; i++) {
                    int j = i+l-1;

                    if (l <= 2) {
                        p[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        p[i][j] = p[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                    }

                }
            }

            int[] dp = new int[n];
            Arrays.fill(dp, n);
            dp[0] = 1;
            for (int i = 1; i < n; i++) {

                for (int j = i; j >= 0; j--) {
                    if (p[j][i]) {
                        dp[i] = Math.min(dp[i], j == 0 ? 1 : dp[j-1] + 1);
                    }
                }
            }

            return dp[n-1]-1;
        }

        // TLE
        public int minCutDFS(String s) {
            int n = s.length();
            if (n <= 1) return 0;

            int[] res = new int[1];
            res[0] = Integer.MAX_VALUE;
            boolean[][] p = new boolean[n][n];

            for (int l = 1; l <= n; l++) {
                for (int i = 0; i + l - 1 < n; i++) {
                    int j = i + l - 1;

                    if (l <= 2) {
                        p[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        p[i][j] = p[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                    }

                }
            }

            helper(s, 0, p, res, 0);

            return res[0] - 1;
        }

        private void helper(String s, int ind, boolean[][] p, int[] res, int cnt) {
            int n = s.length();
            if (ind == n) {
                res[0] = Math.min(res[0], cnt);
                return;
            }

            for (int i = ind; i < n ; i++) {
                if (p[ind][i]) {
                    helper(s, i+1, p, res, cnt+1);
                }
            }
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minCut("ababababababababababababcbabababababababababababa"));
    }

}
