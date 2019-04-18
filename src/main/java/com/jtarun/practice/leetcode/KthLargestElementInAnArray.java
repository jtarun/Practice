package com.jtarun.practice.leetcode;

import java.util.*;

/** 215
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray {

    private static class Solution {

        // Binary Search
        public int findKthLargest(int[] nums, int k) {
            int lo = Integer.MIN_VALUE, hi =Integer.MAX_VALUE;

            while (lo < hi) {

                int mid = (int)((long)lo + ((long)hi - (long)lo) / 2);

                int n = countGreater(nums, mid);

                if (n > k-1) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }

            }

            return lo;
        }

        private int countGreater(int[] a, int v) {
            int cnt = 0;
            for (int x: a) {
                if (x > v) cnt++;
            }
            return cnt;
        }

        public int findKthLargest2(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length-k];
        }
    }

}
