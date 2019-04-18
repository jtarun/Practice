package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 872
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
public class LeafSimilar {


     private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private static class Solution {

        class Inorder{
            private TreeNode root;
            private Stack<TreeNode> s;
            private TreeNode cur;

            public Inorder(TreeNode root) {
                this.root = root;
                this.cur = root;
                this.s = new Stack<>();
            }

            public TreeNode nextLeaf() {
                if (cur == null && s.isEmpty()) {
                    return null;
                }

                while (!s.isEmpty() || cur != null) {
                    if (cur != null) {
                        s.push(cur);
                        cur = cur.left;
                    } else {
                        TreeNode t = s.pop();
                        if (t.left == null && t.right == null) {
                            return t;
                        }
                        cur = t.right;
                    }
                }

                return null;
            }
        }

        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            Inorder in1 = new Inorder(root1);
            Inorder in2 = new Inorder(root2);
            TreeNode leaf1 = null, leaf2 = null;
            do {

                leaf1 = in1.nextLeaf();
                leaf2 = in2.nextLeaf();

                if (leaf1 != null && leaf2 != null && leaf1.val != leaf2.val) {
                    return false;
                }

            } while(leaf1 != null && leaf2 != null);

            if (leaf1 == null && leaf2 == null) {
                return true;
            } else if (leaf1 == null || leaf2 == null) {
                return false;
            }

            return true;
        }

        public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
            List<TreeNode> t1 = new ArrayList<>();
            leaves(root1,t1);
            List<TreeNode> t2 = new ArrayList<>();
            leaves(root2, t2);

            if (t1.size() != t2.size()) {
                return false;
            }

            for (int i = 0; i < t1.size(); i++) {
                if (t1.get(i).val != t2.get(i).val) {
                    return false;
                }
            }
            return true;
        }

        private void leaves(TreeNode root, List<TreeNode> leaves) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                leaves.add(root);
                return;
            }
            leaves(root.left, leaves);
            leaves(root.right, leaves);
        }
    }
}
