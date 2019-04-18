package com.jtarun.practice.leetcode;

import java.util.*;

/** 40
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
 * in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSumII {

    private static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            helper(candidates, 0, 0, new ArrayList<>(), target, res);
            return res;
        }

        private void helper(int[] a, int ind, int sum, List<Integer> temp, int t, List<List<Integer>> res) {
            if (sum == t) {
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i = ind; i < a.length; i++) {
                if (i > ind && a[i] == a[i-1]) continue;

                if (sum + a[i] > t) break;
                temp.add(a[i]);

                helper(a, i+1, sum + a[i], temp, t, res);

                temp.remove(temp.size()-1);
            }

        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.combinationSum2(new int[]{3,1,3,5,1,1}, 8).forEach(list -> {
            list.forEach(x -> System.out.print(x + " "));
            System.out.println();
        });
    }
}
