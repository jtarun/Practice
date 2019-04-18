package com.jtarun.practice.leetcode;


import java.util.HashSet;
import java.util.Set;

/** 217
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false
 * if every element is distinct.
 */
public class ContainsDuplicate {

    private static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> s = new HashSet<>();

            for (int num : nums) {
                if (!s.add(num)) return true;
            }

            return false;
        }
    }

}
