package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 199
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Map<Integer, Integer> h = new HashMap<>();

            helper(root, 0, h);

            for (int i = 0; h.get(i) != null; i++) {
                res.add(h.get(i));
            }

            return res;
        }

        private void helper(TreeNode root, int level, Map<Integer, Integer> h) {
            if (root == null) {
                return;
            }

            helper(root.left, level + 1, h);
            h.put(level, root.val);
            helper(root.right, level + 1, h);
        }
    }
}
