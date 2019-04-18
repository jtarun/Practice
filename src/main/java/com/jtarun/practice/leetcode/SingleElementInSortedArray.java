package com.jtarun.practice.leetcode;

/** 540
 * Given a sorted array consisting of only integers where every element appears twice except for one
 * element which appears once. Find this single element that appears only once.
 *
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class SingleElementInSortedArray {

    private static class Solution {
        public int singleNonDuplicate(int[] nums) {
            int lo = 0, hi = nums.length-1;

            while (lo < hi) {

                int  mid = lo + (hi - lo)/2;
                if (mid % 2 == 0) {
                    if (nums[mid+1] == nums[mid]) lo = mid+2;
                    else hi = mid;
                } else {
                    if (nums[mid+1] == nums[mid]) hi = mid-1;
                    else lo = mid+1;
                }

            }

            return nums[lo];
        }
    }

}
