package com.jtarun.practice.leetcode;

/*
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to
 * the nearest leaf node.
 * Note: A leaf is a node with no children.
 */
public class MinimumDepthBinaryTree {
  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public int minDepth(TreeNode root) {
      if (root == null)  return 0;

      int l = minDepth(root.left);
      int r = minDepth(root.right);

      if ( l == 0) return r + 1;
      if ( r == 0) return l + 1;

      return Math.min(l, r) + 1;
    }
  }

}
