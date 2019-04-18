package com.jtarun.practice.leetcode;

/** 35
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 */
public class SearchInsertPosition {

    private static class Solution {
        public int searchInsert(int[] nums, int target) {
            int n = nums.length;
            if (n == 0) return 0;
            if (target > nums[n-1]) return n;

            int lo = 0, hi = n-1;

            while (lo < hi) {
                int mid = lo + (hi - lo)/2;
                if (nums[mid] >= target) hi = mid;
                else lo = mid+1;
            }

            return lo;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(sol.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(sol.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(sol.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }


}
