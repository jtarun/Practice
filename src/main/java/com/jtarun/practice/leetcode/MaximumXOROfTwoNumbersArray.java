package com.jtarun.practice.leetcode;


import java.util.HashSet;
import java.util.Set;

/** 421
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 *
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 *
 * Could you do this in O(n) runtime?
 */
public class MaximumXOROfTwoNumbersArray {

    private static class Solution {
        public int findMaximumXOR(int[] nums) {
            int res = 0, mask = 0;
            for (int i = 30; i >= 0; i--) {
                mask = mask | (1<<i);
                Set<Integer> s = new HashSet<>();
                for (int num : nums) {
                    s.add(num & mask);
                }
                int temp = res | (1<<i);
                for (int x: s) {
                    if (s.contains(x ^ temp)) {
                        res = temp;
                        break;
                    }
                }
            }

            return res;
        }
    }
}
