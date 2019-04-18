package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/** 515
 * You need to find the largest value in each row of a binary tree.
 */
public class LargestValueInEachRowBinaryTree {

     private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private static class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root, 1, res);
            return res;
        }

        private void helper(TreeNode root, int level, List<Integer> res) {
            if (root == null) {
                return;
            }

            if (res.size() < level) {
                res.add(root.val);
            } else {
                res.set(level-1, Math.max(res.get(level-1), root.val));
            }
            helper(root.left, level+1, res);
            helper(root.right, level+1, res);
        }
    }
}
