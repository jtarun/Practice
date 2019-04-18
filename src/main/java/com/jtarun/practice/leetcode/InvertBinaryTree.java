package com.jtarun.practice.leetcode;


/** 226
 * Invert a binary tree.
 */
public class InvertBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            invertTree(root.left);
            invertTree(root.right);
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;

            return root;
        }
    }

}
