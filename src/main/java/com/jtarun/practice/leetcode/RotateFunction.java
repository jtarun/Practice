package com.jtarun.practice.leetcode;

/** 396
 * Given an array of integers A and let n to be its length.
 *
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a
 * "rotation function" F on A as follow:
 *
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 *
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 *
 * Note:
 * n is guaranteed to be less than 105.
 */
public class RotateFunction {

    private static class Solution {
        public int maxRotateFunction(int[] A) {
            int n = A.length;
            if (n == 0) return 0;

            int sum = A[0];
            int val = 0;
            for (int i = 1; i < n; i++) {
                sum += A[i];
                val += i*A[i];
            }

            int res = val;

            for (int i = 1; i < n; i++) {
                int pivot = n-i;

                val -= A[pivot] * (n-1);
                val +=  sum - A[pivot];

                res = Math.max(res, val);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxRotateFunction(new int[]{4,3,2,6}));
    }

}
