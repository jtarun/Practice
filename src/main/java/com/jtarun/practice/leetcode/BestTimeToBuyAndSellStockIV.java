package com.jtarun.practice.leetcode;

import java.util.*;

/** 188
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 */
public class BestTimeToBuyAndSellStockIV {

    private static class Solution {
        public int maxProfit(int k, int[] prices) {
            if (k == 0) return 0;

            if(k > prices.length/2) return maxProfit(prices);

            int[] buy = new int[k];
            int[] sell = new int[k];
            Arrays.fill(buy, Integer.MIN_VALUE);

            for (int price : prices) {

                for (int i = 0; i < k; i++) {
                    sell[i] = Math.max(sell[i], buy[i] + price);
                    buy[i] = Math.max(buy[i], i > 0 ? sell[i-1] - price : -price);
                }

            }

            return sell[k-1];
        }

        private int maxProfit(int[] prices) {

            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1]) {
                    res += prices[i] - prices[i-1];
                }
            }
            return res;
        }

    }

}
