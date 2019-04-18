package com.jtarun.practice.leetcode;

import java.util.*;

/** 368
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in
 * this subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 *
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 */
public class LargestDivisibleSubset {

    private static class Solution {

        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            if (n == 0) return new ArrayList<Integer>();

            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int[] ind = new int[n];
            Arrays.fill(ind, -1);

            int max = 1, maxi = 0;
            List<Integer> res = new ArrayList<>();
            for (int j = 1; j < n; j++) {
                for (int i = 0; i <j; i++) {

                    if (nums[j]%nums[i] == 0) {
                        if (dp[i] + 1 > dp[j]) {
                            dp[j] = dp[i] + 1;
                            ind[j] = i;
                        }
                    }

                }

                if (max < dp[j]) {
                    max = dp[j];
                    maxi = j;
                }
            }

            while (maxi != -1) {
                res.add(nums[maxi]);
                maxi = ind[maxi];
            }

            return res;
        }

        // TLE
        public List<Integer> largestDivisibleSubsetDFS(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            Map<Integer, List<Integer>> h = new HashMap<>();
            for (int i = 0; i < n; i++) {
                h.put(i, new ArrayList<>());
                for (int j = i+1; j < n; j++) {
                    if (nums[j] % nums[i] == 0) {
                        h.get(i).add(j);
                    }
                }
            }

            List<Integer> res = new ArrayList<>();
            boolean[] v = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!v[i]) {
                    List<Integer> l = new ArrayList<>();
                    dfs(h, i, v, l, new ArrayList<>());
                    if (l.size() > res.size()) res = l;
                }
            }

            for (int i = 0; i < res.size(); i++) {
                res.set(i, nums[i]);
            }

            return res;
        }

        private void dfs(Map<Integer, List<Integer>> h, int root, boolean[] v, List<Integer> res, List<Integer> temp) {
            v[root] = true;
            temp.add(root);
            if (h.get(root).isEmpty()) {
                if (res.size() < temp.size()) {
                    res.clear();
                    res.addAll(temp);
                }
            }

            for (int child : h.get(root)) {
                dfs(h, child, v, res, temp);
            }

            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] set = {2,3,4,9,8};

        for (Integer integer : sol.largestDivisibleSubset(set)) {
            System.out.println(integer);
        }
    }

}
