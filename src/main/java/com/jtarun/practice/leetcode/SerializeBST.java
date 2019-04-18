package com.jtarun.practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/** 449
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can
 * be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be
 * serialized to a string and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms
 * should be stateless.
 */
public class SerializeBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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
                if (t.left == null) {
                    sb.append(",null");
                } else {
                    sb.append(",").append(t.left.val);
                    q.offer(t.left);
                }
                if (t.right == null) {
                    sb.append(",null");
                } else {
                    sb.append(",").append(t.right.val);
                    q.offer(t.right);
                }
            }

            return sb.toString();
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.length() == 0) return null;
            String[] tokens = data.split(",");

            int n = tokens.length;
            Queue<TreeNode> q = new LinkedList<>();
            TreeNode root = node(tokens[0]);
            q.offer(root);
            int i = 0;
            while (!q.isEmpty()) {
                TreeNode t = q.poll();
                if (t == null) {
                    continue;
                }
                if (i < n - 1) {
                    TreeNode left = node(tokens[i + 1]);
                    t.left = left;
                    if (left != null) {
                        q.offer(left);
                    }
                }
                if (i < n - 2) {
                    TreeNode right = node(tokens[i + 2]);
                    t.right = right;
                    if (right != null) {
                        q.offer(right);
                    }
                }

                i += 2;
            }
            return root;
        }


        private TreeNode node(String token) {
            TreeNode res = null;
            if (!token.equals("null")) {
                int val = Integer.parseInt(token);
                res = new TreeNode(val);
            }
            return res;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
