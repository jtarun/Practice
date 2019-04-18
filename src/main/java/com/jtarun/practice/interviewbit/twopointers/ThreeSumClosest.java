package com.jtarun.practice.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
  public int threeSumClosest(ArrayList<Integer> a, int b) {

    Collections.sort(a);
    int minDiff = Integer.MAX_VALUE;
    int res = 0;
    int n = a.size();
    for (int i  = 0; i < n-2; i++) {
      int x = a.get(i);
      int j = i+1, k = n-1;
      while (j < k) {
        int sum = a.get(j) + a.get(k) + x;
        int diff = Math.abs(sum - b);
        if (diff == 0) return b;

        if (diff < minDiff) {
          res = sum + x;
          minDiff = diff;
          System.out.println(x + " " + a.get(j) + " " +  a.get(k));
        }

        if (sum > b) k--;
        else j++;
      }

    }

    return res;
  }
}



public class ThreeSumClosest {

  public static void main(String[] args) {
    Solution sol = new Solution();
    int res = sol.threeSumClosest(new ArrayList<>(Arrays.asList(5, -2, -1, -10, 10)), 5);
    System.out.println(res);
  }
}
