package com.jtarun.practice.leetcode;

import java.util.*;

/** 47
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class PermuteUnique {
    private static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            permute(nums, 0, res);
            return res;
        }

        private void permute(int[] nums, int start, List<List<Integer>> res) {
            int n = nums.length;

            if (start == n) {
                List<Integer> t = new ArrayList<>();
                for (int x : nums) {
                    t.add(x);
                }
                res.add(t);
            }

            Set<Integer> s = new HashSet<>();
            for (int i = start; i < n; i++) {
                if (s.add(nums[i])) {
                    swap(nums, i, start);
                    permute(nums, start + 1, res);
                    swap(nums, i, start);
                }
            }

        }

        private void swap(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.permuteUnique(new int[]{2,2,1,1}).forEach(l -> {
            l.forEach(x -> System.out.print(x  + ","));
            System.out.println();
        });
    }
}
