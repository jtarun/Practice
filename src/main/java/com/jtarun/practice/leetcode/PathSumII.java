package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;


/** 113
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 */
public class PathSumII {
    private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            pathSum(root, sum, new ArrayList<>(), res);
            return res;
        }

        private void pathSum(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                if (root.val == sum) {
                    List<Integer> t = new ArrayList<>(temp);
                    t.add(root.val);
                    res.add(t);
                }
                return;
            }

            temp.add(root.val);
            pathSum(root.left, sum - root.val, temp, res);
            pathSum(root.right, sum - root.val, temp, res);
            temp.remove(temp.size() - 1);

        }
    }
}
