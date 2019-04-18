package com.jtarun.practice.leetcode;

/** 137
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
 * Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {
    private static class Solution {

        public int singleNumber2(int[] nums) {
            int first = 0, second = 0;
            for (int n : nums) {
                // bits that have appeared first time, and clear the bits that
                int firstTemp = (first ^ n) & ~(second & n);
                int secondTemp = (second ^ n) & ~firstTemp;

                first = firstTemp;
                second = secondTemp;
            }

            return first;
        }

        public int singleNumber(int[] nums) {
            int a = 0, b = 0;
            int n = nums.length;

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < 32; j++) {

                    int bit = 1 << j;
                    if ((bit & nums[i]) != 0) {
                        if ((bit & a) == 0) {
                            a |= bit;
                        } else if ((bit & b) == 0) {
                            b |= bit;
                        } else {
                            a = a & ~bit;
                            b = b & ~bit;
                        }
                    }

                }

            }

            return a;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.singleNumber2(new int[]{2,2,3,2}));
    }
}
