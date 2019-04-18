package com.jtarun.practice.leetcode;

/**
 * 654
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 */
public class MaximumBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        private TreeNode helper(int[] nums, int s, int e) {
            if (s > e) {
                return null;
            }

            int ind = max(nums, s, e);
            TreeNode root = new TreeNode(nums[ind]);
            root.left = helper(nums, s, ind - 1);
            root.right = helper(nums, ind + 1, e);

            return root;
        }

        private int max(int[] nums, int s, int e) {
            int res = s, max = nums[s];
            for (int i = s + 1; i <= e; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    res = i;
                }
            }
            return res;
        }
    }
}
