package com.jtarun.practice.leetcode;

import java.util.*;

/** 552
 * Given a positive integer n, return the number of all possible attendance records with length n, which will be
 * regarded as rewardable. The answer may be very large, return it after mod 10^9 + 7.
 *
 * A student attendance record is a string that only contains the following three characters:
 *
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous
 * 'L' (late).
 */
public class StudentAttendanceRecordsII {

    private static class Solution {
        private int mod = 1000000007;

        public int checkRecord(int n) {
            if (n == 0) return 0;
            if (n == 1) return 3;

            long res = 0;
            int[] dp = new int[n+1];
            Arrays.fill(dp, -1);

            //res = (f(n-1, dp) * n) % mod;
            res = (res + f(n, dp)) % mod;

            for (int i = 1; i <= n; i++) {
                long left = i == 1 ? 1 : dp[i-1];
                long right = i == n ? 1 : dp[n-i];
                res = (res + left*right) % mod;
            }


            return (int) res;
        }


        private int f(int n, int[] dp) {
            if (n <= 0) return 1;

            if (dp[n] != -1) return dp[n];

            long res = f(n-1, dp) % mod;
            res = (res + f(n-2, dp)) % mod;
            if (n >= 2) res = (res + f(n-3, dp)) % mod;

            dp[n] = (int)res;

            return (int)res;
        }

    }

}
