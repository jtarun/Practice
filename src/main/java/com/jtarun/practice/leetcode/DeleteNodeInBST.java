package com.jtarun.practice.leetcode;


/** 450
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root
 * node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 */
public class DeleteNodeInBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;

            if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else {

                if (root.left == null && root.right == null) {
                    return null;
                } else if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {

                    TreeNode t = root.right;
                    while (t.left != null) {
                        t = t.left;
                    }

                    root.val = t.val;
                    root.right = deleteNode(root.right, t.val);
                }

            }

            return root;
        }

    }

}
