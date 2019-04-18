package com.jtarun.practice.leetcode;


/** 222
 * Given a complete binary tree, count the number of nodes.
 */
public class CountCompleteTreeNodes {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public int countNodes(TreeNode root) {
            int res = 0;
            int level = level(root);
            while (root != null) {
                if (level(root.right) == level - 1) {
                    res += (1 << (level - 1)) - 1;
                    root = root.right;
                } else {
                    res += (1 << (level - 2)) - 1;
                    root = root.left;
                }
                res += 1;
                level--;
            }

            return res;
        }

        private int level(TreeNode root) {
            int res = 0;
            while (root != null) {
                res++;
                root = root.left;
            }
            return res;
        }

        public int countNodesBasic(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return 1 + countNodesBasic(root.left) + countNodesBasic(root.right);
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        root.left = two;
        root.right = three;
        two.left = four;
        //two.right = five;
        //three.left = six;

        //System.out.println(sol.countNodesBasic(root));
        System.out.println(sol.countNodes(root));
    }

}
