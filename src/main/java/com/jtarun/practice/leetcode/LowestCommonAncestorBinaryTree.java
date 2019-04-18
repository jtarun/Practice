package com.jtarun.practice.leetcode;

/**
 * 236
 */
public class LowestCommonAncestorBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            TreeNode l = lowestCommonAncestor(root.left, p, q);
            TreeNode r = lowestCommonAncestor(root.right, p, q);

            if (l != null && r != null) {
                return root;
            }

            if (root == p || root == q) return root;

            if (l == null) {
                return r;
            }

            return l;
        }
    }
}
