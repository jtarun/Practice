package com.jtarun.practice.leetcode;


/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold
 * additional elements from nums2.
 */
public class MergeSortedArray {
  private static class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int i = m-1, j = n-1, k = n + m - 1;
      while ( i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
          nums1[k--] = nums1[i--];
        } else {
          nums1[k--] = nums2[j--];
        }
      }

      while ( j>= 0) {
        nums1[k--] = nums2[j--];
      }

    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    int m = 3, n = 3;
    int[] nums1 = new int[]{1,2,3,0,0,0};
    sol.merge(nums1, m, new int[]{2,5,6}, n);
    for (int i = 0; i < n + m; i++) {
      System.out.print(nums1[i] + ", ");
    }
  }
}
