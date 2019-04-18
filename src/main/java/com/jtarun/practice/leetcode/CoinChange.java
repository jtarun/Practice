package com.jtarun.practice.leetcode;

import java.util.*;


/** 322
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 */
public class CoinChange {

    private static class Solution {

        /**
         * Note: This can also be easily solved using BFS.
         */

        // DFS solution with memoization.
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            boolean[] v = new boolean[amount+1];
            v[0] = true;
            int res = helper(coins, amount, dp, v);
            return res == Integer.MAX_VALUE ? -1 : res;
        }

        private int helper(int[] coins, int amount, int[] dp, boolean[] v) {
            if (amount < 0) return Integer.MAX_VALUE;
            if (amount == 0) return 0;
            if (v[amount]) return dp[amount];

            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                int val = helper(coins, amount-coin, dp, v);
                if (val != Integer.MAX_VALUE) val++;
                res = Math.min(val, res);
            }

            dp[amount] = res;
            v[amount] = true;

            return res;
        }


        public int coinChange2(int[] coins, int amount) {
            if (amount <= 0) return 0;

            int[] dp = new int[amount+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            int n = coins.length;
            for (int i = 1; i <= amount; i++) {
                for (int j = n-1; j >= 0; j--) {
                    int coin = coins[j];
                    if (i - coin >= 0 && dp[i-coin] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i-coin] + 1, dp[i]);
                    }
                }
            }

            return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount] ;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.coinChange(new int[]{2}, 3));
    }

}
