package com.jtarun.practice.leetcode;

import java.util.*;

/** 496
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, output -1 for this number.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 */
public class NextGreaterElementI {

    private static class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> h = new HashMap<>();
            Stack<Integer> s = new Stack<>();
            for (int num : nums2) {

                while (!s.isEmpty() && s.peek() < num) {
                    h.put(s.pop(), num);
                }

                s.push(num);
            }

            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = h.getOrDefault(nums1[i], -1);
            }

            return nums1;
        }
    }


}
