package com.jtarun.practice.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

class Solution3 {
  public int diffPossible(ArrayList<Integer> a, int b) {

    int n = a.size();

    for ( int i = 0; i < n-1; i++ ){
      if (binarySearch(a, i+1, n-1, a.get(i) + b)) return 1;
    }
    return 0;
  }

  boolean binarySearch(ArrayList<Integer> a, int lo, int hi , int k) {
    int res = lo;
    while (lo <= hi) {
      int mid = lo + (hi - lo)/ 2;
      if (a.get(mid) <= k) {
        res = mid;
        lo = mid + 1;
      } else {
        hi = mid -1;
      }
    }
    return a.get(res) == k;
  }
}



public class Diffk {
  public static void main(String[] args) {
    Solution3 sol = new Solution3();
    ArrayList<Integer> t= new ArrayList<>(Arrays.asList(0, 1, 9, 10, 13, 17, 17, 17, 23, 25, 29, 30,
        37, 38, 39, 39, 40, 41, 42, 60, 64, 70, 70, 70, 72, 75, 85, 85, 90, 91, 91, 93, 95));
    int res = sol.diffPossible(t, 83);
    System.out.println(res);
  }
}
