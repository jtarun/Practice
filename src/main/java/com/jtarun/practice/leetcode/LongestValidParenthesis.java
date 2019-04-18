package com.jtarun.practice.leetcode;

import java.util.*;

/** 32
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParenthesis {

    private static class Solution {

        public int longestValidParentheses(String s) {
            Stack<Integer> st = new Stack<>();
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    st.push(i);
                } else {
                    if (!st.isEmpty() && s.charAt(st.peek()) == '(') {
                        st.pop();
                        int left = st.isEmpty() ? 0 : st.peek()+1;
                        res = Math.max(res, i-left+1);
                    }
                    else st.push(i);
                }
            }

            return res;
        }


        // O(n^2) solution
        public int longestValidParentheses2(String s) {
            int res = 0;
            for (int i = 0; i < s.length()-1; i++) {
                res = Math.max(res, longestFrom(s, i));
            }

            return res;
        }

        private int longestFrom(String s, int i) {

            int diff = 0;
            int j = i;
            int res = 0;
            while (j < s.length()) {
                char c = s.charAt(j);
                if (c == '(') diff++;
                else diff--;
                if (diff < 0) break;
                else if (diff == 0) {
                    res = Math.max(res, j-i+1);
                }
                j++;
            }
            return res;
        }
    }

}
