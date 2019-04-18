package com.jtarun.practice.leetcode;

/** 204
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {

    private static class Solution {

        // Optimization to consider only odd numbers.
        public int countPrimes(int n) {

            if (n < 3) return 0;

            int cnt = 1;
            int[] p = new int[n];
            for (int i = 3; i < n; i += 2) {
                if (p[i] == 0) {
                    cnt++;
                    for (int j = i; j < n; j += 2*i) {
                        p[j] = 1;
                    }
                }
            }

            return cnt;
        }

        public int countPrimes2(int n) {
            int cnt = 0;
            if (n <= 1) return 0;
            int[] p = new int[n];
            for (int i = 2; i < n; i++) {
                if (p[i] == 0) {
                    cnt++;
                    for (int j = i; j < n; j += i) {
                        p[j] = 1;
                    }
                }
            }

            return cnt;
        }
    }

}
