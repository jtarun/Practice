package com.jtarun.practice.leetcode;

import java.util.*;

/** 123
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 */
public class BestTimeToBuySellStockIII {

    private static class Solution {

        // O(n) with O(1) space
        public int maxProfit(int[] prices) {
            int firstBuy = Integer.MIN_VALUE, secondBuy = Integer.MIN_VALUE, firstSell = 0, secondSell = 0;

            for (int price : prices) {
                secondSell = Math.max(secondSell, secondBuy + price);
                secondBuy = Math.max(secondBuy, firstSell - price);
                firstSell = Math.max(firstSell, firstBuy + price);
                firstBuy = Math.max(firstBuy, -price);
            }

            return secondSell;
        }

        // O(n) with O(n) space
        public int maxProfit_LinearSpace(int[] prices) {
            int n = prices.length;
            if (n <= 1) return 0;
            int[] left = new int[n];
            int min = prices[0];
            for (int i = 1; i < n; i++) {
                if (min > prices[i]) {
                    min = prices[i];
                } else {
                    left[i] = prices[i] - min;
                }

                left[i] = Math.max(left[i], left[i-1]);
            }

            int max = prices[n-1];
            int[] right = new int[n];
            for (int i = n-2; i >= 0; i--) {
                if (max < prices[i]) {
                    max = prices[i];
                } else {
                    right[i] = max - prices[i];
                }
                right[i] = Math.max(right[i], right[i+1]);
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, left[i] + right[i]);
            }

            return res;
        }


        // O(n^2) solution
        public int maxProfit2(int[] prices) {
            int n = prices.length;
            if (n <= 1) return 0;

            int res = 0;
            for (int j = 1; j < n; j++) {
                int profit = profit(prices, 0, j) + profit(prices, j+1, n-1);
                res = Math.max(res, profit);
            }

            return res;
        }


        // O(n^3) solution - Memory limit exceeded
        public int maxProfit3(int[] prices) {
            int n = prices.length;
            if (n <= 1) return 0;

            int[][] profit = new int[n][n];
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    profit[i][j] = profit(prices, i, j);
                    res = Math.max(res, profit[i][j]);
                }
            }

            if (n < 4) return res;

            int[] dp = new int[n];
            for (int i = 3; i < n; i++) {
                for (int j = 1; j < i-1; j++) {
                    dp[i] = Math.max(dp[i], profit[0][j] + profit[j+1][i]);
                }
                res = Math.max(res, dp[i]);
            }

            return res;
        }

        private int profit(int[] prices, int s, int e) {
            if (s >= e) return 0;
            int res = 0;
            int min = prices[s];
            for (int i = s+1; i <= e; i++) {
                if (prices[i] > min) {
                    int diff = prices[i] - min;
                    res = Math.max(diff, res);
                } else {
                    min = prices[i];
                }
            }

            return res;
        }

        // TLE O(n^4)
        public int maxProfitBFS(int[] prices) {
            int n = prices.length;
            if (n <= 1) return 0;

            int BUY = 1, SELL = 2;
            Queue<int[]> q = new LinkedList<>();

            for (int i = 0; i < n-1; i++) {
                q.offer(new int[]{-prices[i], i, BUY, 0});
            }

            int res = 0;
            while (!q.isEmpty()) {
                int[] t = q.poll();
                int val = t[0], ind = t[1], state = t[2], sellCnt = t[3];

                for (int i = ind+1; i < n; i++) {
                    if (state == BUY) {
                        // look for sell
                        if (prices[i] > prices[ind]) {
                            int profit = val + prices[i];
                            res = Math.max(res, profit);
                            if (sellCnt < 1) q.offer(new int[]{profit, i, SELL, sellCnt+1});
                        }

                    } else {
                        // look for buy
                        q.offer(new int[]{val-prices[i], i, BUY, sellCnt});

                    }

                }

            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxProfit(new int[]{2,1,2,0,1}));
    }
}
