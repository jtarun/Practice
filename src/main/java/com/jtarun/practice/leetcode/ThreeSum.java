package com.jtarun.practice.leetcode;

import java.util.*;

/** 15
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 */
public class ThreeSum {

  private static class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();

      Arrays.sort(nums);
      int n = nums.length;

      for (int i = 0; i < n-2; i++) {
        if (i > 0 && (nums[i] == nums[i-1])) {
          continue;
        }
        int target = -nums[i];
        int j = i+1;
        int k = n-1;

        while (j < k) {
          int sum = nums[j] + nums[k];
          if (sum == target) {
            List<Integer> triplet = new ArrayList<>();
            triplet.addAll(Arrays.asList(nums[i], nums[j], nums[k]));
            res.add(triplet);
            j++;
            k--;
            while (j < k && nums[j] == nums[j-1]) {
              j++;
            }
            while (j < k && nums[k] == nums[k+1]) {
              k--;
            }
          } else if (sum > target) {
            k--;
          } else {
            j++;
          }
        }

      }

      return res;
    }
  }


  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] nums = {-1, 0, 1, 2, -1, -4};
    print(sol.threeSum(nums));
  }

  private static void print(List<List<Integer>> l) {
    l.forEach(list -> {
      list.forEach(n -> System.out.print(n + " "));
      System.out.println();
    });
  }

}
