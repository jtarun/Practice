package com.jtarun.practice.leetcode;

import java.util.*;

public class RomanToInteger {

  private static class Solution {

    public int romanToInt(String s) {

      Map<String, Integer> h = new HashMap<>();
      h.put("I", 1);
      h.put("IV", 4);
      h.put("V", 5);
      h.put("IX", 9);
      h.put("X", 10);
      h.put("XL", 40);
      h.put("L", 50);
      h.put("XC", 90);
      h.put("C", 100);
      h.put("CD", 400);
      h.put("D", 500);
      h.put("CM", 900);
      h.put("M", 1000);

      int i = 0;
      int res = 0;
      int n = s.length();
      while ( i < n) {
        boolean twoMatch = false;
        int m = 0;
        if ( i < n-1) {
          String key = "" + s.charAt(i) + s.charAt(i+1);
          if (h.containsKey(key)) {
            twoMatch = true;
            m = h.get(key);
            i += 2;
          }
        }

        if (!twoMatch) {
          m = h.get("" + s.charAt(i));
          i += 1;
        }

        res += m;
      }

      return res;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(sol.romanToInt("I"));
    System.out.println(sol.romanToInt("III"));
    System.out.println(sol.romanToInt("IV"));
    System.out.println(sol.romanToInt("IX"));
    System.out.println(sol.romanToInt("LVIII"));
    System.out.println(sol.romanToInt("MCMXCIV"));

  }

}
