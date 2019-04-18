package com.jtarun.practice.leetcode;

import java.util.*;

/** 560
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays
 * whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK {

    private static class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> h = new HashMap<>();
            h.put(0, 1);
            int sum = 0, res = 0;
            for (int num : nums) {
                sum += num;
                res += h.getOrDefault(sum-k, 0);
                h.put(sum, h.getOrDefault(sum, 0) + 1);
            }

            return res;
        }


        public int subarraySum2(int[] nums, int k) {
            int start = 0, end = 0, n = nums.length, sum = 0;
            int res = 0;
            while (end < n) {
                sum += nums[end];
                while (sum > k) {
                    sum -= nums[start++];
                }

                if (sum == k) res++;

                end++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.subarraySum(new int[]{-5,5,-6,6}, 0));
    }

}
