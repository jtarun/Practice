package com.jtarun.practice.leetcode;

/** 669
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its
 * elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the
 * new root of the trimmed binary search tree.
 */
public class TrimBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null) return null;

            if (root.val < L) {
                root.left = null;
                return trimBST(root.right, L, R);
            }
            if (root.val > R) {
                root.right = null;
                return trimBST(root.left, L, R);
            }

            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);

            return root;
        }
    }

}
