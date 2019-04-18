package com.jtarun.practice.leetcode;

import java.util.*;

/** 542
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 */
public class ZeroOneMatrix {

    private static class Solution {

        public int[][] updateMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int max = m * n;

            int[][] res = new int[m][n];
            for (int i = 0; i <m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        res[i][j] = 0;
                    } else {
                        int top = i > 0 ? res[i-1][j] : max;
                        int left = j > 0 ? res[i][j-1] : max;
                        res[i][j] = Math.min(top, left) + 1;
                    }
                }
            }

            for (int i = m-1; i >= 0; i--) {
                for (int j = n-1; j >= 0; j--) {
                    if (res[i][j] <= 1) continue;
                    int right = j < n-1 ? res[i][j+1] : max;
                    int bottom = i < m-1 ? res[i+1][j] : max;
                    int dist = Math.min(right, bottom) + 1;
                    if (dist < res[i][j]) res[i][j] = dist;
                }
            }

            return res;
        }

        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        public int[][] updateMatrix2(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] res = new int[m][n];

            boolean[][] v = new boolean[m][n];
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        v[i][j] = true;
                        q.offer(new int[]{i,j});
                    }
                }
            }

            int level = 0;
            while(!q.isEmpty()) {
                level++;
                int size = q.size();
                while (size-- > 0) {

                    int[] t = q.poll();
                    int x1 = t[0], y1 = t[1];

                    for (int[] d : dirs) {
                        int x2 = d[0] + x1;
                        int y2 = d[1] + y1;
                        if (x2 < 0 || y2 < 0 || x2 >= m || y2 >= n || v[x2][y2] || matrix[x2][y2] == 0) continue;
                        res[x2][y2] = level;
                        q.offer(new int[]{x2, y2});
                        v[x2][y2] = true;
                    }

                }

            }

            return res;
        }

    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        int[][] res = sol.updateMatrix(matrix);
        for (int[] row : res) {
            for (int col : row) {
                System.out.print(col+ " ");
            }
            System.out.println();
        }
    }

}
