package com.jtarun.practice.interviewbit.math;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
  public ArrayList<Integer> allFactors(int a) {
    ArrayList<Integer> res = new ArrayList<>();
    ArrayList<Integer> cofactor = new ArrayList<>();

    res.add(1);
    if (a == 1) return res;
    if (a <= 3) {
      res.add(a);
      return res;
    }

    cofactor.add(a);

    int n = (int)Math.sqrt(a);
    if ( n * n < a) n++;

    for (int i = 2; i <= n; i++) {
      if (a % i == 0) {

        res.add(i);
        if (i != n)
          cofactor.add(a/i);

      }
    }

    Collections.reverse(cofactor);
    res.addAll(cofactor);
    return res;
  }
}



public class Factors {
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.allFactors(5).forEach(x -> System.out.print(x + " "));
  }

}
