package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 103 (Medium)
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            boolean odd = true;
            while (!q.isEmpty()) {
                int cnt = q.size();
                List<Integer> t = new ArrayList<>();
                while (cnt-- > 0) {
                    TreeNode front = q.poll();
                    t.add(front.val);
                    if (front.left != null) {
                        q.offer(front.left);
                    }
                    if (front.right != null) {
                        q.offer(front.right);
                    }
                }
                if (!odd) {
                    Collections.reverse(t);
                }
                odd = !odd;
                res.add(t);
            }

            return res;
        }
    }

}
