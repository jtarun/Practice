package com.jtarun.practice.leetcode;


/*
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at
 * coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at
 * (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.

 */
public class ContainerWithMostWater {
  private static class Solution {

    public int maxArea(int[] height) {
      int max = 0;

      int i = 0, j = height.length - 1;

      while (i < j) {

        max = Math.max(max, Math.min(height[i], height[j]) * (j - i));

        if (height[i] < height[j]) {
          i++;
        } else {
          j--;
        }
      }
      return max;
    }

      // brute force
    public int maxArea2(int[] height) {

      int max = 0;
      int n = height.length;
      for (int i = 0;  i < n-1; i++ ) {
        for ( int j = i+1 ; j < n; j++) {
          max = Math.max(Math.min(height[i], height[j]) * (j-i), max);
        }
      }

      return max;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] height = {1,8,6,2,5,4,8,3,7};
    System.out.println(sol.maxArea(height));
  }


}
