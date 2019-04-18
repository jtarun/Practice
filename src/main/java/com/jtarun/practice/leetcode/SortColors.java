package com.jtarun.practice.leetcode;

/** 75
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color
 * are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not supposed to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {

    private static class Solution {
        public void sortColors(int[] nums) {
            int i = 0, j = 0, k = nums.length-1;

            while (j <= k) {
                int x = nums[j];
                if (x == 0) {
                    swap(nums, i, j);
                    i++;
                    j++;
                } else if (x == 2) {
                    swap(nums, j, k);
                    k--;
                } else j++;
            }

        }

        private void swap(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }


}
