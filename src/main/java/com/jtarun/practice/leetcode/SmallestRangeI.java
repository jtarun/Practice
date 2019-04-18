package com.jtarun.practice.leetcode;

/** 908
 * Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
 *
 * After this process, we have some array B.
 *
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 */
public class SmallestRangeI {
    private static class Solution {
        public int smallestRangeI(int[] A, int K) {
            int max = A[0], min = A[0];
            for (int num : A) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            }

            int diff = max - min;
            if (diff < 2 * K) return 0;
            return diff - 2 *K;
        }
    }
}
