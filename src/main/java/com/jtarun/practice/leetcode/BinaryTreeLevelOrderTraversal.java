package com.jtarun.practice.leetcode;

import java.util.*;

/** 102 (Medium)
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

      List<List<Integer>> res = new ArrayList<>();
      if (root == null) {
        return res;
      }

      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root);
      while (!q.isEmpty()) {
        int cnt = q.size();
        List<Integer> t = new ArrayList<>();
        while (cnt-- > 0) {
          TreeNode cur = q.poll();
          t.add(cur.val);
          if (cur.left != null) {
            q.offer(cur.left);
          }
          if (cur.right != null) {
            q.offer(cur.right);
          }
        }
        res.add(t);
      }
      return res;
    }
  }

}
