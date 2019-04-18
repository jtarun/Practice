package com.jtarun.practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 116
 */
public class PopulateNextRightPointersBinaryTree {

     private static class TreeLinkNode {
         int val;
         TreeLinkNode left, right, next;
         TreeLinkNode(int x) { val = x; }
     }

    private static class Solution {
        public void connect(TreeLinkNode root) {
            if (root == null) {
                return;
            }

            Queue<TreeLinkNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {

                int size = q.size();
                TreeLinkNode prev = null;
                while (size-- > 0) {

                    TreeLinkNode t = q.poll();

                    if (prev != null) {
                        prev.next = t;
                    }

                    prev = t;
                    if (t.left != null) q.offer(t.left);
                    if (t.right != null) q.offer(t.right);
                }

            }
        }
    }

}
