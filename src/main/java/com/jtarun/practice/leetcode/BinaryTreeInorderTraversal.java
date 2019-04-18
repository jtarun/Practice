package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 94 (Medium)
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal {
    private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            TreeNode cur = root;
            Stack<TreeNode> s = new Stack<>();
            while (!s.isEmpty() || cur != null) {

                if (cur != null) {
                    s.push(cur);
                    cur = cur.left;
                } else {
                    TreeNode t = s.pop();
                    res.add(t.val);
                    if (t.right != null) {
                        cur = t.right;
                    }
                }

            }

            return res;
        }
    }
}
