package com.jtarun.practice.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;

class Solution5 {
  public ArrayList<Integer> subUnsort(ArrayList<Integer> a) {
    ArrayList<Integer> res = new ArrayList<>();
    int n = a.size();
    if (n <= 1) return res;

    int i = 1, l = -1, r = -1;
    for (; i < n; i++) {
      if (a.get(i) < a.get(i-1)) {
        l = i;
        break;
      }
    }
    if (l == -1) {
      res.add(-1);
      return res;
    }
    i = n-2;
    for (; i >= 0; i--) {
      if (a.get(i) > a.get(i+1)) {
        r = i;
        break;
      }
    }

    if ( l > r) {
      int t = l;
      l = r;
      r = t;
    }

    int min = a.get(l), max = a.get(r);
    for (i = r-1; i >= 0; i--) {
      max = Math.max(max, a.get(i));
    }

    for (i = l+1; i < n; i++) {
      min = Math.min(min, a.get(i));
    }
    l = 0;
    for (; l < n; l++) {
      if (a.get(l) > min) break;
    }
    r = n-1;
    for (; r >= 0; r--) {
      if (a.get(r) < max) break;
    }


    res.add(l);
    res.add(r);
    return res;
  }
}



public class MaxUnsort {

  public static void main(String[] args) {
    Solution5 sol = new Solution5();
    sol.subUnsort(new ArrayList<>(Arrays.asList( 14, 15, 15, 16, 15, 20, 16))).forEach(x -> System.out.print(x + " "));
  }

}
