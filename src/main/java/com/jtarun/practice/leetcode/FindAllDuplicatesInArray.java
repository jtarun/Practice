package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/** 442
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 */
public class FindAllDuplicatesInArray {

    private static class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                int ind = Math.abs(nums[i]);
                if (nums[ind-1] < 0) {
                    res.add(ind);
                } else {
                    nums[ind-1] = -nums[ind-1];
                }
            }

            return res;
        }
    }

}
