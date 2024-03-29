package com.jtarun.practice.leetcode;

import java.util.*;

/** 202
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {

    private static class Solution {

        public boolean isHappy(int n) {
            int fast = n, slow = n;
            do {
                slow = squareSum(slow);
                fast = squareSum(fast);
                fast = squareSum(fast);
            } while (fast != slow && slow != 1 && fast != 1);

            return fast == 1 || slow == 1;
        }

        public boolean isHappy2(int n) {
            Set<Integer> v = new HashSet<>();
            while (n != 1 && v.add(n)) {
                n = squareSum(n);
            }
            return n == 1;
        }

        private int squareSum(int n) {
            int res = 0;
            while (n > 0) {
                int d = n % 10;
                n /= 10;
                res += d*d;
            }
            return res;
        }
    }

}
