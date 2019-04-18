package com.jtarun.practice.leetcode;


/** 153
 *
 *Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 *(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 *Find the minimum element.
 *
 *You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedArray {

    private static class Solution {
        public int findMin(int[] nums) {
            int lo = 0, hi = nums.length -1;

            while (lo < hi) {
                int mid = lo + (hi - lo)/2;
                if (nums[mid] > nums[hi]) lo = mid+1;
                else hi = mid;
            }

            return nums[lo];
        }
    }

}
