package com.jtarun.practice.leetcode;

public class SameTree {
  private static class Solution {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
        val = x;
      }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null && q == null) {
        return true;
      }

      if (p == null || q == null || p.val != q.val) {
        return false;
      }

      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
  }

  public static void main(String[] args) {


  }

}
