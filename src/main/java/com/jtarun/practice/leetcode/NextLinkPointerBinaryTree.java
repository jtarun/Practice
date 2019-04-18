package com.jtarun.practice.leetcode;


/** 117
 * Given a binary tree, populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 */
public class NextLinkPointerBinaryTree {

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public void connect(TreeLinkNode root) {
            while (root != null) {
                TreeLinkNode dummy = new TreeLinkNode(0);
                TreeLinkNode t = dummy;
                while (root != null) {
                    if (root.left != null) {
                        t.next = root.left;
                        t = t.next;
                    }
                    if (root.right != null) {
                        t.next = root.right;
                        t = t.next;
                    }
                    root = root.next;
                }
                root = dummy.next;
            }
        }
    }
}
