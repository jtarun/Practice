package com.jtarun.practice.leetcode;

/** 852
 * Let's call an array A a mountain if the following properties hold:
 *
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that
 * A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 */
public class PeakIndexInMountainArray {

    private static class Solution {
        public int peakIndexInMountainArray(int[] A) {
            int lo = 0, hi = A.length -1 ;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (A[mid] < A[mid+1]) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }

            }

            return lo;
        }
    }

}
