package com.jtarun.practice.leetcode;

/** 543
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is
 * the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 */
public class DiameterOfBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            return helper(root, new int[1]);
        }

        private int helper(TreeNode root, int[] h) {
            if (root == null) {
                return 0;
            }

            int[] lh = new int[1];
            int[] rh = new int[1];
            int l = helper(root.left, lh);
            int r = helper(root.right, rh);

            h[0] = Math.max(lh[0], rh[0]) + 1;

            return Math.max(lh[0] + rh[0], Math.max(l, r));
        }
    }

}
