package com.jtarun.practice.leetcode;

/** 606
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder
 * traversing way.
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis
 * pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 */
public class ConstructStringFromBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public String tree2str(TreeNode t) {
            StringBuilder sb = new StringBuilder();
            helper(t, sb);
            return sb.toString();
        }

        private void helper(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            boolean bracket = sb.length() != 0;
            if (bracket) {
                sb.append("(");
            }
            sb.append(root.val);
            if (root.left != null || root.right != null) {
                if (root.left != null) {
                    helper(root.left, sb);
                } else {
                    sb.append("()");
                }
                helper(root.right, sb);
            }
            if (bracket) sb.append(")");
        }
    }
}
