package com.jtarun.practice.leetcode;

import java.util.*;

public class IncreasingSubsequences {

    private static class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums.length <= 1) return ans;

            Set<List<Integer>> res = new HashSet<>();

            helper(nums, 0, new ArrayList<>(), res);

            ans.addAll(res);

            return ans;
        }

        private void helper(int[] nums, int s, List<Integer> temp, Set<List<Integer>> res) {
            if (temp.size() > 1) {
                res.add(new ArrayList<>(temp));
            }

            if (s == nums.length) return;

            for (int i = s; i < nums.length; i++) {
                boolean added = false;
                if (temp.isEmpty()) {
                    temp.add(nums[i]);
                    added = true;
                } else if (temp.get(temp.size()-1) <= nums[i]) {
                    temp.add(nums[i]);
                    added = true;
                }
                helper(nums, i+1, temp, res);
                if (added) {
                    temp.remove(temp.size()-1);
                }
            }
        }
    }

}
