package com.jtarun.practice.leetcode;

import java.util.*;

/** 678
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this
 * string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
public class ValidParanthesisString {

    private static class Solution {

        public boolean checkValidString(String s) {
            if (s.length() == 0) return true;

            int lo = 0, hi = 0, i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);

                if (c == '(') {
                    lo++;
                    hi++;
                } else if (c == ')') {
                    if (lo > 0) lo--;
                    hi--;
                } else {
                    if (lo > 0) lo--;
                    hi++;
                }

                if (hi < 0) return false;
                i++;
            }

            return lo == 0;
        }

        public boolean checkValidString2(String s) {
            if (s.length() == 0) return true;

            Set<Integer> h = new HashSet<>();

            char f = s.charAt(0);
            if (f == '(') h.add(1);
            else if (f == ')') return false;
            else {
                h.add(1);
                h.add(0);
            }

            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);

                Set<Integer> h2 = new HashSet<>();
                for (int x : h) {
                    if (c == '(') h2.add(x + 1);
                    else if (c == ')') {
                        if (x != 0) h2.add(x - 1);
                    } else {
                        if (x != 0) h2.add(x-1);
                        h2.add(x+1);
                        h2.add(x);
                    }
                }

                if (h2.isEmpty()) return false;
                h = h2;
            }

            return h.contains(0);
        }

        public boolean checkValidStringDFS(String s) {
            return helper(s, 0, 0);
        }

        private boolean helper(String s, int ind, int diff) {
            if (ind == s.length()) {
                return diff == 0;
            }
            if (diff < 0) return false;

            char c = s.charAt(ind);

            if (c == '(') return helper(s, ind+1, diff+1);
            if (c == ')') return helper(s, ind+1, diff-1);

            return helper(s, ind+1, diff) ||
                    helper(s, ind+1, diff+1) ||
                    helper(s, ind+1, diff-1);
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.checkValidString("(*)"));
    }

}
