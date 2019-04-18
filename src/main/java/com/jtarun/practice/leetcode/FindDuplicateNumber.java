package com.jtarun.practice.leetcode;

/** 287
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that
 * at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 */
public class FindDuplicateNumber {

    private static class Solution {
        public int findDuplicate(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int dest = Math.abs(nums[i]);
                if (nums[dest] < 0) return dest;
                nums[dest] = -nums[dest];
            }

            return 0;
        }
    }

}
