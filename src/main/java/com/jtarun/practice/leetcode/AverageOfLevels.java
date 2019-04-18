package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/** 637
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 */
public class AverageOfLevels {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                int cnt = size;
                Double val = 0.0;
                while (size-- > 0) {
                    TreeNode t = q.poll();
                    val += t.val;
                    if (t.left != null) {
                        q.offer(t.left);
                    }
                    if (t.right != null) {
                        q.offer(t.right);
                    }
                }
                val /= cnt;
                res.add(val);
            }
            return res;
        }
    }
}
