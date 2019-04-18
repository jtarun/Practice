package com.jtarun.practice.leetcode;

import java.util.*;

/** 39
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSum {

    private static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            helper(candidates, target, res, 0, new ArrayList<>(), 0);
            return res;
        }

        private void helper(int[] a, int t, List<List<Integer>> res , int ind, List<Integer> temp, int sum) {
            if (sum == t) {
                res.add(new ArrayList<>(temp));
                return;
            }
            if (ind == a.length) return;

            for (int i = ind; i < a.length; i++) {
                 if (sum + a[i] > t) break;
                 temp.add(a[i]);
                 helper(a, t, res, i, temp, sum + a[i]);
                 temp.remove(temp.size()-1);
            }
        }

    }

}
