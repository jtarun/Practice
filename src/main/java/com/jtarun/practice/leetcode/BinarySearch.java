package com.jtarun.practice.leetcode;

/** 704
 * Given a sorted (in ascending order) integer array nums of n elements and a target value,
 * write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 */
public class BinarySearch {

    private static class Solution {
        public int search(int[] nums, int target) {
            int lo = 0, hi = nums.length-1;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] < target) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }

            return (nums[lo] == target) ? lo : -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int res = sol.search(new int[]{-1,0,3,5,9,12}, 13);
        System.out.println(res);
    }

}
