package com.jtarun.practice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 784
 * Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of
 * set bits in their binary representation.
 * (Recall that the number of set bits an integer has is the number of 1s present when written in binary.
 * For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)
 */
public class PrimeNumberOfSetBits {
    private static class Solution {
        public int countPrimeSetBits(int L, int R) {
            int res = 0;
            Set<Integer> primes = new HashSet<>();
            primes.addAll(Arrays.asList(2,3,5,7,11,13,17,19,23,29,31));
            for (int i = L; i <= R; i++) {
                if (primes.contains(count(i)))res++;
            }

            return res;
        }

        private int count(int n) {
            int cnt = 0;
            while (n != 0) {
                n = n & (n-1);
                cnt++;
            }
            return cnt;
        }

    }
}
