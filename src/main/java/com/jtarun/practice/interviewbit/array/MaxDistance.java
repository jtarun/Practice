package com.jtarun.practice.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution4 {
  // DO NOT MODIFY THE LIST
  public int maximumGap(final List<Integer> a) {

    ArrayList<Integer> smallest = new ArrayList<>();
    ArrayList<Integer> largest = new ArrayList<>();

    int n = a.size(), min = 0, max = n-1;
    if (n==0) return -1;

    for (int i = 0; i < n; i++) {
      int x = a.get(i);
      if (x < a.get(min)) {
        min = i;
      }
      smallest.add(min);
    }

    for (int i = n-1; i >= 0; i--) {
      int x = a.get(i);
      if (x > a.get(max)) {
        max = i;
      }
      largest.add(max);
    }
    Collections.reverse(largest);
    int res = -1;
    for (int i = 0; i < n; i++) {
      int large = largest.get(i);
      int small = smallest.get(i);
      //if (large == small) continue;

      if (large - small > res) res = large - small;
    }
    return res;
  }
}



public class MaxDistance {

  public static void main(String[] args) {
    Solution4 sol = new Solution4();
    int res = sol.maximumGap(Arrays.asList(3,2,1));
    System.out.println(res);
  }

}
