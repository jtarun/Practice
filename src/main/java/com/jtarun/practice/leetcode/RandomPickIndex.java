package com.jtarun.practice.leetcode;

import java.util.*;

/** 398
 * Given an array of integers with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 *
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 *
 * Example:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 */
public class RandomPickIndex {

    private static class Solution {

        Map<Integer, List<Integer>> h = new HashMap<>();
        Random random = new Random();

        public Solution(int[] nums) {
            int i = 0;
            for (int n : nums) {
                h.computeIfAbsent(n, k -> new ArrayList<>()).add(i);
                i++;
            }
        }

        public int pick(int target) {
            List<Integer> l = h.get(target);
            int ind = random.nextInt(l.size());
            return l.get(ind);
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

}
