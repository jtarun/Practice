package com.jtarun.practice.leetcode;

/** 162
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 */
public class FindPeakElement {
    private static class Solution {
        public int findPeakElement(int[] nums) {
            int lo = 0, hi = nums.length -1;
            while (lo != hi) {
                int mid = lo + (hi - lo)/2;

                if (nums[mid] < nums[mid+1]) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }

            return lo;
        }
    }
}
