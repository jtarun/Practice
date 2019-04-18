package com.jtarun.practice.leetcode;

/** 746
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top
 * of the floor, and you can either start from the step with index 0, or the step with index 1.
 *
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 */
public class MinimumCostClimbingStairs {

    private static class Solution {

        // O(1) space
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            if (n <= 2) return 0;

            int[] dp = new int[n];
            int a = 0, b = 0;

            for (int i = 2; i < n; i++) {
                int t = b;
                b = Math.min(b + cost[i-1], a + cost[i-2]);
                a = t;
            }

            return Math.min(b + cost[n-1], a + cost[n-2]);
        }

        // O(n) space
        public int minCostClimbingStairs2(int[] cost) {
            int n = cost.length;
            if (n <= 2) return 0;

            int[] dp = new int[n];

            for (int i = 2; i < n; i++) {

                dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);

            }

            return Math.min(dp[n-1] + cost[n-1], dp[n-2] + cost[n-2]);
        }
    }

}
