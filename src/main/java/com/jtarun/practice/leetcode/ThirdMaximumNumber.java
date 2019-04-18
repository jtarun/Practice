package com.jtarun.practice.leetcode;

/** 414
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 */
public class ThirdMaximumNumber {

    private static class Solution {

        public int thirdMax(int[] nums) {
            int n = nums.length;

            // Find 3 distinct numbers first.

            int first = nums[0], i = 1;
            while ( i < n && nums[i] == first)i++;
            if ( i == n) return first;
            int second = nums[i++];
            while (i < n && (nums[i] == second || nums[i] == first)) i++;
            if (i == n) return Math.max(first, second);
            int third = nums[i++];

            // set the numbers in ascending order
            int max = Math.max(first, Math.max(second, third));
            int min = Math.min(first, Math.min(second, third));
            int middle = max ^ min ^ first ^ second ^ third;
            first = max;
            second = middle;
            third = min;

            // Process rest of elements.
            while ( i < n) {
                int x = nums[i];
                if (x != first && x != second && x != third) {
                    if (x > first) {
                        third = second;
                        second = first;
                        first = x;
                    } else if (x > second) {
                        third = second;
                        second = x;
                    } else if (x > third){
                        third = x;
                    }
                }

                i++;
            }

            return third;
        }

        public int thirdMax2(int[] nums) {
            int n = nums.length;

            int first = Integer.MIN_VALUE;
            int third = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;
            boolean minFound = false;
            for (int i = 0; i < n; i++) {
                int x = nums[i];
                if (x == Integer.MIN_VALUE) minFound = true;

                if (x == first || x == second || x == third) {
                } else if (x > first) {
                    third = second;
                    second = first;
                    first = x;
                } else if (x > second && x < first) {
                    third = second;
                    second = x;
                } else if (x > third && x < second) {
                    third = x;
                }
            }

            if (minFound && second > Integer.MIN_VALUE) return third;

            return third == Integer.MIN_VALUE ? first : third;
        }

    }

}
