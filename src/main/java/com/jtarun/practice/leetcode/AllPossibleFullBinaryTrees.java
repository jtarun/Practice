package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/** 894
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 *
 * Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of
 * one possible tree.
 *
 * Each node of each tree in the answer must have node.val = 0.
 *
 * You may return the final list of trees in any order.
 */
public class AllPossibleFullBinaryTrees {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public List<TreeNode> allPossibleFBT(int N) {
            if (N % 2 == 0) {
                return new ArrayList<>();
            }

            return helper(N);
        }

        private List<TreeNode> helper(int n) {
            if (n == 0) return new ArrayList<>();
            List<TreeNode> res = new ArrayList<>();
            if (n == 1) {
                TreeNode t = new TreeNode(0);
                res.add(t);
                return res;
            }

            for (int i = 2; i <= n; i += 2) {
                List<TreeNode> left = helper(i - 1);
                List<TreeNode> right = helper(n - i);

                for (int k = 0; k < left.size(); k++) {
                    for (int l = 0; l < right.size(); l++) {
                        TreeNode root = new TreeNode(0);
                        root.left = left.get(k);
                        root.right = right.get(l);
                        res.add(root);
                    }
                }
            }

            return res;
        }

    }

}
