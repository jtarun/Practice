package com.jtarun.practice.leetcode;

/** 154
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 */
public class MinimumInSortedArrayII {

    private static class Solution {

        public int findMin(int[] nums) {
            int lo = 0, hi = nums.length - 1;

            while (lo < hi) {

                int mid = lo + (hi - lo) / 2;
                if (nums[mid] > nums[hi]) {
                    lo = mid+1;
                } else if (nums[mid] < nums[hi]) {
                    hi = mid;
                } else {
                    hi--;
                }

            }

            return nums[lo];
        }

        public int findMin2(int[] nums) {
            return search(nums, 0, nums.length - 1);
        }

        private int search(int[] a, int lo, int hi) {
            if (lo > hi) return Integer.MAX_VALUE;

            while (lo < hi) {

                if (hi == lo + 1) {
                    return Math.min(a[lo], a[hi]);
                }

                int mid = lo + (hi - lo) / 2;

                if (a[mid] == a[lo] && a[mid] == a[hi]){
                    return Math.min(search(a, lo, mid), search(a, mid+1, hi));
                }

                if (a[lo] == a[mid]) {
                    lo = mid;
                }
                else if (a[mid] == a[hi]) {
                    hi = mid;
                } else if (a[mid] > a[hi]) {
                    lo = mid +1;
                } else {
                    hi = mid;
                }

            }

            return a[lo];
        }

    }

}
