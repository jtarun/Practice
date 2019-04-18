package com.jtarun.practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/** 106
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */
public class InorderPostorderToBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {


        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> h = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                h.put(inorder[i], i);
            }
            return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, h);
        }

        private TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> h) {
            if (is > ie || ps > pe) {
                return null;
            }

            TreeNode root = new TreeNode(postorder[pe]);
            int ind = h.get(postorder[pe]);
            int postInd = ps + (ind-is) - 1;
            root.left = helper(inorder, is, ind-1, postorder, ps, postInd, h);
            root.right = helper(inorder, ind+1, ie, postorder, postInd+1, pe-1, h);
            return root;
        }

        public TreeNode buildTree2(int[] inorder, int[] postorder) {
            return helper(inorder, 0, inorder.length - 1, postorder);
        }

        private TreeNode helper(int[] inorder, int i, int j, int[] postorder) {
            if (i > j || postorder == null) {
                return null;
            }

            int val = postorder[postorder.length - 1];
            int ind = find(inorder, i, j, val);
            int l = ind - i;
            int r = j - ind;

            Set<Integer> h = new HashSet<>();
            for (int p = i; p < ind; p++) {
                h.add(inorder[p]);
            }

            int[] preLeft = null, preRight = null;
            if (l > 0) {
                preLeft = new int[l];
            }
            if (r > 0) {
                preRight = new int[r];
            }

            int lind = 0, rind = 0;
            for (int p = 0; p <= postorder.length - 2; p++) {
                if (h.contains(postorder[p])) {
                    preLeft[lind++] = postorder[p];
                } else {
                    preRight[rind++] = postorder[p];
                }
            }

            TreeNode root = new TreeNode(val);
            root.left = helper(inorder, i, ind - 1, preLeft);
            root.right = helper(inorder, ind + 1, j, preRight);

            return root;
        }

        private int find(int[] a, int i, int j, int val) {
            for (int l = i; l <= j; l++) {
                if (a[l] == val) {
                    return l;
                }
            }
            return i;
        }
    }

}
