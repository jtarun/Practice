package com.jtarun.practice.leetcode;

/** 485
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 */
public class MaxConsecutiveOnes {

    private static class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int n = nums.length;

            int res = 0;

            int cur = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 1){
                    cur++;
                    res = Math.max(res, cur);
                } else {
                    cur = 0;
                }
            }

            return res;
        }
    }
}
