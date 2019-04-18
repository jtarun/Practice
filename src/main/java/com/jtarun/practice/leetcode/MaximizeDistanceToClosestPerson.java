package com.jtarun.practice.leetcode;

/** 849
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 *
 * There is at least one empty seat, and at least one person sitting.
 *
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 *
 * Return that maximum distance to closest person.
 */
public class MaximizeDistanceToClosestPerson {

    private static class Solution {
        public int maxDistToClosest(int[] A) {
            int n = A.length;
            int i = 0, j = n-1;
            int res = 0;
            // handle left
            while ( i < n && A[i] == 0) i++;
            res = i;

            // handle right
            while (j > i && A[j] == 0) j--;
            res = Math.max(res, n - 1 - j);

            // handle middle
            int cur = 0, max = 0;
            i++;
            for (int l = i; l < j; l++) {
                if (A[l] == 0) {
                    cur++;
                    max = Math.max(max, cur);
                } else {
                    cur = 0;
                }
            }

            res = Math.max(res, (max+1)/2);

            return res;
        }
    }
}
