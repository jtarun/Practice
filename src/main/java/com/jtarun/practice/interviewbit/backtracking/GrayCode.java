package com.jtarun.practice.interviewbit.backtracking;

import java.util.ArrayList;

class Solution3 {
  public ArrayList<Integer> grayCode(int a) {

    ArrayList<Integer> out = new ArrayList<>();
    gen(a, a - 1, out);
    return out;
  }


  void gen(int a, int ind, ArrayList<Integer> out) {
    if (ind == 0) {
      out.add(0);
      out.add(1);
      return;
    }

    gen(a, ind -1, out);
    ArrayList<Integer> res = new ArrayList<>();
    if (ind > 0) {
      out.forEach(e -> res.add(e | (1 << ind)));
      for (int i = out.size() - 1; i >= 0; i--) {
        res.add(out.get(i));
      }
      out.clear();
      out.addAll(res);
    }
  }

}


public class GrayCode {
  public static void main(String[] args) {
    Solution3 sol = new Solution3();
    sol.grayCode(10).forEach(System.out::println);
  }
}
