package com.jtarun.practice.leetcode;

/** 238
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the
 * product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the
 * purpose of space complexity analysis.)
 */
public class ProductArrayExceptSelf {

    private static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] left = new int[n];
            left[0] = 1;
            for (int i = 1; i < n; i++) {
                left[i] = left[i-1] * nums[i-1];
            }

            int prev = 1;
            for (int i = n-2; i >= 0; i--) {
                int right = prev * nums[i+1];
                left[i] *= right;
                prev = right;
            }

            return left;
        }
    }


}
