package com.jtarun.practice.leetcode;

/** 167
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add
 * up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * Note:
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 */
public class TwoSumII {

    private static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i = 0, j = numbers.length-1;

            while (i < j) {
                int diff = numbers[i] - target + numbers[j];
                if (diff == 0) {
                    break;
                } else if (diff > 0) {
                    j--;
                } else i++;
            }

            return new int[]{i+1,j+1};
        }
    }
}
