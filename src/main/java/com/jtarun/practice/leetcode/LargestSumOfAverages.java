package com.jtarun.practice.leetcode;

/** 813
 * We partition a row of numbers A into at most K adjacent (non-empty) groups, then our score is the sum of
 * the average of each group. What is the largest score we can achieve?
 *
 * Note that our partition must use every number in A, and that scores are not necessarily integers.
 *
 * Example:
 * Input:
 * A = [9,1,2,3,9]
 * K = 3
 * Output: 20
 * Explanation:
 * The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * We could have also partitioned A into [9, 1], [2], [3, 9], for example.
 * That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 *
 * Note:
 *
 * 1 <= A.length <= 100.
 * 1 <= A[i] <= 10000.
 * 1 <= K <= A.length.
 * Answers within 10^-6 of the correct answer will be accepted as correct.
 */
public class LargestSumOfAverages {

    private static class Solution {
        public double largestSumOfAverages(int[] A, int K) {
            int n = A.length;

            double[][] dp = new double[n][K];

            double sum = 0;
            for(int i = 0; i < n; i++) {
                sum += A[i];
                dp[i][0] = sum/(i+1);
            }

            for (int k = 1; k < K; k++) {

                for (int i = k; i < n; i++) {

                    sum = 0;
                    for (int j = i; j >= k; j--) {
                        sum += A[j];
                        double avg = sum/(i-j+1);
                        dp[i][k] = Math.max(dp[i][k], avg + dp[j-1][k-1]);
                    }
                }

            }

            return dp[n-1][K-1];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.largestSumOfAverages(new int[]{1,2,3,4,5,6,7}, 4));
    }

}
