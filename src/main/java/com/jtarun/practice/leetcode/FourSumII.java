package com.jtarun.practice.leetcode;

import java.util.*;

/** 454
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that
 * A[i] + B[j] + C[k] + D[l] is zero.
 *
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 */
public class FourSumII {

    private static class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> h = new HashMap<>();
            int n = A.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = A[i] + B[j];
                    int cnt = h.getOrDefault(sum, 0);
                    h.put(sum, cnt+1);
                }
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = C[i] + D[j];
                    res += h.getOrDefault(-sum, 0);
                }
            }

            return res;
        }
    }

}
