package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IntegerToRoman {

  private static class Solution {

    private static class Pair<T, W> {
      T x;
      W y;
      Pair(T x , W y) {
        this.x = x;
        this.y = y;
      }
    }


    public String intToRoman(int num) {
      List<Pair<String, Integer>> h = new ArrayList<>();
      h.add(new Pair<String, Integer>("M", 1000));
      h.add(new Pair<String, Integer>("CM", 900));
      h.add(new Pair<String, Integer>("D", 500));
      h.add(new Pair<String, Integer>("CD", 400));
      h.add(new Pair<String, Integer>("C", 100));
      h.add(new Pair<String, Integer>("XC", 90));
      h.add(new Pair<String, Integer>("L", 50));
      h.add(new Pair<String, Integer>("XL", 40));
      h.add(new Pair<String, Integer>("X", 10));
      h.add(new Pair<String, Integer>("IX", 9));
      h.add(new Pair<String, Integer>("V", 5));
      h.add(new Pair<String, Integer>("IV", 4));
      h.add(new Pair<String, Integer>("I", 1));

      StringBuilder res = new StringBuilder();
      for (int i = 0; i < h.size(); i++) {

        Pair<String, Integer> p = h.get(i);
        int d = p.y;

        int q = num / d;
        if (q > 0) {
          num = num % d;
          String sym = p.x;
          for (int j = 0; j < q; j++) {
            res.append(sym);
          }
        }

      }

      return res.toString();

    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(sol.intToRoman(3));
    System.out.println(sol.intToRoman(4));
    System.out.println(sol.intToRoman(9));
    System.out.println(sol.intToRoman(58));
    System.out.println(sol.intToRoman(1994));
  }


}
