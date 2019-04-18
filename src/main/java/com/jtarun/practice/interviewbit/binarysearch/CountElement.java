package com.jtarun.practice.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  // DO NOT MODIFY THE LIST
  public int findCount(final List<Integer> a, int b) {
    if (a.size() == 0) {
      return 0;
    }

    int lo = 0;
    int hi = a.size() - 1;

    while (lo < hi) {

      int mid = lo + (hi - lo) / 2;

      if (a.get(mid) == b) {
        hi = mid;
      } else if (a.get(mid) < b) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }

    }

    if (a.get(hi) != b) {
      return 0;
    }
    int x = hi;

    lo = 0;
    hi = a.size() - 1;

    while (lo < hi) {

      int mid = lo + (hi - lo + 1) / 2;

      if (a.get(mid) == b) {
        lo = mid;
      } else if (a.get(mid) < b) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    int y = lo;

    return y - x + 1;
  }
}


public class CountElement {
  public static void main(String[] args) {
    Solution sol = new Solution();

    List<Integer> l = Arrays.asList(1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6,
        6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10
    );

    int r = sol.findCount(l, 1);
    System.out.println(r);
  }
}
