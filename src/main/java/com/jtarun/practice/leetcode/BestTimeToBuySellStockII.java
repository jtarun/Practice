package com.jtarun.practice.leetcode;

import java.util.*;

/** 122
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you
 * buy again).
 */
public class BestTimeToBuySellStockII {

    private static class Solution {

        public int maxProfit(int[] prices) {

            int res = 0;
            for (int i = 0; i < prices.length-1; i++) {
                if (prices[i] < prices[i+1]) {
                    res += prices[i+1] - prices[i];
                }
            }

            return res;
        }

        public int maxProfit2(int[] prices) {
            int[][] res = new int[prices.length][2]; //res[][0] means buy and res[][1] means sell profit

            int ans = 0;
            for (int i = 0; i < prices.length; i++) {
                // buy
                int maxSellProfit = 0;
                for (int j = 0; j < i; j++) {
                    maxSellProfit = Math.max(maxSellProfit, res[j][1]);
                }
                res[i][0] = maxSellProfit - prices[i];

                // sell
                for (int j = 0; j < i; j++) {
                    if (prices[j] < prices[i]) {
                        res[i][1] = Math.max(res[i][1], res[j][0] + prices[i]);
                        ans = Math.max(ans, res[i][1]);
                    }
                }
            }

            return ans;
        }

        // TLE
        public int maxProfitDFS(int[] prices) {
            if (prices.length <= 1) return 0;
            int[] res = new int[1];
            helper(prices, 0, 0, 0, res, 0);
            return res[0];
        }

        private void helper(int[] prices, int idx, int profit, int lastbuy, int[] res, int state) {
            if (idx > prices.length) return;

            for (int i = idx; i < prices.length; i++) {
                if (state == 0) { // BUY
                    if (i < prices.length - 1)
                        helper(prices, i + 1, profit - prices[i], prices[i], res, 1);

                } else { // SELL

                    if (prices[i] > lastbuy) {
                        res[0] = Math.max(res[0], profit + prices[i]);
                        helper(prices, i+1, profit + prices[i], 0, res, 0); // lastbuy value is insignificant here.
                    }
                }
            }
        }

        // Memory limit exceeded.
        public int maxProfitBFS(int[] prices) {
            if (prices.length <= 1) return 0;

            Queue<int[]> q = new LinkedList<>();

            int BUY = 1, SELL = 2;
            Comparator<int[]> cmp = (x, y) -> {
                if (x[0] == y[0] && x[1] == y[1] && x[2] == y[2]) return 0;
                return -1;
            };
            Set<int[]> v = new TreeSet<>(cmp);

            {
                int[] node = new int[]{0, 0, BUY};
                int[] node2 = new int[]{0, 0, SELL};
                q.offer(node);
                q.offer(node2);
                v.add(node);
                v.add(node2);
            }

            int res = 0;
            while (!q.isEmpty()) {
                int[] t = q.poll();
                int ind = t[0], profit = t[1], state = t[2];
                res = Math.max(res, profit);

                for (int i = ind+1; i < prices.length; i++) {
                    if (state == BUY) {
                        int cur_profit = prices[i] - prices[ind];
                        if (cur_profit > 0) {
                            int[] node = new int[]{i, profit + cur_profit, SELL};
                            if (v.add(node)) {
                                q.offer(node);
                            }
                        }
                    } else {
                        int[] node = new int[]{i, profit, BUY};
                        if (v.add(node)){
                            q.offer(node);
                        }
                    }
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int res = sol.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(res);
    }

}
