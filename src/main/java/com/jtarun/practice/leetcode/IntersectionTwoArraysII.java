package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/* 350
 * Given two arrays, write a function to compute their intersection.
 */
public class IntersectionTwoArraysII {
  private static int[] intersect(int[] nums1, int[] nums2) {
    int n = nums1.length, m = nums2.length;
    if (n == 0 || m == 0) {
      return new int[]{};
    }

    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0, j = 0;
    List<Integer> l = new ArrayList<>();
    while ( i < n && j < m) {
      if (nums1[i] == nums2[j]) {
        int d = nums1[i];
        i++;
        j++;
        int cnt1 = 1, cnt2 = 1, cnt;
        while (i < n && nums1[i] == nums1[i-1]) {
          cnt1++;
          i++;
        }
        while (j < m && nums2[j] == nums2[j-1]) {
          cnt2++;
          j++;
        }
        cnt = Math.min(cnt1, cnt2);
        for (int k = 0; k < cnt; k++) {
          l.add(d);
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
