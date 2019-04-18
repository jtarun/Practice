package com.jtarun.practice.leetcode;

/** 376
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly
 * alternate between positive and negative. The first difference (if one exists) may be either positive or negative.
 * A sequence with fewer than two elements is trivially a wiggle sequence.
 *
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and
 * negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two
 * differences are positive and the second because its last difference is zero.
 *
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence
 * is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the
 * remaining elements in their original order.
 *
 * Example 1:
 *
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * Explanation: The entire sequence is a wiggle sequence.
 * Example 2:
 *
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 * Example 3:
 *
 * Input: [1,1]
 * Output: 1
 */
public class WiggleSubsequence {

    private static class Solution {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            if (n <= 1) return n;

            int[][] dp = new int[n][2]; // 2nd index is for increasing and decreasing sequence.
            dp[0][0] = 1;
            dp[0][1] = 1;

            int res = 1;
            for (int i = 1; i < n; i++) {
                for (int j = i-1; j >= 0; j--) {

                    if (nums[j] < nums[i]) { // increasing sequence;
                        dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                        res = Math.max(dp[i][0], res);
                    } else if (nums[i] < nums[j]) {
                        dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                        res = Math.max(dp[i][1], res);
                    }

                }
            }

            return res;
        }
    }

}
