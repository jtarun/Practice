package com.jtarun.practice.leetcode;

import java.util.*;

/** 919
 * A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled,
 * and all nodes are as far left as possible.
 *
 * Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following
 * operations:
 *
 * CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
 * CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains
 * complete, and returns the value of the parent of the inserted TreeNode;
 * CBTInserter.get_root() will return the head node of the tree.
 *
 *
 * Example 1:
 *
 * Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * Output: [null,1,[1,2]]
 */
public class CompleteBinaryTreeInserter {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private static class CBTInserterImpl {
        List<TreeNode> tree = new ArrayList<>();

        public CBTInserterImpl(TreeNode root) {
            tree.add(root);
            for (int i = 0; i < tree.size(); i++) {
                TreeNode cur = tree.get(i);
                if (cur.left != null) tree.add(cur.left);
                if (cur.right != null) tree.add(cur.right);
            }
        }

        public int insert(int v) {
            TreeNode n = new TreeNode(v);
            tree.add(n);
            int ind = tree.size()-1;
            int parentInd = (ind-1)/2;
            TreeNode parent = tree.get(parentInd);
            if (parent.left == null) parent.left = n;
            else parent.right = n;
            return parent.val;
        }

        public TreeNode get_root() {
            return tree.get(0);
        }
    }



    private static class CBTInserterImpl2 {

        TreeNode root;

        public CBTInserterImpl2(TreeNode root) {
            this.root = root;
        }

        public int insert(int v) {
            TreeNode n = new TreeNode(v);

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int res = -1;
            while (!q.isEmpty()) {

                TreeNode t = q.poll();
                if (t.left == null) {
                    t.left = n;
                    res = t.val;
                    break;
                } else {
                    q.offer(t.left);
                }

                if (t.right == null) {
                    t.right = n;
                    res = t.val;
                    break;
                } else {
                    q.offer(t.right);
                }

            }

            return res;
        }

        public TreeNode get_root() {
            return root;
        }
    }

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */

}
