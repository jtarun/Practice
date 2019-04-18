package com.jtarun.practice.leetcode;


/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear
 * only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 */
public class RemoveDuplicatesSortedArray {
  private static class Solution {
    public int removeDuplicates(int[] nums) {
      int n =  nums.length;
      if (n <= 1) {
        return n;
      }
      int i = 1, k = 1;
      while ( i < n) {
        if (nums[i] != nums[i-1]) {
          nums[k++] = nums[i];
        }
        i++;
      }

      return k;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.removeDuplicates(new int[]{1,1,2}));
    System.out.println(sol.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
  }


}
