package com.jtarun.practice.interviewbit.trees;


// Definition for binary tree
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

 class Solution {
   public int isValidBST(TreeNode a) {

     return isValidRec(a, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1: 0;

   }


   private boolean isValidRec(TreeNode root, int min, int max) {

     if (root == null) return true;

     if (root.val < min || root.val > max) return false;

     return isValidRec(root, min, root.val - 1) && isValidRec(root, root.val+1, max);

   }
}


public class ValidBinaryTree {

  public static void main(String[] args) {
    Solution sol = new Solution();

    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);

    n1.left = n2;
    n1.right = n3;
    n3.left = n4;
    n4.right = n5;




    int res = sol.isValidBST(n1);
    System.out.println(res);
  }
}
