package com.jtarun.practice.leetcode;

/** 309
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    private static class Solution {

        // O(1) space
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n <= 1) return 0;

            int buy, prevBuy = Integer.MIN_VALUE;
            int sell = 0, sellCooldown = 0, prevSell = 0;
            for (int i = 0; i < prices.length; i++) {

                buy = Math.max(prevBuy, sellCooldown - prices[i]);
                prevBuy = buy;
                sellCooldown = sell;
                sell = Math.max(sell, prevBuy + prices[i]);
            }

            return sell;
        }

        // O(n) space
        public int maxProfit2(int[] prices) {
            int n = prices.length;
            if (n <= 1) return 0;

            int[] buy = new int[n];
            int[] sell = new int[n];
            for (int i = 0; i < prices.length; i++) {
                int sellCooldown = i >= 2 ? sell[i-2] : 0;
                int prevBuy = i > 0 ? buy[i-1] : Integer.MIN_VALUE;
                int prevSell = i > 0 ? sell[i-1] : 0;

                buy[i] = Math.max(prevBuy, sellCooldown - prices[i]);
                sell[i] = Math.max(prevSell, prevBuy + prices[i]);
            }

            return sell[n-1];
        }

    }

}
