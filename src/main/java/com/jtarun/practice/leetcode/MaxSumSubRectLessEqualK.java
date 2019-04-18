package com.jtarun.practice.leetcode;

import java.util.*;


/** 363
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that
 * its sum is no larger than k.
 */
public class MaxSumSubRectLessEqualK {

    class Solution {

        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;

            int lo = matrix[0][0], hi = matrix[n-1][n-1] + 1;
            while (lo < hi) {

                int mid = lo + (hi - lo) / 2;

                // find total number of values <= mid
                int cnt = 0, j = n-1;
                for (int i = 0; i < n; i++) {
                    while (j >= 0 && matrix[i][j] > mid)j--;
                    cnt += j + 1;
                }

                if (cnt < k)lo = mid+1;
                else hi = mid;
            }

            return lo;
        }

        public int maxSumSubmatrix2(int[][] matrix, int k) {

            int m = matrix.length;
            int n = matrix[0].length;

            int res = Integer.MIN_VALUE;
            for (int l = 0; l < n; l++) {
                int[] sum = new int[m];
                for (int r = l; r < n; r++) {

                    for (int i = 0; i < m; i++) {
                        sum[i] += matrix[i][r];
                    }

                    TreeSet<Integer> sumSet = new TreeSet<>();
                    sumSet.add(0);
                    int cum = 0;
                    for (int s : sum) {
                        cum += s;
                        Integer v = sumSet.ceiling(cum - k);
                        if (v != null) {
                            res = Math.max(res, cum-v);
                        }
                        sumSet.add(cum);
                    }

                }

            }

            return res;
        }
    }
}
