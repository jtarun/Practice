package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */
public class Preorder {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            Stack<TreeNode> s = new Stack<>();
            TreeNode cur = root;

            while (cur != null || !s.isEmpty()) {
                while (cur != null) {
                    res.add(cur.val);
                    s.push(cur);
                    cur = cur.left;
                }
                TreeNode t = s.pop();
                cur = t.right;
            }

            return res;
        }
    }

}
