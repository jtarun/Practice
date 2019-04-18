package com.jtarun.practice.leetcode;

import java.util.*;

/** 668 (Hard)
 * Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number
 * quickly from the multiplication table?
 *
 * Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, you need
 * to return the k-th smallest number in this table.
 *
 * Example 1:
 * Input: m = 3, n = 3, k = 5
 * Output:
 * Explanation:
 * The Multiplication Table:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 *
 * The 5-th smallest number is 3 (1, 2, 2, 3, 3).
 */
public class KthSmallestNumberInMultiplicationTable {

    private static class Solution {

        // O(m+n)log(mn)
        public int findKthNumber(int m, int n, int k) {

            int lo = 1, hi = m*n;
            while (lo < hi) {
                int mid = lo + (hi-lo)/2;
                if (lessEquals(m, n, mid, k)) {
                    lo = mid+1;
                } else hi = mid;
            }

            return lo;
        }

        private boolean lessEquals(int m, int n, int target, int k) {
            boolean res = true;
            int count = 0, i = 1, j = n;
            while (i <= m && j >= 1) {
                int prod = i*j;
                if (prod <= target) {
                    count += j;
                    i++;
                } else {
                    j--;
                }
                if (count >= k) return false;
            }
            return true;
        }

        // Memory limit exceeds for larger k O(klogk)
        public int findKthNumber2(int m, int n, int k) {
            Comparator<int[]> cmp = (a,b) -> {
                int prod1 = a[0], prod2 = b[0];
                int c = prod1 - prod2;
                if (c == 0) c = -1;
                return c;
            };
            PriorityQueue<int[]> pq = new PriorityQueue<>(k, cmp);

            for (int i = 1; i <= Math.min(n, k); i++) {
                pq.offer(new int[]{i , i, 1});
            }

            int res = 0;
            while (k-- > 0) {
                int[] top = pq.poll();
                res = top[0];
                int i = top[1], j = top[2];
                j++;
                if (j <= m) {
                    pq.offer(new int[]{i*j, i, j});
                }
            }

            return res;
        }
    }

}
