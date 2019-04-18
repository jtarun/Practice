package com.jtarun.practice.interviewbit.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution8 {

  public int solve(int n, ArrayList<ArrayList<Integer>> a) {
    if (n <= 1) {
      return 0;
    }

    int[][] g = new int[n + 1][n + 1];

    for (ArrayList<Integer> edge : a) {
      int x = edge.get(0);
      int y = edge.get(1);
      int w = edge.get(2);
      g[x][y] = w;
    }

    ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    boolean[] v = new boolean[n+1];
    int[] mst = new int[n + 1];

    for (int i = 2; i <= n; i++) {
      mst[i] = Integer.MAX_VALUE;
    }
    mst[1] = 0;
    v[1] = true;
    int cur = 1;
    int cnt = 1;
    while (cnt < n) {
      int mini = -1, min = Integer.MAX_VALUE;
      for (int i = 1; i <= n; i++) {
        if (cur != i && !v[i] && g[cur][i] > 0) {
          if (mst[i] > mst[cur] + g[cur][i]) {
            mst[i] = mst[cur] + g[cur][i];
            if (min > mst[i]) {
              min = mst[i];
              v[i] = true;
              mini = i;
              cnt++;
              edges.add(new ArrayList<>(Arrays.asList(cur, i)));
            }
          }
        }
      }
      cur = mini;
    }

    int res = 0;
    for (int i = 0; i < n-1; i++) {
      int x = edges.get(i).get(0);
      int y = edges.get(i).get(1);
      res += g[x][y];
    }

    return res;
  }
}


public class CommutableIslands {
  public static void main(String[] args) {
    Solution8 sol = new Solution8();

    int[][] n = {
        {1, 2, 1},
        {2, 3, 2},
        {3, 4, 4},
        {1, 4, 3},
    };

    ArrayList<ArrayList<Integer>> t = new ArrayList<>();
    for (int[] oned : n) {
      ArrayList<Integer> arr = new ArrayList<>();
      for (int x : oned) {
        arr.add(x);
      }
      t.add(arr);
    }

    int res = sol.solve(4, t);
    System.out.println(res);
  }

}
