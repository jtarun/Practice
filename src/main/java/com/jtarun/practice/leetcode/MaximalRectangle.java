package com.jtarun.practice.leetcode;

public class MaximalRectangle {
    private static class Solution {
        public int maximalRectangle(char[][] matrix) {
            int m = matrix.length;
            if (m == 0) return 0;
            int n = matrix[0].length;
            if (n == 0) return 0;

            int area = 0;
            for (int left = 0; left < n; left++) {
                int[] sum = new int[m];

                for (int right = left; right < n; right++) {

                    for (int r = 0; r < m; r++) {
                        if (right == left) sum[r] = matrix[r][right];
                        else if (matrix[r][right] == 0) sum[r] = 0;
                        else if (sum[r] > 0) sum[r]++;
                    }

                    int i = 0;
                    while (i < m) {
                        if (sum[i] > 0) {
                            int total = sum[i];
                            int j = i+1;
                            while (j < m && sum[j] > 0) {
                                total += sum[j];
                                j++;
                            }
                            i = j-1;
                            area = Math.max(area, total);
                        }
                        i++;
                    }
                }
            }

            return area;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] mat = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        int res = sol.maximalRectangle(mat);
        System.out.println(res);
    }

}
