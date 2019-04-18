package com.jtarun.practice.leetcode;

/** 258
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 */
public class AddDigits {
    private static class Solution {
        public int addDigits(int n) {
            while ( n > 9) {
                n = sum(n);
            }
            return n;
        }

        private int sum(int n) {
            int res = 0;
            while (n > 0) {
                res += n % 10;
                n = n/10;
            }

            return res;
        }
    }

}
