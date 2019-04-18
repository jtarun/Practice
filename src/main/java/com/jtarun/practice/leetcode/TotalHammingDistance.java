package com.jtarun.practice.leetcode;

import java.util.*;

/** 477
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 */
public class TotalHammingDistance {
    private static class Solution {
        public int totalHammingDistance(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> h = new HashMap<>();

            for (int x : nums) {
                for (int j = 0; j < 32; j++) {
                    if (((1<<j) & x) != 0) {
                        int cnt = h.getOrDefault(j, 0);
                        h.put(j, cnt+1);
                    }
                }
            }

            int res = 0;
            for (Map.Entry<Integer, Integer> e : h.entrySet()) {
                int c = h.getOrDefault(e.getKey(), 0);
                res += c * (n-c);
            }

            return res;
        }
    }
}
