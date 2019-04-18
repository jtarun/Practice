package com.jtarun.practice.leetcode;


/** 110 (Easy)
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  private static class Solution {
    private class IntWrapper {
      int val;
      IntWrapper(int val) {
        this.val = val;
      }
    }

    public boolean isBalanced(TreeNode root) {
      return isBalanced(root, new IntWrapper(0));
    }

    private boolean isBalanced(TreeNode root, IntWrapper height) {
      if (root == null) {
        height.val = 0;
        return true;
      }

      IntWrapper l = new IntWrapper(0), r = new IntWrapper(0);
      boolean lb = isBalanced(root.left, l);
      boolean rb = isBalanced(root.right, r);
      height.val = Math.max(l.val, r.val) + 1;

      return lb && rb && (Math.abs(l.val - r.val) <=1);
    }
  }
}
