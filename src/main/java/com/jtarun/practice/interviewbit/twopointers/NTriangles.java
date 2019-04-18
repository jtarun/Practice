package com.jtarun.practice.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution5 {
  public int nTriang(ArrayList<Integer> a) {

    Collections.sort(a);
    long res = 0;
    long mod = 1000000007;
    int n = a.size();
    for (int i = 0; i < n-2; i++) {
      int x = a.get(i);

      int j = i+1, k = i+2;
      while (j < n && k < n) {
        if (j == k) {
          k++;
          continue;
        }

        int y = a.get(j);
        int z = a.get(k);

        if (x + y > z) {
          int cnt = search(a, k, n-1, x+y);
          res = (res + cnt)%mod;
        }
        j++;
      }
    }
    return (int) res;
  }

  int search(ArrayList<Integer> a, int lo, int hi, int target) {
    int s = lo;
    int res = lo;
    while (lo <= hi) {
      int mid = lo + (hi - lo)/2;
      if (a.get(mid) < target) {
        res = mid;
        lo = mid+1;
      } else {
        hi = mid -1;
      }
    }
    return res - s + 1;
  }

}



public class NTriangles {
  public static void main(String[] args) {
    Solution5 sol = new Solution5();
    int res = sol.nTriang(new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2)));
    System.out.println(res);
  }

}
