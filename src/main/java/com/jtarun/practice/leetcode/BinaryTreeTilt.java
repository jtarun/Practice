package com.jtarun.practice.leetcode;

/** 563
 * Given a binary tree, return the tilt of the whole tree.
 *
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values
 * and the sum of all right subtree node values. Null node has tilt 0.
 *
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 */
public class BinaryTreeTilt {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public int findTilt(TreeNode root) {
            int[] res = new int[1];
            helper(root, res);
            return res[0];
        }

        private int helper(TreeNode root, int[] res) {
            if (root == null) {
                return 0;
            }

            int l = helper(root.left, res);
            int r = helper(root.right, res);

            int tilt = Math.abs(l - r);
            res[0] += tilt;

            return l + r + root.val;
        }
    }

}
