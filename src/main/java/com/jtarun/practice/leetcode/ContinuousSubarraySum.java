package com.jtarun.practice.leetcode;

import java.util.*;

/** 523
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a
 * continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is
 * also an integer.
 *
 * Example 1:
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 */
public class ContinuousSubarraySum {

    private static class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            if (nums.length <= 1) return false;

            k = Math.abs(k);

            if (k == 0) {
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i]== 0 && nums[i-1] == 0) return true;
                }
                return false;
            }

            Map<Integer, Integer> h = new HashMap<>();
            h.put(0, -1);

            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];

                sum += num;
                sum %= k;

                if (h.containsKey(sum)){
                    if (i-h.get(sum) > 1) return true;
                } else h.put(sum , i);
            }

            return false;
        }
    }

}
