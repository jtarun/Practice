package com.jtarun.practice.leetcode;

/**
 * 513
 * Given a binary tree, find the leftmost value in the last row of the tree.
 */
public class BottomLeftTreeValue {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public int findBottomLeftValue(TreeNode root) {
            return helper(root, 0)[0];
        }

        public Integer[] helper(TreeNode root, int level) {
            if (root == null) {
                return null;
            }

            Integer[] left = helper(root.left, level + 1);
            Integer[] right = helper(root.right, level + 1);

            Integer[] res;

            if (left == null && right == null) {
                res = new Integer[2];
                res[0] = root.val;
                res[1] = level;
            } else if (left == null) {
                res = right;
            } else if (right == null) {
                res = left;
            } else {
                if (left[1] >= right[1]) {
                    res = left;
                } else {
                    res = right;
                }
            }

            return res;
        }
    }

}
