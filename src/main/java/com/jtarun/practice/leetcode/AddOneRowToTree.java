package com.jtarun.practice.leetcode;

/** 623
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the
 * given depth d. The root node is at depth 1.
 *
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree
 * nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the
 * left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right
 * subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as
 * the new root of the whole original tree, and the original tree is the new root's left subtree.
 */
public class AddOneRowToTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (d == 1) {
                TreeNode t = new TreeNode(v);
                t.left = root;
                return t;
            }

            return helper(root, v, d);
        }

        private TreeNode helper(TreeNode root, int v, int d) {
            if (root == null) {
                return null;
            }

            if (d == 2) {
                TreeNode tl = new TreeNode(v);
                TreeNode tr = new TreeNode(v);

                tl.left = root.left;
                tr.right = root.right;
                root.left = tl;
                root.right = tr;
                return root;
            }

            root.left = helper(root.left, v, d - 1);
            root.right = helper(root.right, v, d - 1);

            return root;
        }
    }

}
