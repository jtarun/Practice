package com.jtarun.practice.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
    Collections.sort(a);
    ArrayList<ArrayList<Integer>> out = new ArrayList<>();
    gen(a, out, 0);
    return out;
  }

  void  gen(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> out, int ind) {

    if (ind >= a.size())  {
      out.add(new ArrayList<>(a));
      return;
    }

    for (int i = ind; i < a.size(); i++) {
      //System.out.println(ind + " : " + i);
      swap(a, ind, i);
      gen(a, out, ind+1);
      swap(a, ind, i);
    }

  }

  private void swap(ArrayList<Integer> a, int i, int j) {
    int t = a.get(i);
    a.set(i, a.get(j));
    a.set(j, t);
  }
}



public class Permutation {

  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.permute(new ArrayList<>(Arrays.asList(1, 2, 3 )))
      .forEach(x -> {
        x.forEach(e -> System.out.print(e +  " "));
        System.out.println();
      });
  }

}
