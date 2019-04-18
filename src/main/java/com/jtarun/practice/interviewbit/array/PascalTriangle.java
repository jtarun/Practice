package com.jtarun.practice.interviewbit.array;

import java.util.ArrayList;

class Solution2 {
  public ArrayList<ArrayList<Integer>> generate(int a) {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    if (a==0) return res;

    for (int i = 0; i < a; i++) {
      res.add(new ArrayList<>());
      for (int j = 0; j <a; j++)
        res.get(i).add(0);
    }

    for (int i = 0; i < a; i++) res.get(i).set(0, 1);

    for (int i = 1; i < a; i++) {
      for (int j = 1; j <=i; j++) {
        int val = res.get(i-1).get(j-1) + res.get(i-1).get(j);
        res.get(i).set(j, val);
      }
    }

    for (int i = 0; i < a; i++) {

      for (int j = a-1; j > i; j--) {
        res.get(i).remove(j);
      }
    }

    return res;
  }
}



public class PascalTriangle {

  public static void main(String[] args) {
    Solution2 sol = new Solution2();
    sol.generate(5).forEach(arr -> {
      arr.forEach(x -> System.out.print(x+""));
      System.out.println();
    });
  }

}
