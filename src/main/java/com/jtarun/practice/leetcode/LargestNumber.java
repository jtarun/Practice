package com.jtarun.practice.leetcode;

import java.util.*;

/** 179
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {

    private static class Solution {
        public String largestNumber(int[] nums) {
            if (nums.length == 0) return "";

            String[] numStr = new String[nums.length];
            for(int i = 0; i < nums.length; i++) numStr[i] = String.valueOf(nums[i]);
            Arrays.sort(numStr, (a , b) -> (b+a).compareTo(a+b));

            if (numStr[0].charAt(0) == '0') return "0";

            StringBuilder sb = new StringBuilder();
            for (String s : numStr) sb.append(s);

            return sb.toString();
        }
    }

}
