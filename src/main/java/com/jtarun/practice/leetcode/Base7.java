package com.jtarun.practice.leetcode;

/** 504
 * Given an integer, return its base 7 string representation.
 *
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 */
public class Base7 {

    private static class Solution {
        public String convertToBase7(int num) {
            int sign = num < 0 ? -1 : 1;
            num = num*sign;
            int res = 0;
            while (num > 0) {
                res = res*10 + (num%7);
                num = num/7;
            }

            return String.valueOf(sign*res);
        }
    }

}
