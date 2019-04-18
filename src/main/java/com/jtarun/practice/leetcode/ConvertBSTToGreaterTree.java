package com.jtarun.practice.leetcode;

/** 538
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed
 * to the original key plus sum of all keys greater than the original key in BST.
 */
public class ConvertBSTToGreaterTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public TreeNode convertBST(TreeNode root) {
            helper(root, 0);
            return root;
        }

        private int helper(TreeNode root, int add) {
            if (root == null) {
                return 0;
            }

            int r = helper(root.right, add);
            int sum = r + root.val;
            root.val += r + add;
            int l = helper(root.left, root.val);

            return sum + l;
        }
    }

}
