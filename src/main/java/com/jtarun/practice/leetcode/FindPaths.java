package com.jtarun.practice.leetcode;

import java.util.*;

public class FindPaths {

    private static class Solution {
        public int findPaths2(int m, int n, int N, int i, int j) {
            if (N == 0 || m == 0 || n == 0) return 0;
            int[][][] dp = new int[m][n][N+1];
            int[][] dirs = {{1,0}, {0,1},{-1, 0}, {0,-1}};
            helper(i, j, m, n, N, dp, dirs);

            return dp[i][j][N];
        }

        int helper(int i, int j, int m, int n, int N, int[][][] dp, int[][] dirs) {
            if (i < 0 || j < 0 || i >= m || j >= n) return 1;
            if (N <= 0) return 0;
            if (dp[i][j][N] > 0) return dp[i][j][N];

            int mod = 1000000007;
            //dp[i][j][N] = helper(i, j, m, n, N-1, dp, dirs) % mod;
            for (int[] d :dirs) {
                int x = i + d[0];
                int y = j + d[1];
                dp[i][j][N] += helper(x, y, m, n, N-1, dp, dirs);
                dp[i][j][N] %= mod;
            }

            return dp[i][j][N];
        }

        // BFS bottom-up (ACC)
        public int findPaths(int m, int n, int N, int i, int j) {
            if (m == 0 || n == 0 || N == 0) return 0;

            Queue<int[]> q = new LinkedList<>();
            long[][][] dp = new long[m][n][N+1];
            boolean[][][] v = new boolean[m][n][N+1];
            for (int p = 0; p < m; p++) {
                dp[p][0][1] += 1;
                dp[p][n-1][1] += 1;
                if (!v[p][0][1]) {
                    q.offer(new int[]{p,0,1});
                    v[p][0][1] = true;
                }
                if (!v[p][n-1][1]) {
                    q.offer(new int[]{p,n-1,1});
                    v[p][n-1][1] = true;
                }
            }

            for (int p = 0; p < n; p++) {
                dp[0][p][1] += 1;
                dp[m - 1][p][1] += 1;
                if (!v[0][p][1]) {
                    q.offer(new int[]{0, p, 1});
                    v[0][p][1] = true;
                }
                if (!v[m - 1][p][1]) {
                    q.offer(new int[]{m - 1, p, 1});
                    v[m - 1][p][1] = true;
                }
            }

            int mod = (int)(Math.pow(10,9) + 7);

            int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

            while(!q.isEmpty()) {
                int[] t = q.poll();
                int x1 = t[0],  y1 = t[1],  k = t[2];
                if (k >= N) break;

                for (int[] d : dirs) {
                    int x2 = x1 + d[0];
                    int y2 = y1 + d[1];
                    if (x2 < 0 || y2 < 0 || x2 >= m || y2 >= n ) continue;
                    dp[x2][y2][k+1] += dp[x1][y1][k];
                    dp[x2][y2][k+1] %= mod;
                    if (!v[x2][y2][k+1]) {
                        q.offer(new int[]{x2, y2, k + 1});
                        v[x2][y2][k + 1] = true;
                    }
                }
            }

            int res = 0;
            for (int k = 1; k <= N; k++) {
                res += dp[i][j][k];
                res %= mod;
            }
            return res;
        }

        public int findPathsBFS(int m, int n, int N, int i, int j) {
            if (m == 0 || n == 0 || N == 0) return 0;

            int mod = 1000000007;
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{i, j});

            int[][] dirs = {{0,1}, {1,0}, {-1, 0}, {0, -1}};
            int level = 0;
            int res = 0;
            while (level < N && !q.isEmpty()) {
                level++;
                int size = q.size();
                while (size-- > 0) {
                    int[] t = q.poll();
                    int x1 = t[0], y1 = t[1];

                    for (int[] d : dirs) {
                        int x2 = x1 + d[0];
                        int y2 = y1 + d[1];

                        if (x2 < 0 || y2 < 0 || x2 >= m || y2 >= n) {
                            res = (res + 1) % mod;
                            continue;
                        }

                        q.offer(new int[]{x2, y2});
                    }
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //int res = sol.findPaths(2,2,2,0,0);
        int res = sol.findPaths(2,3,8,1,0);
        System.out.println(res);
    }

}
