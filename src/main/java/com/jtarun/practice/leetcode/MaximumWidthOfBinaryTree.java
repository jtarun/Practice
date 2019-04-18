package com.jtarun.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/** 662
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum
 * width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes
 * in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 */
public class MaximumWidthOfBinaryTree {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {

        class Pair {
            int left;
            int right;

            public Pair() {
                this.left = Integer.MAX_VALUE;
                this.right = Integer.MIN_VALUE;
            }
        }


        public int widthOfBinaryTree(TreeNode root) {
            Map<Integer, Pair> h = new HashMap<>();
            helper(root, 0, 0, h);
            int res = 0;
            for (int l = 0; h.get(l) != null; l++) {
                Pair p = h.get(l);
                res = Math.max(p.right - p.left + 1, res);
            }

            return res;
        }

        private void helper(TreeNode root, int level, int ind, Map<Integer, Pair> h) {
            if (root == null) {
                return;
            }

            Pair p = h.get(level);
            if (p == null) {
                p = new Pair();
            }
            p.left = Math.min(p.left, ind);
            p.right = Math.max(p.right, ind);
            h.put(level, p);

            helper(root.left, level + 1, 2 * ind, h);
            helper(root.right, level + 1, 2 * ind + 1, h);
        }
    }
}
