package com.jtarun.practice.leetcode;

/** 283
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {

    private static class Solution {
        public void moveZeroes(int[] nums) {
            int j = 0, i = 0;

            while (i < nums.length) {

                if (nums[i] != 0) {
                    nums[j++] = nums[i];
                }
                i++;
            }

            while (j < nums.length) nums[j++] = 0;

        }
    }

}
