package com.jtarun.practice.leetcode;


/** 114
 * Given a binary tree, flatten it to a linked list in-place.
 */
public class FlattenBinaryTreeToLinkedList {

     private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private static class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten(root.left);
            flatten(root.right);

            if (root.left == null) {
                return;
            }

            TreeNode t = root.left;
            while (t.right != null) {
                t = t.right;
            }

            t.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }


}
