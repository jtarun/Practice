package com.jtarun.practice.leetcode;

/** 441
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 *
 * n = 5
 * Output : 2 (because 3rd row is incomplete)
 */
public class ArrangeCoins {

    private static class Solution {

        public int arrangeCoins(int n) {
            if (n == 0) return 0;

            return (int)((-1 + Math.sqrt(1 + (long)8 * n)) / 2);
        }

        public int arrangeCoins2(int n) {
            if (n == 0) return 0;
            long lo = 1, hi = n;

            while (lo < hi) {

                long mid = hi - (hi - lo)/2;
                long val = mid * (mid+1)/2;

                if (val > n) {
                    hi = mid-1;
                } else {
                    lo = mid;
                }

            }
            return (int)lo;
        }
    }

}
