package com.jtarun.practice.leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 */
public class MedianTwoSortedArrays {

  static class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

      int n = nums1.length;
      int m = nums2.length;
      int t = n + m;

      if (n > m) return findMedianSortedArrays(nums2, nums1);

      boolean odd = (t & 0x1) == 1;
      int lo = 0, hi = n;
      double res = 0.0;
      while (lo <= hi) {

        int partitionX = (lo + hi) / 2;
        int partitionY = (t + 1) / 2 - partitionX;

        int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
        int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];

        int minRightX = partitionX == n ? Integer.MAX_VALUE : nums1[partitionX];
        int minRightY = partitionY == m ? Integer.MAX_VALUE : nums2[partitionY];

        if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
          if (odd) {
            res = Math.max(maxLeftX, maxLeftY);
          } else {
            res = ((double) Math.max(maxLeftX, maxLeftY) + (double) Math.min(minRightX, minRightY) ) / 2;
          }
          break;
        } else if (maxLeftX < minRightY){
          lo = partitionX + 1;
        } else {
          hi = partitionX - 1;
        }
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    int[] nums1 = {1,3};
    int[] nums2 = {2};
    System.out.println(sol.findMedianSortedArrays(nums1, nums2));

    int[] nums3 = {1,2};
    int[] nums4 = {3,4};
    System.out.println(sol.findMedianSortedArrays(nums3, nums4));
  }

}
