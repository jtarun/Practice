package com.jtarun.practice.leetcode;

/** 530
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values
 * of any two nodes.
 */
public class MinimumAbsoluteDifferenceInBST {

    private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private static class Solution {
        public int getMinimumDifference(TreeNode root) {
            int[] min = new int[]{Integer.MAX_VALUE};

            helper(root, min, new Integer[]{null});
            return min[0];
        }

        private void helper(TreeNode root, int[] min, Integer[] prev) {
            if (root == null) return;

            helper(root.left, min, prev);
            if (prev[0] != null) {
                min[0] = Math.min(min[0], root.val - prev[0]);
            }
            prev[0] = new Integer(root.val);
            helper(root.right, min, prev);
        }
    }

}
