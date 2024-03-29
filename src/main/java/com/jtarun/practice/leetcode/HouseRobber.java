package com.jtarun.practice.leetcode;

/** 198
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 * of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

    private static class Solution {
        public int rob(int[] a) {
            int n = a.length;
            if (n == 0) return 0;
            if (n == 1) return a[0];

            int max_incl = a[1], max_excl = a[0];
            for (int i = 2; i < n; i++) {
                int t = max_incl;
                max_incl = max_excl + a[i];
                max_excl = Math.max(t, max_excl);
            }

            return Math.max(max_incl, max_excl);
        }
    }

}
