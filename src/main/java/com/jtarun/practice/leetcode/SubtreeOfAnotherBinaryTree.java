package com.jtarun.practice.leetcode;


/** 572
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with
 * a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 */
public class SubtreeOfAnotherBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (t == null) {
                return true;
            }
            if (s == null) {
                return false;
            }

            if (t.val == s.val) {
                if (helper(s, t)) return true;
            }

            if (isSubtree(s.left, t)) return true;
            return isSubtree(s.right, t);
        }

        private boolean helper(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            }
            if (s == null || t == null || s.val != t.val) {
                return false;
            }

            boolean l = helper(s.left, t.left);
            boolean r = helper(s.right, t.right);

            return l && r;
        }
    }

}
