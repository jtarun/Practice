package com.jtarun.practice.leetcode;

/** 307
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 *  Your NumArray object will be instantiated and called as such:
 *  NumArray obj = new NumArray(nums);
 *  obj.update(i,val);
 *  int param_2 = obj.sumRange(i,j);
 *
 *
 */
public class RangeSumQueryMutable {

    private static class NumArray {

        private int[] a;
        private int n;
        private int[] bit;

        public NumArray(int[] nums) {
            this.n = nums.length;
            this.a = nums;
            this.bit = new int[n+1];
            for (int i = n-1; i >= 0; i--) {
                updateIncr(i+1, a[i]);
            }
        }


        public void update(int i, int val) {
            int diff = val - a[i];
            a[i] = val;
            updateIncr(i+1, diff);
        }

        private void updateIncr(int i, int val) {
            while (i <= n) {
                bit[i] += val;
                i += i & (-i);
            }
        }


        public int sumRange(int i, int j) {
            return (sumHelper(j) - sumHelper(i-1));
        }

        private int sumHelper(int i) {
            i++;
            int res = 0;
            while (i > 0) {
                res += bit[i];
                i = i & (i-1);
            }
            return res;
        }

    }

    private static class NumArray2 {

        private int n;
        private int[] nums;
        private int[] tree;

        public NumArray2(int[] nums) {
            this.n = nums.length;
            this.nums = nums;
            tree = new int[4 * n];
            construct(0, n-1, 0);
        }

        private void construct(int i, int j, int k) {
            if (i > j) return;

            if (i == j) {
                tree[k] = nums[i];
                return;
            }

            int mid = i + (j-i)/2;
            construct(i, mid, 2*k + 1);
            construct(mid+1, j, 2*k+2);

            tree[k] = tree[2*k+1] + tree[2*k+2];
        }

        public void update(int i, int val) {
            if ((i < 0) || (i >= n)) return;
            updateHelper(i, 0, n-1, 0, val, nums[i]);
            nums[i] = val;
        }

        private void updateHelper(int i, int s, int e, int k, int val, int curVal) {
            if ((i < s) || (i > e)) return;

            if (s == e) {
                tree[k] = tree[k] - curVal + val;
            }

            int mid = s + (e - s)/2;
            updateHelper(i, s, mid, 2*k+1, val, curVal);
            updateHelper(i, mid+1, e, 2*k+2, val, curVal);

            tree[k] = tree[k] - curVal + val;
        }

        public int sumRange(int i, int j) {
            return sumHelper(i, j, 0, n-1, 0);
        }

        private int sumHelper(int i, int j, int s, int e, int k) {
            if ((e < i) || (s > j) || (s > e)) return 0;

            if ( (s >= i) && (e <= j)) {
                return tree[k];
            }

            int mid = s + (e - s) / 2;
            return sumHelper(i, j, s, mid, 2*k+1) + sumHelper(i, j, mid+1, e, 2*k+2);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,3,5};
        NumArray numArray = new NumArray(a);
        System.out.println(numArray.sumRange(0,2));
    }

}
