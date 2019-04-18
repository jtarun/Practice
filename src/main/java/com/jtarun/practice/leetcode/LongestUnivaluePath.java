package com.jtarun.practice.leetcode;

/** 687
 * Given a binary tree, find the length of the longest path where each node in the path has the same value.
 * This path may or may not pass through the root.
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class LongestUnivaluePath {

     private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private static class Solution {
        public int longestUnivaluePath(TreeNode root) {
            if (root == null) return 0;
            int[] max = new int[]{0};
            helper(root, root.val, max);
            return max[0];
        }

        private int helper(TreeNode root, int val, int[] max) {
            if (root == null) return 0;

            int l = helper(root.left, root.val, max);
            int r = helper(root.right, root.val, max);

            int d = l + r;
            if (d > max[0]) {
                max[0] = d;
            }

            if (root.val != val) return 0;

            return Math.max(l, r) + 1;
        }



        public int longestUnivaluePath2(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int l = longestUnivaluePath2(root.left);
            int r = longestUnivaluePath2(root.right);

            int throughRoot = longestUnivaluePathFrom(root.left, root.val) + longestUnivaluePathFrom(root.right, root.val);

            return max(l, r, throughRoot);
        }

        private int longestUnivaluePathFrom(TreeNode root, int val) {
            if (root == null) return 0;
            if (root.val != val) return 0;

            return Math.max(longestUnivaluePathFrom(root.left, val), longestUnivaluePathFrom(root.right, val)) + 1;
        }

        private int max(int x, int y, int z) {
            return Math.max(x, Math.max(y, z));
        }
    }

}
