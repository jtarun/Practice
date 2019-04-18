package com.jtarun.practice.leetcode;


import java.util.ArrayList;
import java.util.List;

/** 95
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 */
public class UniqueBinarySearchTreesII {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public List<TreeNode> generateTrees(int n) {
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int i, int j) {
            if (i > j) {
                return new ArrayList<>();
            }

            List<TreeNode> res = new ArrayList<>();
            for (int l = i; l <= j; l++) {
                List<TreeNode> left = generateTrees(i, l - 1);
                List<TreeNode> right = generateTrees(l + 1, j);

                if (left.size() == 0 && right.size() == 0) {
                    res.add(new TreeNode(l));
                } else if (right.size() == 0) {

                    for (int p = 0; p < left.size(); p++) {
                        TreeNode root = new TreeNode(l);
                        root.left = left.get(p);
                        res.add(root);
                    }

                } else if (left.size() == 0) {

                    for (int p = 0; p < right.size(); p++) {
                        TreeNode root = new TreeNode(l);
                        root.right = right.get(p);
                        res.add(root);
                    }

                } else {
                    for (int p = 0; p < left.size(); p++) {
                        for (int q = 0; q < right.size(); q++) {
                            TreeNode root = new TreeNode(l);
                            root.left = left.get(p);
                            root.right = right.get(q);
                            res.add(root);
                        }
                    }
                }
            }

            return res;
        }
    }
}
