package com.jtarun.practice.leetcode;

import java.util.*;

/** 655
 * Print a binary tree in an m*n 2D string array following these rules:
 *
 * The row number m should be equal to the height of the given binary tree.
 *
 * The column number n should always be an odd number.
 *
 * The root node's value (in string format) should be put in the exactly middle of the first row it can be put.
 * The column and the row where the root node belongs will separate the rest space into two parts
 * (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and
 * print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have
 * the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none
 * subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are
 * none, then you don't need to leave space for both of them.
 *
 * Each unused space should contain an empty string "".
 *
 * Print the subtrees following the same rules.
 */
public class PrintBinaryTree {

     private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private static class Solution {
        public List<List<String>> printTree(TreeNode root) {
            int height = height(root);
            int col = (1 << height) - 1;

            String[][] t = new String[height][col];
            for(String[] row : t) Arrays.fill(row, "");

            helper(root, 0, 0, col-1, t);

            List<List<String>> res = new ArrayList<>();
            for (int i = 0 ; i < height; i++) {
                List<String> row = new ArrayList<>();
                for (int j = 0; j < col; j++) row.add(t[i][j]);
                res.add(row);
            }

            return res;
        }

        private void helper(TreeNode root, int level, int i, int j, String[][] t) {
            if (root == null) return;

            int mid = i + (j-i)/2;
            t[level][mid] = "" + root.val;

            helper(root.left, level+1, i, mid-1, t);
            helper(root.right, level+1, mid+1, j, t);
        }

        private int height(TreeNode root) {
            if (root == null) return 0;

            return Math.max(height(root.left), height(root.right))  +1;
        }
    }

}
