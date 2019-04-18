package com.jtarun.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/** 219
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the
 * array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateII {

    private static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> h = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {

                if (h.containsKey(nums[i])) {
                    if ((i - h.get(nums[i])) <= k) return true;
                }
                h.put(nums[i], i);
            }

            return false;
        }
    }

}
