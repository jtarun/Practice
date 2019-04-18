package com.jtarun.practice.interviewbit.dp;

import java.util.ArrayList;
import java.util.Arrays;

class Solution3 {
  public int minPathSum(ArrayList<ArrayList<Integer>> a) {
    int n = a.size();
    if (n==0) return 0;
    int m = a.get(0).size();

    int[][] sum = new int[n][m];

    for (int i = 0; i <n; i++) {
      for (int j = 0; j < m; j++) {
        int x = a.get(i).get(j);
        if (i == 0 && j == 0) {
          sum[i][j] = a.get(0).get(0);
        } else if (i ==0) {
          sum[i][j] = x + sum[i][j - 1];
        } else if ( j==0) {
          sum[i][j] = x + sum[i-1][j];
        } else {
          sum[i][j] = x + Math.min(sum[i - 1][j], sum[i][j - 1]);
        }
      }
    }

    return sum[n-1][m-1];
  }
}



public class MinPath {

  public static void main(String[] args) {
    Solution3 sol = new Solution3();

    int[][] arr = {
  {20, 29, 84, 4, 32, 60, 86, 8, 7, 37},
  {77, 69, 85, 83, 81, 78, 22, 45, 43, 63},
  {60, 21, 0, 94, 59, 88, 9, 54, 30, 80},
  {40, 78, 52, 58, 26, 84, 47, 0, 24, 60},
  {40, 17, 69, 5, 38, 5, 75, 59, 35, 26},
  {64, 41, 85, 22, 44, 25, 3, 63, 33, 13},
  {2, 21, 39, 51, 75, 70, 76, 57, 56, 22},
  {31, 45, 47, 100, 65, 10, 94, 96, 81, 14}
  };

    ArrayList<ArrayList<Integer>> t = new ArrayList<>();
    for (int[] oned : arr) {
      ArrayList<Integer> x = new ArrayList<>();
      for (int i : oned) {
        x.add(i);
      }
      t.add(x);
    }

    System.out.println(sol.minPathSum(t));
  }

}
