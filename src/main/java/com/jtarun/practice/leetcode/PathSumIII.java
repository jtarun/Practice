package com.jtarun.practice.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class PathSumIII {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {

        public int pathSum(TreeNode root, int sum) {
            Map<Integer, Integer> prefix = new HashMap<>();
            prefix.put(0, 1);
            return helper(root, sum, 0, prefix);
        }

        private int helper(TreeNode root, int target, int curSum, Map<Integer, Integer> prefix) {
            if (root == null) {
                return 0;
            }

            curSum += root.val;
            int res = prefix.getOrDefault(curSum - target, 0);
            prefix.put(curSum, prefix.getOrDefault(curSum, 0) + 1);

            res += helper(root.left, target, curSum, prefix)
                    + helper(root.right, target, curSum, prefix);

            prefix.put(curSum, prefix.get(curSum) - 1);

            return res;
        }


        public int pathSum2(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }

            return pathSum(root.left, sum) + pathSum(root.right, sum) + pathSumFrom(root, sum);
        }

        private int pathSumFrom(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }

            int res = 0;
            if (sum == root.val) {
                res += 1;
            }

            res += pathSumFrom(root.left, sum - root.val);
            res += pathSumFrom(root.right, sum - root.val);

            return res;
        }
    }

    private static void print(TreeNode t) {
        if (t == null) {
            return;
        }
        System.out.println(t.val);
        print(t.left);
        print(t.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Integer[] arr = {10,5,-3,3,2,null,11,3,-2,null,1};

        int n = arr.length;
        int step = 1;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        q.offer(root);
        int i = 1;
        while (i < n && !q.isEmpty()) {
            int size = q.size();
            while (size-- > 0){
                TreeNode t = q.poll();
                if (i < n && arr[i] != null) {
                    t.left = new TreeNode(arr[i]);
                    q.add(t.left);
                }
                i++;
                if (i < n && arr[i] != null) {
                    t.right = new TreeNode(arr[i]);
                    q.add(t.right);
                }
                i++;
            }
        }

        //print(root);
        System.out.println(sol.pathSum(root,  8));
    }
}
