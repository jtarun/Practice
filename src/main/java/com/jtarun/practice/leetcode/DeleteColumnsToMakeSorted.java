package com.jtarun.practice.leetcode;

/** 944 (Easy)
 * We are given an array A of N lowercase letter strings, all of the same length.
 *
 * Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those
 * indices.
 *
 * For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final
 * array after deletions is ["bef", "vyz"], and the remaining columns of A are ["b","v"], ["e","y"],
 * and ["f","z"].  (Formally, the c-th column is [A[0][c], A[1][c], ..., A[A.length-1][c]].)
 *
 * Suppose we chose a set of deletion indices D such that after deletions, each remaining column in A is in
 * non-decreasing sorted order.
 *
 * Return the minimum possible value of D.length.
 *
 * Example 1:
 *
 * Input: ["cba","daf","ghi"]
 * Output: 1
 * Explanation:
 * After choosing D = {1}, each column ["c","d","g"] and ["a","f","i"] are in non-decreasing sorted order.
 * If we chose D = {}, then a column ["b","a","h"] would not be in non-decreasing sorted order.
 */
public class DeleteColumnsToMakeSorted {

    private static class Solution {
        public int minDeletionSize(String[] A) {
            if (A == null || A.length <= 1) return 0;

            int l = A[0].length();
            int res = 0;
            for (int i = 0; i < l; i++) {
                if (!nonDecreasing(A, i)) res++;
            }
            return res;
        }


        boolean nonDecreasing(String[] a, int ind) {
            int n = a.length;
            for (int i = 1; i < n; i++) {
                char c = a[i-1].charAt(ind);
                char d = a[i].charAt(ind);
                if (d < c) return false;
            }
            return true;
        }
    }

}
