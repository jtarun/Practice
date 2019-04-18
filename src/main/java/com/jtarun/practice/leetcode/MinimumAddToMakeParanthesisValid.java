package com.jtarun.practice.leetcode;

/** 921
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any
 * positions ) so that the resulting parentheses string is valid.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 */
public class MinimumAddToMakeParanthesisValid {

    private static class Solution {
        public int minAddToMakeValid(String s) {
            int diff = 0;
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') {
                    diff++;
                } else {
                    diff--;
                }

                if (diff < 0) {
                    diff = 0;
                    res++;
                }
            }

            return res + diff;
        }
    }

}
