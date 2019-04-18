package com.jtarun.practice.leetcode;

/** 404
 * Find the sum of all left leaves in a given binary tree.
 */
public class SumOfLeftLeaves {

     private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private static class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            return helper(root, -1);
        }

        private int helper(TreeNode root, int child) {

            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                if (child == 0) {
                    return root.val;
                }
                return 0;
            }

            int res = helper(root.left, 0);
            res += helper(root.right, 1);

            return res;
        }
    }
}
