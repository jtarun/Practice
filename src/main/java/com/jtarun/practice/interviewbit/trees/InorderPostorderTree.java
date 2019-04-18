package com.jtarun.practice.interviewbit.trees;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution3 {
  public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {

    return buildTree(inorder, 0 , inorder.size()-1, postorder);

  }

  TreeNode buildTree(ArrayList<Integer> inorder, int i, int j, ArrayList<Integer> postorder){

    if ( i > j || postorder.isEmpty()) return null;

    int target = postorder.get(postorder.size()-1);
    TreeNode n = new TreeNode(target);

    if (postorder.size() == 1) return n;

    int ind = find(inorder, i, j, target);
    HashSet<Integer> left = new HashSet<>();
    for (int k = i; k <= ind-1; k++) {
      left.add(inorder.get(k));
    }

    ArrayList<Integer> lvals = new ArrayList<>();
    ArrayList<Integer> rvals = new ArrayList<>();

    for (int k = 0; k < postorder.size() - 1; k++) {
      Integer val = postorder.get(k);
      if (left.contains(val)) lvals.add(val);
      else rvals.add(val);
    }


    n.left = buildTree(inorder, i, ind-1, lvals);
    n.right = buildTree(inorder, ind+1, j, rvals);

    return n;
  }

  private int find(ArrayList<Integer> a, int i, int j, int val) {
    int res = -1;
    for (int k = i; k <=j; k++) {
      if (a.get(k) == val) {
        res = k;
        break;
      }
    }
    return res;
  }
}


public class InorderPostorderTree {

  static void inorder(TreeNode a ) {
    if (a == null) return;
    inorder(a.left);
    System.out.print(a.val + " ");
    inorder(a.right);
  }

  static void postorder(TreeNode a) {
    if (a == null) return;
    postorder(a.left);
    postorder(a.right);
    System.out.print(a.val + " ");
  }

  public static void main(String[] args) {
    Solution3 sol = new Solution3();
    ArrayList<Integer> inorder = new ArrayList<>(Arrays.asList(7, 5, 6, 2, 3, 1, 4));
    ArrayList<Integer> postorder = new ArrayList<>(Arrays.asList(5, 6, 3, 1, 4, 2, 7));
    TreeNode root = sol.buildTree(inorder, postorder);
    inorder(root);
    System.out.println();
    postorder(root);
  }

}
