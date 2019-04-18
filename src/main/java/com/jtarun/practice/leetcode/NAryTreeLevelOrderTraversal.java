package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 429
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 */
public class NAryTreeLevelOrderTraversal {
  private static class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  private static class Solution {
    public List<List<Integer>> levelOrder(Node root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) {
        return res;
      }
      Queue<Node> q = new LinkedList<>();
      q.offer(root);
      while (!q.isEmpty()) {
        int cnt = q.size();
        List<Integer> t = new ArrayList<>();
        while (cnt-- > 0) {
          Node top = q.poll();
          t.add(top.val);
          if (top.children != null) {
            for (Node child : top.children) {
              q.offer(child);
            }
          }
        }
        res.add(t);
      }
      return res;
    }
  }

}
