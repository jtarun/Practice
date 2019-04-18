package com.jtarun.practice.leetcode;

/** 693 (Easy)
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have
 * different values.
 */
public class BinaryNumberAlternatingBits {
    private static class Solution {
        public boolean hasAlternatingBits(int n) {
            return (((n ^ (n>>1)) + 1) &  n) == 0;
        }
    }
}
