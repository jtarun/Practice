package com.jtarun.practice.interviewbit.string;

class Solution6 {
  public int isInterleave(String a, String b, String c) {
    if (b.length() == 0) return c.equals(a) ? 1 : 0;
    if (a.length() == 0) return c.equals(b) ? 1 : 0;
    if (c.length() == 0) return 0;

    int m = a.length();
    int n = b.length();
    int o = c.length();
    if(m+n != o) return 0;
    boolean[][] dp = new boolean[m+1][n+1];

    int l = 0;
    while (l < a.length() && a.charAt(l) == c.charAt(l)) {
      dp[l+1][0] = true;
      l++;
    }

    l = 0;
    while (l < b.length() && b.charAt(l) == c.charAt(l)) {
      dp[0][l+1] = true;
      l++;
    }

    for (int i = 1; i <= m; i++) {
      char x = a.charAt(i-1);
      for (int j = 1;  j <= n; j++) {
          char y = b.charAt(j-1);
          char z = c.charAt(i+j-1);

          if (x == y && y == z) {
            dp[i][j] = dp[i][j] || dp[i-1][j] || dp[i][j-1];
          } else if (x == z) {
            dp[i][j] = dp[i][j] || dp[i-1][j];
          } else if (y == z) {
            dp[i][j] = dp[i][j] || dp[i][j-1];
          } //else dp[i][j][k] = false;
      }
    }

    return dp[m][n] ? 1:0;
  }
}


public class InterleavingString {
  public static void main(String[] args) {
    Solution6 sol = new Solution6();
    String a = "aa";
    String b = "ab";
    String c = "abaa";
    System.out.println(sol.isInterleave(a,b,c));
  }

}
