package com.jtarun.practice.leetcode;

import java.util.*;

/** 740
 * Given an array nums of integers, you can perform operations on the array.
 *
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every
 * element equal to nums[i] - 1 or nums[i] + 1.
 *
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 *
 * Example 1:
 * Input: nums = [3, 4, 2]
 * Output: 6
 * Explanation:
 * Delete 4 to earn 4 points, consequently 3 is also deleted.
 * Then, delete 2 to earn 2 points. 6 total points are earned.
 */
public class DeleteAndEarn {

    private static class Solution {

        // O(max(nums)) solution
        public int deleteAndEarn(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            int max = 0;
            for (int num : nums) max = Math.max(max, num);

            int[] val = new int[max+1];
            for (int num : nums) val[num] += num;

            int incl = 0, excl = 0;

            for (int v : val) {
                int temp = incl;
                incl = excl + v;
                excl = Math.max(excl, temp);
            }

            return Math.max(incl, excl);
        }

        // O(n^2) solution
        public int deleteAndEarn2(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;

            Arrays.sort(nums);
            int[] dp = new int[n];
            dp[0] = nums[0];
            int res = dp[0];

            for (int i = 1; i < n; i++) {
                dp[i] = nums[i];
                if (nums[i] == nums[i-1]) {
                    dp[i] += dp[i-1];
                } else {
                    int j = i-1;
                    while (j >= 0 && nums[j] == (nums[i]-1)) j--;
                    int max = 0;
                    while (j >= 0) {
                        max = Math.max(max, dp[j]);
                        j--;
                    }
                    dp[i] += max;
                }
                res = Math.max(dp[i], res);
            }

            return res;
        }


        // O(2^n) solution
        public int deleteAndEarnRec(int[] nums) {
            return helper(nums, 0, new HashSet<>());
        }


        private int helper(int[] nums, int i, Set<Integer> deleted) {
            if (i == nums.length) return 0;

            if (deleted.contains(nums[i])) {
                return helper(nums, i+1, deleted);
            } else {
                boolean lessPresent = !deleted.add(nums[i]-1);
                boolean morePresent = !deleted.add(nums[i]+1);

                int res =  nums[i] + helper(nums, i+1, deleted);

                if (!lessPresent) deleted.remove(nums[i]-1);
                if (!morePresent) deleted.remove(nums[i]+1);

                res = Math.max(res, helper(nums, i+1, deleted));
                return res;
            }

        }
    }

}
