package com.jtarun.practice.leetcode;

/** 201
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range,
 * inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 */
public class BitwiseAndNumbersRange {

    private static class Solution {

        public int rangeBitwiseAndRec(int m, int n) {
            return m < n ? rangeBitwiseAndRec(m, n & n-1) : n;
        }

        public int rangeBitwiseAnd(int m, int n) {
            int cnt = 0;
            while (m != n) {
                m = m >>> 1;
                n = n >>> 1;
                cnt++;
            }

            return m << cnt;
        }

        public int rangeBitwiseAnd2(int m, int n) {
            int diff = n - m;

            for (int i = 0; i < 31; i++) {
                int x = 1 << i;
                if (diff > x) {
                    m = m & (m ^ (1 << i));
                }
            }

            return m&n;
        }
    }

}
