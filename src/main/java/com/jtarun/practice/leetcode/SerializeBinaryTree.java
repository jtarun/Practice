package com.jtarun.practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/** 297
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later
 * in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be
 * serialized to a string and this string can be deserialized to the original tree structure.
 */
public class SerializeBinaryTree {

     private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            while (!q.isEmpty()) {
                TreeNode t = q.poll();
                sb.append(",");
                if (t.left != null) {
                    q.offer(t.left);
                    sb.append(t.left.val);
                } else {
                    sb.append("null");
                }

                sb.append(",");
                if (t.right != null) {
                    q.offer(t.right);
                    sb.append(t.right.val);
                } else {
                    sb.append("null");
                }
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) {
                return null;
            }
            String[] tokens = data.split(",");
            Queue<TreeNode> q = new LinkedList<>();
            TreeNode root = node(tokens[0]);
            q.offer(root);
            int i = 1;
            int n = tokens.length;
            while (!q.isEmpty() && i < n) {

                TreeNode t = q.poll();
                TreeNode left = null;
                if (i < n)left = node(tokens[i++]);
                TreeNode right = null;
                if (i < n)right = node(tokens[i++]);

                t.left = left;
                t.right = right;

                if (left != null) q.offer(left);
                if (right != null)  q.offer(right);
            }

            return root;
        }

        private TreeNode node(String val) {
            if (val.equals("null")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(val));
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

}
