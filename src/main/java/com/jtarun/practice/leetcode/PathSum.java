package com.jtarun.practice.leetcode;

/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding
 * up all the values along the path equals the given sum.
 * Note: A leaf is a node with no children.
 */
public class PathSum {
  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
      if (root == null) {
        return false;
      }
      if (root.left == null && root.right == null) {
        return sum == root.val;
      }
      int diff = sum - root.val;
      return hasPathSum(root.left, diff) || hasPathSum(root.right, diff);
    }
  }

}
