package com.jtarun.practice.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class ValidParenthesis {
  private static class Solution {
    public boolean isValid(String s) {
      if (s.isEmpty()) {
        return true;
      }

      Stack<Character> st = new Stack<>();
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c=='(' || c == '{' || c=='[') {
          st.push(c);
        } else {
          if (st.isEmpty()) {
            return false;
          }
          char t = st.pop();
          if (!matching(t, c)) {
            return false;
          }
        }
      }

      return st.isEmpty();
    }

    private boolean matching(char c, char d) {
      return (c == '(' && d == ')') ||
          (c == '{' && d == '}') ||
          (c == '[' && d == ']');
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.isValid("()"));
    System.out.println(sol.isValid("()[]{}"));
    System.out.println(sol.isValid("(]"));
    System.out.println(sol.isValid("([)]"));
    System.out.println(sol.isValid("{[]}"));
  }

}
