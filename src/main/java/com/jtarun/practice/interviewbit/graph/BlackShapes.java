package com.jtarun.practice.interviewbit.graph;

import java.util.ArrayList;

class Solution9 {
  public int black(ArrayList<String> a) {
    int n = a.size();
    if (n == 0) return 0;
    int m = a.get(0).length();
    if (m == 0) return 0;

    int[][] g = new int[n][m];

    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        char c = a.get(i).charAt(j);
        if (c == 'X' && g[i][j] == 0) {
          dfs(a, i,j, n, m, g);
          res++;
        }
      }
    }
    return res;
  }


  void dfs(ArrayList<String> a, int i, int  j, int n, int m , int[][] g) {
    if (i >= n || i < 0 || j >=m || j < 0 ) return;
    char c = a.get(i).charAt(j);
    if (c != 'X') return;
    if (g[i][j] == 1) return;

    g[i][j] = 1;

    dfs(a, i-1, j, n, m, g);
    dfs(a, i+1, j, n, m, g);
    dfs(a, i, j-1, n, m, g);
    dfs(a, i, j+1, n, m, g);
  }
}



public class BlackShapes {
  public static void main(String[] args) {
    Solution9 sol = new Solution9();

    String[] x = { "OOOXOOO", "OOXXOXO", "OXOOOXO"};
    ArrayList<String>t = new ArrayList<>();
    for (String s : x) t.add(s);
    int res = sol.black(t);
    System.out.println(res);
  }

}
