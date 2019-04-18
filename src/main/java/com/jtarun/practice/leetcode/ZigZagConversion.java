package com.jtarun.practice.leetcode;


/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
public class ZigZagConversion {
  private static class Solution {
    public String convert(String s, int numRows) {
      if (numRows <= 1) return s;

      StringBuilder[] rows = new StringBuilder[numRows];
      for (int i = 0; i < numRows; i++) {
        rows[i] = new StringBuilder();
      }

      int r = 0;
      boolean reverse = false;
      for (int i = 0; i < s.length(); i++) {
        rows[r].append(s.charAt(i));
        if (reverse) {
          r--;
          if (r < 0) {
            r = 1;
            reverse = false;
          }
        } else {
          r++;
          if (r == numRows) {
            r = numRows - 2;
            reverse = true;
          }
        }
      }

      StringBuilder res = new StringBuilder();
      for (int i = 0; i < numRows; i++) {
        res.append(rows[i]);
      }
      return res.toString();
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.convert("PAYPALISHIRING", 3));
    System.out.println(sol.convert("PAYPALISHIRING", 4));
  }

}
