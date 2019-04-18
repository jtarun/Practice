package com.jtarun.practice.leetcode;

/*
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
 * in their binary representation and return them as an array.
 */
public class CountingBits {
    private static class Solution {

        public int[] countBits(int num) {
            int[] res = new int[num+1];
            res[0] = 0;
            for (int i = 1; i <= num; i++) {
                res[i] = res[i & (i-1)] + 1;
            }
            return res;
        }

        public int[] countBits2(int num) {
            int n = num;
            int[] res = new int[n + 1];
            res[0] = 0;
            if (n == 0) {
                return res;
            }
            res[1] = 1;
            if (n == 1) {
                return res;
            }

            int k = 2, end = 1;
            while (k <= n) {
                for (int i = 0; k <= n && i <= end; i++) {
                    res[k++] = res[i] + 1;
                }
                end = k - 1;
            }
            return res;
        }
    }
}

