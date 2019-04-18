package com.jtarun.practice.leetcode;

import java.util.Arrays;

/** 31
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order
 * (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand
 * column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    private static class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            if (n <= 1) return;

            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i+1]) i--;
            if (i < 0) {
                Arrays.sort(nums);
                return;
            }

            int j = i+1;
            while (j < n && nums[j] > nums[i]) j++;
            j--;
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;

            Arrays.sort(nums, i+1, n);
        }
    }

}
