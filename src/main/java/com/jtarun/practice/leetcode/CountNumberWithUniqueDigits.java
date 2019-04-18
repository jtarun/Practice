package com.jtarun.practice.leetcode;

/** 357
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 *
 * Example:
 *
 * Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 *              excluding 11,22,33,44,55,66,77,88,99
 */
public class CountNumberWithUniqueDigits {

    private static class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) return 1;

            int res = 10, q = 9;
            for (int i = 2; i <= n; i++) {
                q = q*(10-i+1);
                res += q;
            }

            return res;
        }
    }

}
