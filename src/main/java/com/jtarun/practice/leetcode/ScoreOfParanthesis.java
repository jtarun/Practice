package com.jtarun.practice.leetcode;

import java.util.*;

/** 856
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 *
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 *
 *
 * Example 1:
 * Input: "()"
 * Output: 1
 *
 * Example 2:
 * Input: "()()"
 * Output: 2
 *
 * Example 3:
 * Input: "(()(()))"
 * Output: 6
 *
 * Note:
 *
 * S is a balanced parentheses string, containing only ( and ).
 * 2 <= S.length <= 50
 */
public class ScoreOfParanthesis {

    private static class Solution {
        public int scoreOfParentheses(String S) {
            Stack<String> st = new Stack<>();

            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);

                if (c == '(') {
                    st.push(""+c);
                } else {
                    if (st.peek().equals("(")) {
                        st.pop();
                        st.push("1");
                    } else {
                        // there will be only one value
                        int x = Integer.parseInt(st.pop());
                        st.pop(); // remove open bracket
                        st.push(""+2*x);
                    }

                    // there can be multiple values before last open or till stack becomes empty, aggregate them.
                    int sum = 0;
                    while (!st.isEmpty() && !st.peek().equals("(")) {
                        sum += Integer.parseInt(st.pop());
                    }
                    st.push(""+sum);
                }

            }

            return Integer.parseInt(st.pop());
        }
    }

}
