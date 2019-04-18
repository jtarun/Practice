package com.jtarun.practice.leetcode;

import java.util.*;

/** 1
 *Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> h = new HashMap<>();
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];

                if (h.containsKey(target-x)) {
                    res[0] = h.get(target-x);
                    res[1] = i;
                } else {
                    h.put(x, i);
                }

            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {2, 7, 11, 15};
        int target = 22;


        int[] res = sol.twoSum(nums, target);
        Arrays.stream(res).forEach(x -> System.out.println(x + " "));
        System.out.println();

    }
}
