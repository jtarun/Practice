package com.jtarun.practice.leetcode;

/** 896
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all
 * i <= j, A[i] >= A[j].
 *
 * Return true if and only if the given array A is monotonic.
 */
public class MonotonicArray {

    private static class Solution {
        public boolean isMonotonic(int[] A) {
            int n = A.length;
            boolean increasing = true, decreasing = true;
            for (int i = 1; i < n; i++) {
                if (A[i] < A[i-1]) {
                    increasing = false;
                    break;
                }
            }
            if (increasing) return true;

            for (int i = 1; i < n; i++) {
                if (A[i] > A[i-1]) {
                    decreasing = false;
                    break;
                }
            }

            return decreasing;
        }
    }
}
