package com.jtarun.practice.leetcode;

/** 172
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class TrailingZeroes {

    private static class Solution {
        public int trailingZeroes(int n) {
            int res = 0;
            while (n > 0) {
                n = n/5;
                res += n;
            }

            return res;
        }
    }

}
