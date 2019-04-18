package com.jtarun.practice.leetcode;

import java.util.Stack;

/** 173
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 *
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class BSTIterator {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Stack<TreeNode> s = new Stack<>();
    private TreeNode cur;

    public BSTIterator(TreeNode root) {
        cur = root;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        if (cur == null && s.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        while (cur != null) {
            s.push(cur);
            cur = cur.left;
        }

        TreeNode t = s.pop();
        if (t.right != null) {
            cur = t.right;
        }
        return t.val;
    }

}
