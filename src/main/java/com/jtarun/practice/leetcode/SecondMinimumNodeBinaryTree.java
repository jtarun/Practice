package com.jtarun.practice.leetcode;

/** 671
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree
 * has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among
 * its two sub-nodes.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in
 * the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 */
public class SecondMinimumNodeBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            int[] min1 = new int[]{Integer.MAX_VALUE};
            int[] min2 = new int[]{Integer.MAX_VALUE};
            helper(root, min1, min2);
            if (min2[0] == Integer.MAX_VALUE) {
                return -1;
            }
            return min2[0];
        }

        private void helper(TreeNode root, int[] min1, int[] min2) {
            if (root == null) {
                return;
            }

            helper(root.left, min1, min2);

            if (root.val < min1[0]) {
                min2[0] = min1[0];
                min1[0] = root.val;
            } else if (root.val != min1[0] && root.val < min2[0]) {
                min2[0] = root.val;
            }

            helper(root.right, min1, min2);
        }
    }

}
