package com.jtarun.practice.leetcode;

import java.util.*;

/** 216
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be
 * used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {

    private static class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();

            helper(1, new ArrayList<>(), res, k, 0, n);
            return res;
        }

        private void helper(int id, List<Integer> temp, List<List<Integer>> res, int k, int sum, int target) {
            if (sum == target && temp.size() == k) {
                res.add(new ArrayList<>(temp));
                return;
            }
            if (id > 9) return;

            for (int i = id; i <= 9; i++) {
                if (sum + i > target) break;

                if (temp.size() < k) {
                    temp.add(i);
                    helper(i+1, temp, res, k, sum+i, target);
                    temp.remove(temp.size()-1);
                }

            }

        }
    }

}
