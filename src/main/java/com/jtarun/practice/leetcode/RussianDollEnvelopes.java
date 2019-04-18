package com.jtarun.practice.leetcode;

import java.util.*;

/** 354
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than
 * the width and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 */
public class RussianDollEnvelopes {

    private static class Solution {

        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            if (n == 0) return 0;
            Comparator<int[]> cmp = (a, b) -> {
                int r = Integer.compare(a[0], b[0]);
                if (r != 0) return r;
                return Integer.compare(b[1], a[1]);
            };
            Arrays.sort(envelopes, cmp);

            int size = 0;
            int[] dp = new int[n];
            for (int[] e : envelopes) {

                int ind = Arrays.binarySearch(dp, 0, size, e[1]);
                if (ind <  0) ind = -(ind+1);
                dp[ind] = e[1];
                if (ind == size) size++;
            }
            return size;
        }

        public int maxEnvelopes2(int[][] envelopes) {
            int n = envelopes.length;
            if (n == 0) return 0;

            Comparator<int[]> cmp = (a,b) -> {
                int r = Integer.compare(a[1],b[1]);
                if (r != 0) return r;
                return Integer.compare(a[0], b[0]);
            };
            Arrays.sort(envelopes, cmp);

            int[] dp = new int[n];
            Arrays.fill(dp,1);

            int res = 1;
            for (int i = 1; i < n; i++) {
                int[] e1 = envelopes[i];
                for (int j = 0; j < i; j++) {
                    int[] e2 = envelopes[j];
                    if (e2[1] < e1[1] && e2[0] < e1[0]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(dp[i], res);
            }

            return res;
        }
    }

}
