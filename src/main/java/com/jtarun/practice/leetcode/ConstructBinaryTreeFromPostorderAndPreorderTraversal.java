package com.jtarun.practice.leetcode;

/** 889
 * Return any binary tree that matches the given preorder and postorder traversals.
 *
 * Values in the traversals pre and post are distinct positive integers.
 *
 *
 *
 * Example 1:
 *
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 *
 *
 * Note:
 *
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 */
public class ConstructBinaryTreeFromPostorderAndPreorderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            int n = pre.length;
            if (n == 0) return null;

            return helper(pre, post, 0, n - 1, 0, n - 1);
        }

        private TreeNode helper(int[] pre, int[] post, int i1, int j1, int i2, int j2) {
            if (i1 > j1 || i2 > j2) return null;

            TreeNode root = new TreeNode(pre[i1]);
            for (int i = 0; i + i2 < j2; i++) {

                if (pre[i1 + 1] == post[i2 + i]) {
                    root.left = helper(pre, post, i1 + 1, i1 + i + 1, i2, i2 + i);
                    root.right = helper(pre, post, i1 + i + 2, j1, i2 + i + 1, j2 - 1);
                    break;
                }

            }

            return root;
        }

    }

}
