package com.jtarun.practice.leetcode;


/** 105
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 */
public class InorderPreorderToBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        int k = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return helper(preorder, inorder, 0, inorder.length - 1);
        }

        private TreeNode helper(int[] preorder, int[] inorder, int i, int j) {
            if (i > j) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[k]);
            int ind = search(inorder, i, j, preorder[k]);
            k++;
            root.left = helper(preorder, inorder, i, ind - 1);
            root.right = helper(preorder, inorder, ind + 1, j);

            return root;
        }

        private int search(int[] a, int i, int j, int val) {
            for (int k = i; k <= j; k++) {
                if (a[k] == val) {
                    return k;
                }
            }

            return -1;
        }
    }

}
