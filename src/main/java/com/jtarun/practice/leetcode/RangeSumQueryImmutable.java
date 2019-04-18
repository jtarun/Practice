package com.jtarun.practice.leetcode;

/** 303
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 *  Your NumArray object will be instantiated and called as such:
 *  NumArray obj = new NumArray(nums);
 *  int param_1 = obj.sumRange(i,j);
 *
 */
public class RangeSumQueryImmutable {
    private static class NumArray {
        int[] nums;
        int[] tree;
        int n;

        public NumArray(int[] nums) {
            this.n = nums.length;
            this.nums = nums;
            this.tree = new int[4*n];
            construct(0, n-1, 0);
        }

        private void construct(int i, int j, int k) {
            if (i > j) return;

            if (i == j) {
                tree[k] = nums[i];
                return;
            }

            int mid = i + (j-i)/2;
            construct(i, mid, 2*k+1);;
            construct(mid+1, j, 2*k+2);

            tree[k] = tree[2*k+1] + tree[2*k+2];
        }

        public int sumRange(int i, int j) {
            return sumHelper(i, j, 0, n-1, 0);
        }

        private int sumHelper(int i, int j, int s, int e, int k) {
            if (s > j || e < i || s > e) return 0;

            if (s >= i && e <= j) return tree[k];

            int mid = s + (e - s)/2;
            return sumHelper(i, j, s, mid, 2*k+1) + sumHelper(i, j, mid+1, e, 2*k+2);

        }
    }

}
