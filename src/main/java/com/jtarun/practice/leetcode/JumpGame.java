package com.jtarun.practice.leetcode;


/** 55
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 */
public class JumpGame {

    private static class Solution {
        public boolean canJump(int[] a) {
            int maxReached = a[0];
            for (int i = 1; i < a.length; i++) {
                if (i > maxReached) return false;
                if (i + a[i] > maxReached) maxReached = i + a[i];
                if (maxReached >= a.length-1) break;
            }

            return maxReached >= a.length-1;
        }
    }

}
