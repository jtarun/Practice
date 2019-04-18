package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 652
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return
 *  the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with same node values.
 */
public class FindDuplicateSubtrees {

     private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private static class Solution {
        private static class CountRef {
            int count;
            TreeNode ref;
            CountRef(int count, TreeNode ref) {
                this.count = count;
                this.ref = ref;
            }
        }

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new ArrayList<>();
            if (root == null) return res;

            Map<String, CountRef> h = new HashMap<>();
            helper(root, h);

            for (Map.Entry<String, CountRef> e : h.entrySet()) {
                CountRef cnt = e.getValue();
                if (cnt.count > 1) {
                    res.add(cnt.ref);
                }
            }

            return res;
        }

        private String helper(TreeNode root, Map<String, CountRef> h) {
            if (root == null) {
                return "#";
            }

            String left = helper(root.left, h);
            String right = helper(root.right, h);

            String res = left + " " + right + " " + root.val;

            CountRef cntRef = h.get(res);
            if (cntRef == null) {
                cntRef = new CountRef(1, root);
            } else {
                cntRef.count++;
            }

            h.put(res, cntRef);

            return res;
        }
    }

}
