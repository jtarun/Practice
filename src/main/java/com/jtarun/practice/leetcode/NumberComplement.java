package com.jtarun.practice.leetcode;

/* 476
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary
 * representation.
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 */
public class NumberComplement {
    private static class Solution {
        public int findComplement(int num) {
            int mask = mask(num);
            return mask ^ num;
        }

        private int mask(int n) {
            n = n | (n >> 1);
            n = n | (n >> 2);
            n = n | (n >> 4);
            n = n | (n >> 8);
            n = n | (n >> 16);
            return n;
        }
    }
}
