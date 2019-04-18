package com.jtarun.practice.leetcode;

/** 260
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear
 * exactly twice. Find the two elements that appear only once.
 */
public class SingleNumberIII {
    private static class Solution {
        public int[] singleNumber(int[] nums) {
            int n = nums.length;

            int d = 0;
            for (int i = 0; i < n;i++) d ^= nums[i];

            int lsb = (d & (d-1)) ^ d;
            int one = 0, two = 0;
            for (int i =0; i < n; i++) {
                if ((lsb & nums[i]) == 0) {
                    two ^= nums[i];
                } else {
                    one ^= nums[i];
                }
            }

            return new int[]{one, two};
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int x : sol.singleNumber(new int[]{0,0,1,2})) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}
