package com.jtarun.practice.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

class Solution4 {
  public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

    int x = A.size();
    int y = B.size();
    int z = C.size();
    int i = 0, j = 0, k = 0;
    int res = Integer.MAX_VALUE;
    while (i < x && j < y && k < z) {
      int p = A.get(i);
      int q = B.get(j);
      int r = C.get(k);
      System.out.println(p + " " + q + " " + r);
      int min = min(p,q,r);
      res = Math.min(res, Math.abs(max(p,q,r) - min));
      if (res == 0) break;
      if (min == p) i++;
      else if (min == q) j++;
      else k++;
    }

    return res;
  }

  int max(int a, int b, int c) {
    return Math.max(a, Math.max(b,c));
  }

  int min(int a, int b, int c) {
    return Math.min(a, Math.min(b,c));
  }
}



public class MinimizeAbsoluteDiff {
  public static void main(String[] args) {
    Solution4 sol = new Solution4();
    ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 4, 5, 8, 10));
    ArrayList<Integer> b = new ArrayList<>(Arrays.asList(6, 9, 15));
    ArrayList<Integer> c = new ArrayList<>(Arrays.asList(2, 3, 6, 6));

    int res = sol.solve(a, b, c);
    System.out.println(res);
  }

}
