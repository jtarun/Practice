package com.jtarun.practice.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class LetterCombinationsPhoneNumber {
  private static class Solution {
    public List<String> letterCombinations(String digits) {
      Map<Character, String> h = new HashMap<>();
      h.put('2', "abc");
      h.put('3', "def");
      h.put('4', "ghi");
      h.put('5', "jkl");
      h.put('6', "mno");
      h.put('7', "pqrs");
      h.put('8', "tuv");
      h.put('9', "wxyz");

      List<String> res = new ArrayList<>();
      char[] t = new char[digits.length()];
      letterCombinations(digits, t, res, 0, h);

      return res;
    }

    private void letterCombinations(String digits, char[] t, List<String> res, int i,
                                    Map<Character, String> h) {
      if (i == digits.length()) {
        res.add(new String(t));
        return;
      }

      char c = digits.charAt(i);
      String vals = h.get(c);
      for (int j = 0; j < vals.length(); j++) {
        t[i] = vals.charAt(j);
        letterCombinations(digits, t, res, i + 1, h);
      }

    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    print(sol.letterCombinations("23"));
  }

  private static void print(List<String> res) {
    res.forEach(x -> System.out.print(x + ", "));
  }

}
