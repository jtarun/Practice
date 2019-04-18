package com.jtarun.practice.leetcode;

/** 747
 * In a given integer array nums, there is always exactly one largest element.
 *
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 *
 * If it is, return the index of the largest element, otherwise return -1.
 *
 * Example 1:
 *
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 */
public class LargestNumberAtLeastTwiceOfOthers {

    private static class Solution {
        public int dominantIndex(int[] nums) {
            if (nums.length == 1) return 0;

            int first, second;
            int ind ;
            if (nums[0] > nums[1]) {
                first = nums[0];
                second = nums[1];
                ind = 0;
            } else {
                ind = 1;
                first = nums[1];
                second = nums[0];
            }

            for (int i = 2; i < nums.length; i++) {
                if (nums[i] > first) {
                    second = first;
                    first = nums[i];
                    ind = i;
                } else if (nums[i] > second) {
                    second = nums[i];
                }
            }

            return first >= second*2 ? ind : -1;
        }
    }

}
