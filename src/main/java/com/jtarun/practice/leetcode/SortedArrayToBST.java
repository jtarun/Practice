package com.jtarun.practice.leetcode;

/** 108
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth
 * of the two subtrees of every node never differ by more than 1.
 */
public class SortedArrayToBST {

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
      int n = nums.length;
      if ( n == 0) {
        return null;
      }

      return sortedArrayToBST(nums, 0 , n-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int i, int j) {
      if (i > j) {
        return null;
      }
      if ( i== j) {
        return new TreeNode(nums[i]);
      }

      int mid = i + (j - i) / 2;
      TreeNode t = new TreeNode(nums[mid]);
      t.left = sortedArrayToBST(nums, i, mid-1);
      t.right = sortedArrayToBST(nums, mid+1, j);
      return t;
    }
  }
}
