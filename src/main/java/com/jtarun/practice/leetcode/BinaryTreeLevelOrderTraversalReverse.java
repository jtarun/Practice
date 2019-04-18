package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 107 (Easy)
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 */
public class BinaryTreeLevelOrderTraversalReverse {

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) {
        return res;
      }

      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root);
      while(!q.isEmpty()) {
        int cnt = q.size();
        List<Integer> t = new ArrayList<>();
        while (cnt-- > 0) {
          TreeNode front = q.poll();
          t.add(front.val);
          if (front.left != null) {
            q.offer(front.left);
          }
          if (front.right != null) {
            q.offer(front.right);
          }
        }
        res.add(t);
      }

      Collections.reverse(res);
      return res;
    }
  }

}
