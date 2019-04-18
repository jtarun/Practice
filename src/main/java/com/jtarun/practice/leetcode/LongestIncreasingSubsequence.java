package com.jtarun.practice.leetcode;

import java.util.Arrays;

/** 300
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 */
public class LongestIncreasingSubsequence {

    private static class Solution {

        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            if (n <= 1) return n;
            int[] tails = new int[n];
            int size = 0;
            for (int i = 0; i < n; i++) {
                int lo = 0, hi = size;
                while (lo < hi) {
                    int mid = lo + (hi - lo)/2;

                    if (tails[mid] < nums[i]) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                tails[lo] = nums[i];
                if (lo == size) size++;
            }

            return size;
        }


        public int lengthOfLIS2(int[] nums) {
            if (nums.length <= 1) return nums.length;

            int[] lis = new int[nums.length];
            Arrays.fill(lis, 1);

            int res = 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        lis[i] = Math.max(lis[i], lis[j] + 1);
                    }
                }
                res = Math.max(res, lis[i]);
            }

            return res;
        }
    }

}
