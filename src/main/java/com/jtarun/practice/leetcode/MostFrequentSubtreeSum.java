package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 508
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined
 * as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency
 * in any order.
 */
public class MostFrequentSubtreeSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public int[] findFrequentTreeSum(TreeNode root) {
            if (root == null) {
                return new int[]{};
            }
            Map<Integer, Integer> h = new HashMap<>();
            helper(root, h);
            int max = 0;
            for (Map.Entry<Integer, Integer> e : h.entrySet()) {
                if (e.getValue() > max) {
                    max = e.getValue();
                }
            }

            List<Integer> res = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : h.entrySet()) {
                if (e.getValue() == max) {
                    res.add(e.getKey());
                }
            }

            int[] ans = new int[res.size()];
            int i = 0;
            for (int x : res) {
                ans[i++] = x;
            }
            return ans;
        }

        private int helper(TreeNode root, Map<Integer, Integer> h) {
            if (root == null) {
                return 0;
            }

            int l = helper(root.left, h);
            int r = helper(root.right, h);

            int sum = l + r + root.val;
            int cnt = h.getOrDefault(sum, 0);
            h.put(sum, cnt + 1);

            return sum;
        }
    }

}
