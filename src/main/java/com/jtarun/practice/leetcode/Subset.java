package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/** 78
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 */
public class Subset {
    private static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            int n = nums.length;
            int total = 1 << n;
            for (int i = 0; i < total; i++) {
                List<Integer> t = new ArrayList<>();
                for (int j = 0; j < 31; j++) {
                    if (((1<<j) & i) != 0) {
                        t.add(nums[j]);
                    }
                }
                res.add(t);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.subsets(new int[]{1,2,3}));
    }
}
