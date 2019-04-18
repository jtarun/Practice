package com.jtarun.practice.interviewbit.math;

class Solution7 {
  public int uniquePaths(int m, int n) {
    long ans = 1;

    for (int i = m; i <= m+n-2; i++) {
      ans *= i;
      ans /= i-m+1;
    }

    return (int)ans;
  }


  public int uniquePaths2(int a, int b) {
    if (a == 1 && b == 1) return 0;
    int[][] p = new int[a][b];

    for ( int i = 1; i < b; i++) p[0][i] = 1;
    for (int i = 1; i < a; i++) p[i][0] = 1;

    for (int i = 1; i < a; i++) {

      for (int j = 1; j < b; j++) {
        p[i][j] = p[i-1][j] + p[i][j-1];
      }
    }
    return p[a-1][b-1];
  }
}



public class UniqueGridPaths {
  public static void main(String[] args) {
    Solution7 sol = new Solution7();
    System.out.println(sol.uniquePaths2(2, 4));
  }

}
