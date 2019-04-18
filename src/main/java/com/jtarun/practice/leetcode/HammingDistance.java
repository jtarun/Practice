package com.jtarun.practice.leetcode;


/* 461
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 231.
 */
public class HammingDistance {
    private static class Solution {
        public int hammingDistance(int x, int y) {
            int xor = x ^ y;
            int cnt = 0;
            while (xor != 0) {
                xor = xor & (xor-1);
                cnt++;
            }
            return cnt;
        }
    }
}
