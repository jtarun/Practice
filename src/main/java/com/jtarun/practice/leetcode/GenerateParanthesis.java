package com.jtarun.practice.leetcode;


import java.util.ArrayList;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 */
public class GenerateParanthesis {
  private static class Solution {
    public List<String> generateParenthesis(int n) {
      List<String> res = new ArrayList<>();
      char[] t = new char[2 * n];
      generateParenthesis(t, 0, 0, 0, res);
      return res;
    }

    private void generateParenthesis(char[] t, int i, int open, int close, List<String> res) {
      if (i == t.length) {
        if (open == close) {
          res.add(new String(t));
        }
        return;
      }

      if (close > open) {
        return;
      }
      t[i] = '(';
      generateParenthesis(t, i+1, open+1, close, res);
      t[i] = ')';
      generateParenthesis(t, i+1, open, close + 1, res);
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.generateParenthesis(3).forEach(System.out::println);
  }

}
