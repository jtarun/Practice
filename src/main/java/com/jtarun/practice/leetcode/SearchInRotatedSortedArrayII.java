package com.jtarun.practice.leetcode;

/** 81
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 */
public class SearchInRotatedSortedArrayII {

    private static class Solution {
        public boolean search(int[] nums, int target) {
            int lo = 0, hi = nums.length - 1;

            while (lo <= hi) {

                int mid = lo + (hi - lo) / 2;

                if (nums[mid] == target) {
                    return true;
                }

                if (nums[mid] == nums[lo] && nums[mid] == nums[hi]) {
                    lo++;
                    hi--;
                } else if (nums[mid] >= nums[lo]) {
                    if ((nums[mid] > target) && (nums[lo] <= target)) {
                        hi = mid-1;
                    } else {
                        lo = mid+1;
                    }
                } else {
                    if ((target <= nums[hi]) && (target > nums[mid])) {
                        lo = mid+1;
                    } else {
                        hi = mid-1;
                    }
                }

            }

            return false;

        }

    }

}
