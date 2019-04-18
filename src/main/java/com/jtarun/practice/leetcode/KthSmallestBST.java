package com.jtarun.practice.leetcode;

/** 230
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class KthSmallestBST {

     private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private static class Solution {
        public int kthSmallest(TreeNode root, int k) {
            int[] res = new int[1];
            helper(root, k, new int[1], res);
            return res[0];
        }

        private void helper(TreeNode root, int k, int[] count, int[] res) {
            if (root == null) {
                return;
            }

            helper(root.left, k, count, res);
            count[0]++;
            if (count[0] == k) {
                res[0] = root.val;
                return;
            }
            helper(root.right, k, count, res);

        }

    }


}
