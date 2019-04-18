package com.jtarun.practice.interviewbit.string;

class Solution7 {
  public int isMatch(final String s, final String p) {

    int n = s.length();
    int m = p.length();
    boolean[][] dp = new boolean[n+1][m+1];
    dp[0][0] = true;

    if (m == 0) return n == 0 ? 1:0;
    if (n == 0) {
      for (int i = 0; i < m; i++) {
        if (p.charAt(i) != '*') return 0;
        else dp[0][i+1] = true;
      }
      return 1;
    }

    for (int i  = 0; i <=n; i++) {
      for (int j = 1; j <= m; j++) {
        char d = p.charAt(j-1);

        if (i==0) {
          if(dp[0][j-1] && d=='*')dp[0][j] = true;
          continue;
        }

        char c = s.charAt(i-1);

        if (i == 1 && j == 1) {
          if (c == d || d=='?' || d=='*') dp[1][1] = true;
          continue;
        }

        if (c == d || d == '?') {
          dp[i][j] = dp[i-1][j-1];
        } else if (d == '*') {
          dp[i][j] = dp[i-1][j-1] || dp[i][j-1] || dp[i-1][j];
        }
      }
    }

/*    for (int i  = 0; i <=n; i++) {
      for (int j = 0; j <= m; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }*/

    return dp[n][m] ? 1 : 0;
  }


  public int isMatch2(final String s, final String p) {
    int i = 0;
    int j = 0;
    int starIndex = -1;
    int iIndex = -1;

    while (i < s.length()) {
      if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
        ++i;
        ++j;
      } else if (j < p.length() && p.charAt(j) == '*') {
        starIndex = j;
        iIndex = i;
        j++;
      } else if (starIndex != -1) {
        j = starIndex + 1;
        i = iIndex+1;
        iIndex++;
      } else {
        return 0;
      }
    }

    while (j < p.length() && p.charAt(j) == '*') {
      ++j;
    }

    return j == p.length() ? 1 : 0;
  }

}



public class RegexMatch {
  public static void main(String[] args) {
    Solution7 sol = new Solution7();
    System.out.println(sol.isMatch2("cc", "***??"));
  }
}
