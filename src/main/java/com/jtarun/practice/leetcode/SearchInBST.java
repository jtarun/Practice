package com.jtarun.practice.leetcode;


/** 700
 *
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's
 * value equals the given value. Return the subtree rooted with that node. If such node doesn't exist,
 * you should return NULL.
 */
public class SearchInBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            TreeNode t = root;
            while (t != null) {
                if (t.val == val) {
                    break;
                } else if (t.val < val) {
                    t = t.right;
                } else {
                    t = t.left;
                }
            }

            return t;
        }
    }
}
