package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/** 46
 * Given a collection of distinct integers, return all possible permutations.
 */
public class Permutation {
    private static class Solution {
        public List<List<Integer>> permute(int[] nums) {
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
                return;
            }

            for (int i = start; i < n; i++) {
                swap(nums, start, i);
                permute(nums, start+1, res);
                swap(nums, start, i);
            }
        }

        private void swap(int[] nums, int i,int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.permute(new int[]{1,2, 3}).forEach(l -> {
            l.forEach(x -> System.out.print(x + ","));
            System.out.println();
        });
    }
}
