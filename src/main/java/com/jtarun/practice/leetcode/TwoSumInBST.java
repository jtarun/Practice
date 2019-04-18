package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 653
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that
 * their sum is equal to the given target.
 */
public class TwoSumInBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        private static class InorderLeft {
            TreeNode cur;
            Stack<TreeNode> s = new Stack<>();

            InorderLeft(TreeNode root) {
                this.cur = root;
            }

            TreeNode next() {
                if (s.isEmpty() && cur == null) return null;
                while (cur != null) {
                    s.push(cur);
                    cur = cur.left;
                }
                TreeNode t = s.pop();
                if (t.right != null) {
                    cur = t.right;
                }
                return t;
            }
        }

        private static class InorderRight {
            TreeNode cur;
            Stack<TreeNode> s = new Stack<>();

            InorderRight(TreeNode root) {
                this.cur = root;
            }

            TreeNode next() {
                if (s.isEmpty() && cur == null) return null;
                while (cur != null) {
                    s.push(cur);
                    cur = cur.right;
                }
                TreeNode t = s.pop();
                if (t.left != null) {
                    cur = t.left;
                }
                return t;
            }
        }


        public boolean findTarget(TreeNode root, int k) {
            if (root == null) return false;
            InorderLeft inl = new InorderLeft(root);
            InorderRight inr = new InorderRight(root);
            TreeNode l = inl.next(), r = inr.next();
            while (l != null && r != null && l != r) {
                int diff = l.val + r.val - k;
                if (diff == 0) {
                    return true;
                } else if (diff > 0) {
                    r = inr.next();
                } else l = inl.next();
            }

            return false;
        }


        public boolean findTarget2(TreeNode root, int k) {
            List<Integer> l = new ArrayList<>();
            inorder(root, l);

            int i = 0, j = l.size() - 1;
            while (i < j) {
                int sum = l.get(i) + l.get(j);
                if (sum == k) {
                    return true;
                } else if (sum < k) i++;
                else j--;
            }

            return false;
        }

        private void inorder(TreeNode root, List<Integer> l) {
            if (root == null) return;

            inorder(root.left, l);
            l.add(root.val);
            inorder(root.right, l);
        }
    }

}
