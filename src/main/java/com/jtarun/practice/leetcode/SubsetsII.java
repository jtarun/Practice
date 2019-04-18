package com.jtarun.practice.leetcode;

import java.util.*;
import java.util.stream.Collectors;


/** 90
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 */
public class SubsetsII {
    private static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if ( n == 0) {
                return res;
            }
            Arrays.sort(nums);
            subsetsRec(nums, 0, new ArrayList<>(), res);
            return res;
        }

        private void subsetsRec(int[] nums, int ind, List<Integer> temp, List<List<Integer>> res) {
            int n = nums.length;
            if (ind == n) {
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i = ind; i < n; i++) {
                if (i > ind && (nums[i] == nums[i-1])) continue;
                temp.add(nums[i]);
                subsetsRec(nums, ind+1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }

        public List<List<Integer>> subsetsWithDup2(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            Comparator<List<Integer>> cmp = (l1 , l2) -> {
                for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
                    if (l1.get(i) == l2.get(i)) continue;
                    return Integer.compare(l1.get(i), l2.get(i));
                }
                return Integer.compare(l1.size(), l2.size());
            };

            Set<List<Integer>> res = new TreeSet<>(cmp);
            int total = 1<<n;
            for (int i = 0; i < total; i++) {
                int mask = 0x1;
                List<Integer> t = new ArrayList<>();
                for (int j = 0; j < 32; j++) {
                    if ((mask & i) != 0) {
                        t.add(nums[j]);
                    }
                    mask <<= 1;
                }
                res.add(t);
            }

            return res.stream().collect(Collectors.toList());
        }
    }
}
