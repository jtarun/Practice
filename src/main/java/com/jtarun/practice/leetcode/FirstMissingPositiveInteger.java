package com.jtarun.practice.leetcode;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 */
public class FirstMissingPositiveInteger {

    private static class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            int i = 0, j = n-1;
            while ( i <= j) {
                if (nums[i] <= 0 || nums[i] > n) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j--;
                } else i++;
            }

            if (j < 0) return 1;
            j = i-1;
            i = 0;
            while (i <= j) {
                int ind = Math.abs(nums[i]);
                if (ind > j+1){
                    i++;
                    continue;
                }
                if (nums[ind-1] > 0) {
                    nums[ind-1] *= -1;
                }
                i++;
            }

            for (int l = 0; l <= j; l++) {
                if (nums[l] > 0) return l+1;
            }

            return j+2;
        }
    }

    public static void main(String[] args) {
        Solution sol= new Solution();
        System.out.println(sol.firstMissingPositive(new int[]{3,4,-1,1}));
    }

}
