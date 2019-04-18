package com.jtarun.practice.leetcode;


/** 473
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has,
 * please find out a way you can make one square by using up all those matchsticks. You should not break any stick,
 * but you can link them up, and each matchstick must be used exactly one time.
 *
 * Your input will be several matchsticks the girl has, represented with their stick length. Your output will either
 * be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 */
public class MatchstickToSquare {

    private static class Solution {
        public boolean makesquare(int[] nums) {
            if (nums.length == 0) return false;

            int sum = 0;
            for (int n : nums) sum += n;
            if (sum % 4 != 0) return false;
            int target = sum / 4;

            return subsetSum(nums, target, new int[4], 0);
        }

        private boolean subsetSum(int[] nums, int target, int[] sum, int i) {

            if (i == nums.length) {
                for (int n : sum) if (n != target) return false;
                return true;
            }

            int x = nums[i];
            for (int k = 0; k < sum.length; k++) {
                if (sum[k] + x > target) continue;

                sum[k] += x;
                if (subsetSum(nums, target, sum, i + 1)) return true;
                sum[k] -= x;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[] nums = {3,3,3,3,4};
        int[] nums = {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
        //int[] nums = {2, 2, 2, 2, 2, 6};
        System.out.println(sol.makesquare(nums));
    }
}
