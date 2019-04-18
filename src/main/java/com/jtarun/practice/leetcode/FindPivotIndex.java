package com.jtarun.practice.leetcode;

/** 724
 *
 *Given an array of integers nums, write a method that returns the "pivot" index of this array.
 *
 *We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of
 *the numbers to the right of the index.
 *
 *If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the
 *left-most pivot index.
 */
public class FindPivotIndex {

    private static class Solution {
        public int pivotIndex(int[] nums) {
            int total = 0;
            for (int num : nums) total += num;

            int left = 0, right = total;
            for (int i = 0; i < nums.length; i++) {
                right -= nums[i];
                if (right == left) return i;
                left += nums[i];
            }

            return -1;
        }
    }
}
