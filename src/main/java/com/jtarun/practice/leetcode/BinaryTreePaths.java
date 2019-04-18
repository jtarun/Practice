package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * 257
 * Given a binary tree, return all root-to-leaf paths.
 */
public class BinaryTreePaths {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            helper(root, new ArrayList<>(), res);
            return res;
        }

        private void helper(TreeNode root, List<Integer> temp, List<String> res) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                StringBuilder sb = new StringBuilder();
                boolean first = true;
                temp.add(root.val);
                for (int v : temp) {
                    if (first) {
                        sb.append(v);
                        first = false;
                    } else {
                        sb.append("->").append(v);
                    }
                }
                temp.remove(temp.size() - 1);
                res.add(sb.toString());
                return;
            }

            temp.add(root.val);
            helper(root.left, temp, res);
            helper(root.right, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
