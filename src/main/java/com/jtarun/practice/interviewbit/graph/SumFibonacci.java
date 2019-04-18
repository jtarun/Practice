package com.jtarun.practice.interviewbit.graph;

import java.util.ArrayList;

class Solution2 {
  public int fibsum(int a) {
    if (a == 1 || a == 2) return 1;
    ArrayList<Integer> fib = new ArrayList<>();
    fib.add(1);
    fib.add(2);
    while (true) {
      int sum = fib.get(fib.size() - 1) + fib.get(fib.size()-2);
      if (sum > a) break;
      if (sum == a) return 1;
      fib.add(sum);
    }
    ArrayList<Integer> temp = new ArrayList<>();
    ArrayList<ArrayList<Integer>> out = new ArrayList<>();
    solve(fib, 0, a,  fib.size() - 1, temp, out);

    int res = Integer.MAX_VALUE;
    for (ArrayList<Integer> arr : out) {
      res = Math.min(res, arr.size());
    }
    return res;
  }

  boolean found = false;
  void solve(ArrayList<Integer> a, int sum, int target, int ind, ArrayList<Integer> temp,
             ArrayList<ArrayList<Integer>> out) {
    if (ind < 0) return;
    if (sum > target) return;

    if (sum == target) {
      out.add(new ArrayList<>(temp));
      found = true;
      return;
    }

    for (int i = ind; i >=0; i--) {
      temp.add(a.get(i));
      if (!found)
        solve(a, sum + a.get(i), target, i, temp, out);
      temp.remove(temp.size() - 1);
    }
  }
}


public class SumFibonacci {

  public static void main(String[] args) {
    Solution2 sol = new Solution2();
    System.out.println(sol.fibsum(7));

  }

}
