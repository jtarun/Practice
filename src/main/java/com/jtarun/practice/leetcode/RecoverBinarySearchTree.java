package com.jtarun.practice.leetcode;

/** 99
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 */
public class RecoverBinarySearchTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static class Solution {

        //1 2 3 4 6 5 7 8
        //1 2 5 4 6 3 7 8
        //1 2 8 4 5 6 7 3

        public void recoverTree(TreeNode root) {
            TreeNode[] first = new TreeNode[1];
            TreeNode[] second = new TreeNode[1];
            TreeNode[] prev = new TreeNode[1];

            inorder(root, prev, first, second);
            int temp = first[0].val;
            first[0].val = second[0].val;
            second[0].val = temp;
        }

        private void inorder(TreeNode root, TreeNode[] prev, TreeNode[] first, TreeNode[] second) {
            if (root == null) return;

            inorder(root.left, prev, first, second);

            if (prev[0] != null && root.val < prev[0].val) {
                if (first[0] == null) {
                    first[0] = prev[0];
                    second[0] = root;
                } else {
                    second[0] = root;
                }
            }

            prev[0] = root;

            inorder(root.right, prev, first, second);
        }


    }

}
