package com.jtarun.practice.leetcode;

/** 717
 * We have two special characters. The first character can be represented by one bit 0. The second character can be
 * represented by two bits (10 or 11).
 *
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or
 * not. The given string will always end with a zero.
 */
public class OneBitAndTwoBitCharacters {

    private static class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            int n = bits.length;
            if (n == 1) return true;
            int[] dp = new int[n];
            return isValid(bits, n-2, dp);
        }

        private boolean isValid(int[] bits, int n, int[] dp) {
            if (n < 0) return true;
            if (n==0) return bits[0] == 0;

            if (dp[n] != 0) return dp[n] == 1;

            boolean res = false;
            if ((bits[n-1] == 1) && (bits[n] == 0)) {
                res = isValid(bits, n-2, dp) || isValid(bits, n-1, dp);
            } else if ((bits[n-1] == 1) && (bits[n] == 1)) {
                res = isValid(bits, n-2, dp);
            } else if ((bits[n-1] == 0) && (bits[n] == 0)) {
                res = isValid(bits, n-1, dp);
            }

            dp[n] = res ? 1 : -1;

            return res;
        }
    }

}
