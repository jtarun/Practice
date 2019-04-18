package com.jtarun.practice.leetcode;

/** 939
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between
 * L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 * Example 1:
 *
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 */
public class RangeSumOfBST {

    private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private static class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            if (root == null) return 0;
            int res = root.val >= L && root.val <= R ? root.val : 0;

            if (res != 0) {
                res += rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
            } else if (root.val < L) {
                res = rangeSumBST(root.right, L, R);
            } else {
                res = rangeSumBST(root.left, L, R);
            }
            return res;
        }
    }

}
