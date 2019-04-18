package com.jtarun.practice.leetcode;

/** 209
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous
 * subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 */
public class MinimumSizeSubarraysum {

    private static class Solution {
        public int minSubArrayLen(int s, int[] a) {
            int n = a.length;

            int res = 0;
            int start = 0, end = 0, sum = 0;
            while (end < n) {
                while (end < n && sum < s) {
                    sum += a[end++];
                }
                while (sum >= s) {
                    int len = end - start;
                    res = (res == 0) ? len : Math.min(res, len);
                    sum -= a[start++];
                }
            }

            return res;
        }
    }
}
