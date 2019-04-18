package com.jtarun.practice.leetcode;

public class FirstAndLastPositionOfElementInSortedArray {

    private static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int lo = 0, hi=nums.length -1;
            int[] res = new int[]{-1,-1};
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] == target) {
                    res[0] = mid;
                    hi = mid-1;
                } else if (nums[mid] < target) {
                    lo = mid+1;
                } else {
                    hi = mid - 1;
                }
            }

            if (res[0] == -1) return res;

            hi = nums.length -1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] == target) {
                    res[1] = mid;
                    lo = mid+1;
                } else if (nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            return res;
        }
    }

}
