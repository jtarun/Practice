package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;


/** 501
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in
 * the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ModeInBST {


     private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private static class Solution {
        public int[] findMode(TreeNode root) {
            int[] max = new int[1];
            maxFrequency(root, new int[1], max, new Integer[1]);

            List<Integer> res = new ArrayList<>();

            getElementsWithFreq(root, new int[1], max[0], new Integer[1], res);

            int[] ans = new int[res.size()];
            int i = 0;
            for (int x : res) {
                ans[i++] = x;
            }

            return ans;
        }

        private void getElementsWithFreq(TreeNode root, int[] count, int freq, Integer[] prev, List<Integer> res) {
            if (root == null) {
                return;
            }

            getElementsWithFreq(root.left, count, freq, prev, res);

            if (prev[0] != null && prev[0].equals(root.val)) {
                count[0]++;
            } else {
                count[0] = 1;
            }
            if (count[0] == freq) {
                res.add(root.val);
            }
            prev[0] = root.val;

            getElementsWithFreq(root.right, count, freq, prev, res);

        }

        private void maxFrequency(TreeNode root, int[] count, int[] max, Integer[] prev) {
            if (root == null) {
                return;
            }

            maxFrequency(root.left, count, max, prev);
            if (prev[0] != null && prev[0].equals(root.val)) {
                count[0]++;
            } else {
                count[0] = 1;
            }

            if (count[0] > max[0]) {
                max[0] = count[0];
            }
            prev[0] = root.val;

            maxFrequency(root.right, count, max, prev);
        }
    }
}
