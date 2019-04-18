package com.jtarun.practice.leetcode;

import java.util.*;

/** 410
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m
 * non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 *
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * Examples:
 *
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * Output:
 * 18
 *
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */
public class SplitArrayLargestSum {

    private static class Solution {

        // O(n * log(Z)) , where Z is positive integer range.

        /**
         * Note : Explanation for why the lowest value, that splits the array into m subgroups, is also a valid sum :
         *
         *  If range [left ...k... right] has all numbers that can divide the array into m subgroups and
         *  lets assume that k > left is the answer. This means that k is the largest sum among all subgroups and
         *  k-1 will split this largest group into two resulting in m+1 subgroups. But as we know that [left.. k-1]
         *  also results in m subgroups, it contradicts our assumption that k > left. Hence left is the answer.
         */
        public int splitArray(int[] nums, int m) {
            int n = nums.length;
            int max = nums[0], sum = 0;
            for (int num : nums) {
                max = Math.max(max, num);
                sum += num;
            }

            int lo = max, hi = sum;
            while (lo < hi) {
                int mid = lo + (hi-lo)/2;

                if (greater(nums, m-1, mid)) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }

            return lo;
        }

        private boolean greater(int[] nums, int m, int bound) {

            int sum = 0;
            for (int num : nums) {
                if (sum + num > bound) {
                    m--;
                    sum = num;
                    if (m < 0) return true;
                } else {
                    sum += num;
                }
            }

            return false;
        }

        // O(m*n*n) solution
        public int splitArray2(int[] nums, int m) {
            int n = nums.length;

            long sum = 0;
            for (int num : nums) sum += num;
            if (m == 1) return (int)sum;

            long[][] dp = new long[n][m];
            for (long[] row : dp) Arrays.fill(row, sum);

            sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                dp[i][0] = sum;
            }

            for (int l = 1; l < m; l++) {

                for (int i = l; i < n; i++) {

                    sum = 0;
                    for (int j = i; j > l-1; j--) {
                        sum += nums[j];
                        if (Math.max(sum, dp[j-1][l-1]) < dp[i][l]) {
                            dp[i][l] = Math.max(sum, dp[j-1][l-1]);
                        }
                    }

                }

            }

            return (int)dp[n-1][m-1];
        }
    }

}
