package com.jtarun.practice.leetcode;

/**
 * 33
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */
public class SearchInRotatedArray {

    private static class Solution {

        public int search(int[] nums, int target) {
            int n = nums.length;
            if ( n== 0) return -1;

            int lo = 0, hi = n - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] > nums[hi]) lo = mid+1;
                else hi = mid;
            }

            // lo==hi is the degree of rotation.

            if (target > nums[n-1]) {
                return binarySearch(nums, 0, lo-1, target);
            }
            return binarySearch(nums, lo, n-1, target);
        }

        public int search2(int[] nums, int target) {
            int n = nums.length;
            if (n == 0) return -1;

            if (nums[0] <= nums[n - 1]) {
                return binarySearch(nums, 0, n - 1, target);
            }

            int pivot = pivot(nums);

            if (nums[pivot] == target) return pivot;
            int res = binarySearch(nums, 0, pivot - 1, target);
            if (res != -1) return res;

            return binarySearch(nums, pivot + 1, n - 1, target);
        }

        private int binarySearch(int[] nums, int lo, int hi, int target) {

            while (lo <= hi) {

                int mid = lo + (hi - lo) / 2;

                if (nums[mid] == target) return mid;
                else if (nums[mid] < target) lo = mid + 1;
                else hi = mid - 1;
            }

            return -1;
        }

        private int pivot(int[] a) {
            int lo = 0, hi = a.length - 1;

            int res = -1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;

                if (hi == lo) {
                    res = lo;
                    hi--;
                } else if ((hi - lo) == 1) {
                    res = a[lo] > a[hi] ? lo : hi;
                    hi--;
                    lo++;
                } else if ((a[mid] > a[mid - 1]) && (a[mid] > a[mid + 1])) {
                    res = mid;
                    break;
                } else if (a[mid] > a[0]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            return res;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

}
