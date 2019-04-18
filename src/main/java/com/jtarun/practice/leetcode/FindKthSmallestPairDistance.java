package com.jtarun.practice.leetcode;

import java.util.*;

/** 719
 * Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B)
 * is defined as the absolute difference between A and B.
 */
public class FindKthSmallestPairDistance {

    private static class Solution {
        // O(nlogn)
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);

            int n = nums.length;

            int lo = 0, hi = nums[n-1] - nums[0];
            while (lo < hi) {
                int mid = lo + (hi - lo)/2;

                if (count(nums, mid) >= k) {
                    hi = mid;
                } else {
                    lo = mid+1;
                }

            }


            return lo;
        }

        int count(int[] nums, int target) {
            int left = 0, right = 0, n = nums.length, res = 0;

            while (right < n) {

                while (left < right && nums[right] - nums[left] > target) left++;

                res += right-left;
                right++;
            }

            return res;
        }


        // O(n^2) algo - Bucketsort.
        public int smallestDistancePair2(int[] nums, int k) {
            int[] count = new int[1000010];
            int n = nums.length;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    count[Math.abs(nums[i]-nums[j])]++;
                }
            }

            for (int i= 0; i < count.length; i++) {
                k -= count[i];
                if (k <= 0) return i;
            }
            return -1;
        }
    }




}
