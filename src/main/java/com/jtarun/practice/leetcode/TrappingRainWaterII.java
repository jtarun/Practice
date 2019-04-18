package com.jtarun.practice.leetcode;

/// UNSOLVED
public class TrappingRainWaterII {

    private static class Solution {
        public int trapRainWater(int[][] heightMap) {
            int m = heightMap.length;
            if (m <= 2) return 0;
            int n = heightMap[0].length;
            if (n <= 2) return 0;

            int[][] v = new int[m][n];

            for (int i = 1; i < m-1; i++) {
                int[] res = calc(heightMap[i]);
                for (int j = 1; j < n-1; j++) v[i][j] = res[j];
            }

            int total = 0;
            int[] col = new int[m];
            for (int i = 1; i < n-1; i++) {
                for (int r = 0; r < m; r++) col[r] = heightMap[r][i];

                int[] res = calc(col);
                for (int r = 1; r < m-1; r++) {
                    int val =  Math.min(v[r][i], res[r]);
                    total += val;
                }

            }

            return total;
        }

        private int[] calc(int[] a) {
            int n = a.length;
            int[] res = new int[n];
            int i = 0, j = n-1, leftMax = 0, rightMax = 0;

            while (i < j) {
                if (a[i] <= a[j]) {

                    if (a[i] < leftMax) {
                        res[i] = leftMax - a[i];
                    } else {
                        leftMax = a[i];
                    }
                    i++;

                } else {
                    if (a[j] > rightMax) {
                        rightMax = a[j];
                    } else {
                        res[j] = rightMax - a[j];
                    }
                    j--;
                }

            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] h = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};

        int res = sol.trapRainWater(h);
        System.out.println(res);
    }

}
