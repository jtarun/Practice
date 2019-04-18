package com.jtarun.practice.leetcode;

import java.util.*;

/** 384
 * Shuffle a set of numbers without duplicates.
 *
 * Example:
 *
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 *
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 *
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */
public class ShuffleAnArray {

    private static class Solution {
        int[] nums;
        int[] orig;
        Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            this.orig = new int[nums.length];
            for (int i = 0; i < nums.length; i++) orig[i] = nums[i];
            this.random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            for (int i = 0; i < orig.length; i++) nums[i] = orig[i];
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            // Fisher - Yates Algo for shuffle
            for (int i = nums.length-1; i >= 0; i--) {
                int j = random.nextInt(i+1);
                if (i != j) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
            return nums;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

}
