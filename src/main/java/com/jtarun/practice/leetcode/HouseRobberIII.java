package com.jtarun.practice.leetcode;

/** 337
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area,
 * called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief
 * realized that "all houses in this place forms a binary tree". It will automatically contact the police if two
 * directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 */
public class HouseRobberIII {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public int rob(TreeNode root) {
            int[] res = helper(root);
            return Math.max(res[0], res[1]);
        }

        private int[] helper(TreeNode root) {
            if (root == null) {
                return new int[2];
            }

            int[] left = helper(root.left);
            int[] right = helper(root.right);

            int[] res = new int[2];
            res[0] = root.val + left[1] + right[1];
            res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

            return res;
        }

    }

}
