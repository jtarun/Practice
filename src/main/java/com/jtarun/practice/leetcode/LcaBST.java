package com.jtarun.practice.leetcode;


/** 235
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LcaBST {


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
            if (root == null || p == null || q == null) {
                return null;
            }

            if (p.val > q.val) {
                return lowestCommonAncestor(root, q, p);
            }

            TreeNode res = null;
            while (root != null) {
                res = root;
                if (root.val > q.val) {
                    root = root.left;
                } else if (root.val < p.val) {
                    root = root.right;
                } else {
                    break;
                }
            }

            return res;
        }
    }

}
