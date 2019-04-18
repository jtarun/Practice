package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;


/** 863
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.
 * The answer can be returned in any order.
 */
public class AllNodesAtDistanceKBinaryTree {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<TreeNode> l = new ArrayList<>();
            dfs(root, target, new ArrayList<>(), l);

            List<Integer> res = new ArrayList<>();
            if (l.isEmpty()) return res;

            int n = l.size();
            distanceKBelow(target, 0, K, res);

            int i = n - 2;
            while (i >= 0) {
                TreeNode t = l.get(i);
                int d = n - 1 - i;
                if (d > K) {
                    break;
                } else if (d == K) {
                    res.add(t.val);
                    break;
                } else {
                    if (t.left == l.get(i + 1)) {
                        distanceKBelow(t.right, 0, K - (d + 1), res);
                    } else {
                        distanceKBelow(t.left, 0, K - (d + 1), res);
                    }
                }
                i--;
            }

            return res;
        }

        private void distanceKBelow(TreeNode root, int dist, int K, List<Integer> res) {
            if (root == null) return;

            if (dist == K) {
                res.add(root.val);
                return;
            }

            distanceKBelow(root.left, dist + 1, K, res);
            distanceKBelow(root.right, dist + 1, K, res);
        }


        private void dfs(TreeNode root, TreeNode target, List<TreeNode> temp, List<TreeNode> l) {
            if (root == null) {
                return;
            }

            if (root == target) {
                l.addAll(temp);
                l.add(root);
                return;
            }

            temp.add(root);
            dfs(root.left, target, temp, l);
            dfs(root.right, target, temp, l);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(0);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        root.left = two;
        root.right = one;
        one.left = three;

        System.out.println(sol.distanceK(root, three, 3));
    }

}
