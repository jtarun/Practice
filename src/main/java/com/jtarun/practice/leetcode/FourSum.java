package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in
 * nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives
 * the sum of target.
 */
public class FourSum {
  private static class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      int n = nums.length;
      List<List<Integer>> res = new ArrayList<>();
      if (nums.length < 4) return res;

      Arrays.sort(nums);

      int i = 0;
      while ( i < n-3) {
        if (i > 0 && nums[i] == nums[i-1]) {
          i++;
          continue;
        }

        int j = i+1;
        while (j < n-2) {
          if (j > i+1 && nums[j] == nums[j-1]) {
            j++;
            continue;
          }

          int k = j+1;
          int l = n-1;
          while (k < l) {
            int sum = nums[i] + nums[j] + nums[k] + nums[l];
            if (sum == target) {
              res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
              k++;
              l--;
              while (k < l && (nums[k] == nums[k-1])) {
                k++;
              }
              while (k < l && (nums[l] == nums[l+1])) {
                l--;
              }
            } else if (sum > target) {
              l--;
            } else {
              k++;
            }
          }
          j++;
        }
        i++;
      }

      return res;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    print(sol.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
  }

  private static void print(List<List<Integer>> l) {
    l.forEach(list -> {
      list.forEach(n -> System.out.print(n + " "));
      System.out.println();
    });
  }
}
