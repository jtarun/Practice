package com.jtarun.practice.leetcode;

/** 897
 * Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree,
 * and every node has no left child and only 1 right child.
 */
public class IncreasingOrderSearchTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode left = increasingBST(root.left);
            TreeNode right = increasingBST(root.right);

            root.right = right;
            if (left == null) {
                return root;
            }

            root.left = null;

            TreeNode t = left;
            while (t.right != null) {
                t = t.right;
            }
            t.right = root;

            return left;
        }
    }

}
