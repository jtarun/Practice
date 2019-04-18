package com.jtarun.practice.leetcode;


/* 326
 * Given an integer, write a function to determine if it is a power of three.
 */
public class PowerOfThree {

    private static class Solution {
        public boolean isPowerOfThree(int n) {
            if ( n <= 0) return false;

            while (n != 1) {
                if (n % 3 == 0) {
                    n = n/3;
                } else {
                    return false;
                }
            }

            return true;
        }
    }
}
