package com.jtarun.practice.interviewbit.array;


import java.util.ArrayList;

class Solution3 {
  public ArrayList<Integer> getRow(int a) {

    ArrayList<Integer> res = new ArrayList<>();

    for (int i = 0; i < a + 1; i++) res.add(0);

    res.set(0, 1);
    for (int i = 1; i <= a; i++) {
      int prev = 1;
      for (int j = 1; j <= i; j++) {
        int cur = res.get(j);
        res.set(j, prev+cur);
        prev = cur;
      }

    }

    return res;
  }
}


public class PascalKthRow {

  public static void main(String[] args) {
    Solution3 sol = new Solution3();
    sol.getRow(0).forEach(x -> System.out.print(x + " "));
  }

}
