package com.jtarun.practice.leetcode;

import java.util.*;

/** 77
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
public class Combinations {

    private static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            helper(n, 1, k, new ArrayList<>(), res);
            return res;
        }

        private void helper(int n, int ind, int k, List<Integer> temp, List<List<Integer>> res) {
            if (temp.size() == k) {
                res.add(new ArrayList<>(temp));
                return;
            }
            if (ind > n) return;

            if (temp.size() < k) {
                temp.add(ind);
                helper(n, ind+1, k, temp, res);
                temp.remove(temp.size()-1);
            }

            helper(n, ind+1, k, temp, res);
        }
    }

}
