package com.jtarun.practice.leetcode;

import java.util.*;

/** 447
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class NumberOfBoomerangs {

    private static class Solution {

        // O(n^2) solution
        public int numberOfBoomerangs(int[][] points) {
            int res = 0;
            int n = points.length;
            if (n < 3) return res;

            int[][] dist = new int[n][n];

            List<Map<Integer, Integer>> h = new ArrayList<>();
            for (int i = 0; i < n; i++) h.add(new HashMap<>());

            for (int i = 0; i < n-1; i++) {

                for (int j = i+1; j < n; j++) {

                    if (i == j) continue;

                    dist[i][j] = dist(points[i], points[j]);
                    dist[j][i] = dist[i][j];

                    Map<Integer, Integer> mi = h.get(i);
                    Map<Integer, Integer> mj = h.get(j);

                    int cnti = mi.getOrDefault(dist[j][i], 0);
                    int cntj = mj.getOrDefault(dist[i][j], 0);

                    mi.put(dist[i][j], cnti+1);
                    mj.put(dist[i][j], cntj+1);
                }

            }

            for (int i = 0; i < n-1; i++) {

                for (int j = i+1; j < n; j++) {
                    int d = dist[i][j];
                    Map<Integer, Integer> mi = h.get(i);
                    Map<Integer, Integer> mj = h.get(j);

                    int cnt1 = mi.get(d);
                    int cnt2 = mj.get(d);

                    res += cnt1 + cnt2 - 2;
                }

            }

            return res;

        }



        // TLE - O(n^3) solution
        public int numberOfBoomerangs2(int[][] points) {
            int res = 0;
            int n = points.length;
            if (n < 3) return res;

            int[][] dist = new int[n][n];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (i == j) continue;

                    dist[i][j] = dist(points[i], points[j]);

                }

            }

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    if (j == i) continue;

                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;

                        if(dist[i][j] == dist[j][k]) res++;

                    }

                }

            }

            return res;

        }

        int dist(int[] p1, int[] p2) {

            int x = p1[0] - p2[0];
            int y = p1[1] - p2[1];
            return x*x + y*y;
        }
    }

}
