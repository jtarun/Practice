package com.jtarun.practice.leetcode;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return
 * the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElementArray {

  private static class Solution {
    public int removeElement(int[] nums, int val) {
      int n = nums.length;

      int i = 0, j = -1;
      while ( i < n) {
        if (nums[i] != val) {
          nums[++j] = nums[i];
        }
        i++;
      }

      return j+1;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.removeElement(new int[]{3,2,2,3}, 3));
    System.out.println(sol.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
  }

}