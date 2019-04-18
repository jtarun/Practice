package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 349
 * Given two arrays, write a function to compute their intersection.
 */
public class IntersectionTwoArrays {
  private static class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      int n = nums1.length, m = nums2.length;
      if (n == 0 || m == 0) {
        return new int[]{};
      }
      int i = 0, j = 0;
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      List<Integer> l = new ArrayList<>();
      while ( i < n && j < m) {
        if (nums1[i] == nums2[j]) {
          l.add(nums1[i]);
          i++;
          j++;
          while ( i < n && nums1[i] == nums1[i-1]) {
            i++;
          }
          while ( j < m && nums2[j] == nums2[j-1]) {
            j++;
          }
        } else if (nums1[i] < nums2[j]) {
          i++;
        } else {
          j++;
        }
      }
      int[] res = new int[l.size()];
      for (int k = 0; k < l.size(); k++) {
        res[k] = l.get(k);
      }
      return res;
    }
  }

}
