package com.jtarun.practice.interviewbit.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution3 {
  class TreeNode {
    int val;
    TreeNode parent;
    ArrayList<TreeNode> children;

    TreeNode(int val, TreeNode parent) {
      this.val = val;
      this.parent = parent;
      children = new ArrayList<>();
    }

    void addChild(TreeNode x) {
      this.children.add(x);
    }
  }

  TreeNode constructTree(ArrayList<Integer> a) {
    int n = a.size();
    if (n == 0) {
      return null;
    }
    TreeNode root = new TreeNode(0, null);
    HashMap<Integer, TreeNode> h = new HashMap<>();
    h.put(0, root);
    for (int i = 1; i < n; i++) {
      TreeNode parent = h.get(a.get(i));
      TreeNode x = new TreeNode(i, parent);
      parent.addChild(x);
      h.put(i, x);
    }

    return root;
  }

  public int solve(ArrayList<Integer> A) {
    if (A.size() <= 1) {
      return 0;
    }
    TreeNode root = constructTree(A);
    //return largestDist(root, new IntWrapper(0)) - 1;
    return largestDist(root, new IntWrapper(0));
  }


  int largestDist(TreeNode root, IntWrapper height) {
    // Find largest
    IntWrapper h1 = new IntWrapper(0);
    TreeNode prev = farthestNode(root, h1);
    TreeNode cur = prev.parent;
    int i = 0, res = 0;
    while (cur != null) {
      int maxChildDist = 0;
      i++;
      for (TreeNode child : cur.children) {
        if (child != prev) {
          IntWrapper h = new IntWrapper(0);
          farthestNode(child, h);
          maxChildDist = Math.max(maxChildDist, h.val);
        }
      }
      if ( cur.children.size() == 1) {
        res = Math.max(res, i);
      } else {
        res = Math.max(res, i + maxChildDist + 1);
      }
      prev = cur;
      cur = cur.parent;
    }
    return res;
  }

  TreeNode farthestNode(TreeNode root, IntWrapper height) {
    if (root == null) {
      height.val = 0;
      return null;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int level = -1, res = 0;
    TreeNode farthest = null;
    while (!q.isEmpty()) {
      int cnt = q.size();
      level++;
      while (cnt-- > 0) {
        TreeNode p = q.poll();
        if (p.children.size() == 0) {
          farthest = p;
          res = level;
        }
        q.addAll(p.children);
      }
    }

    height.val = res;
    return farthest;
  }


  int res = 0;
  int largestDist2(TreeNode root, IntWrapper height) {
    if (root == null) {
      return 0;
    }
    if (root.children.isEmpty()) {
      height.val = 1;
      return 0;
    }
    ArrayList<TreeNode> children = root.children;
    ArrayList<IntWrapper> heights = new ArrayList<>();
    for (int i = 0; i < children.size(); i++) {
      heights.add(new IntWrapper(0));
    }

    for (int i = 0; i < children.size(); i++) {
      largestDist(children.get(i), heights.get(i));
    }

    int max1 = heights.get(0).val, max2 = 0;
    for (int i = 1; i < heights.size(); i++) {
      int x = heights.get(i).val;
      if (x >= max1) {
        max2 = max1;
        max1 = x;
      } else if (x > max2) {
        max2 = x;
      }
    }
    height.val = max1 + 1;
    res = Math.max(res, max1 + max2 + 1);
    return res;
  }

  class IntWrapper {
    int val;

    IntWrapper(int val) {
      this.val = val;
    }
  }

}


public class LargestDistanceTree {
  public static void main(String[] args) {
    Solution3 sol = new Solution3();
    int res = sol.solve(new ArrayList<>(Arrays.asList(-1, 0, 1, 1, 3, 0, 4, 0, 2, 8, 9, 0, 4, 6, 12,
        14, 7, 9, 6, 4, 14, 13, 1, 9, 16, 17, 17, 0, 21, 10, 13, 14, 25, 28, 27, 0, 35, 20, 34, 23,
        37, 3, 6, 25, 30, 22, 15, 37, 8, 6, 11, 22, 50, 12, 4, 2, 54, 23, 18, 52, 34, 49, 61, 8, 15,
        63, 31, 51, 48, 41, 26, 37, 30, 15, 59, 12, 0, 40, 37, 73, 32, 19, 70, 29, 8, 21, 83, 33, 7,
        13, 12, 82, 43, 86, 38, 31, 1, 84, 62, 83)));
    //int res = sol.solve(new ArrayList<>(Arrays.asList(-1, 0,0,2,3)));
    System.out.println(res);
  }

}
