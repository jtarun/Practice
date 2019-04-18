package com.jtarun.practice.leetcode;

import java.util.*;

/** 343
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product
 * of those integers. Return the maximum product you can get.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 *
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class IntegerBreak {

    private static class Solution {

        // Math solution
        public int integerBreak(int n) {
            if (n < 4) return n-1;
            if (n == 4) return n;

            int res = 1;
            while (n > 4) {
                res *= 3;
                n -= 3;
            }
            res *= n;

            return res;
        }

        public int integerBreakRecursionDP(int n) {
            int[] dp = new int[n+1];
            Arrays.fill(dp, -1);
            int res = helper(n, dp);
            return res;
        }

        private int helper(int n, int[] dp) {
            if (n <= 2) return 1;

            if (dp[n] != -1) return dp[n];

            int res = 0;
            for (int i = 1; i < n; i++) {
                res = Math.max(res, Math.max(i * (n-i), i * helper(n-i, dp)));
            }

            dp[n] = res;
            return res;

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.integerBreak(5));
    }

}
