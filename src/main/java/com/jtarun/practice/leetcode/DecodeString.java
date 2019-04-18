package com.jtarun.practice.leetcode;

import java.util.*;

/** 394
 * Given an encoded string, return it's decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for
 * those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 */
public class DecodeString {

    private static class Solution {
        public String decodeString(String s) {
            Stack<String> operator = new Stack<>();
            Stack<String> operand = new Stack<>();
            int n = s.length();

            for (int i = 0; i < s.length(); ) {
                char c = s.charAt(i);

                if (c == '[') {
                    operand.push("" + c);
                    i++;
                } else if (number(c)) {
                    int r = 0;
                    int j = i;
                    while (j < n && number(s.charAt(j))) {
                        r = 10 * r + (s.charAt(j) - '0');
                        j++;
                    }
                    i = j;
                    operator.push("" + r);
                } else if (c == ']') {
                    String t = operand.pop();
                    while (!operand.peek().equals("[")) {
                        t = operand.pop() + t;
                    }
                    operand.pop(); //remove '['

                    int r = Integer.parseInt(operator.pop());
                    StringBuilder sb = new StringBuilder();
                    for (int x = 0; x < r; x++) {
                        sb.append(t);
                    }
                    operand.push(sb.toString());
                    i++;
                } else {
                    int j = i+1;
                    while (j < n && !number(s.charAt(j)) && s.charAt(j) != '[' && s.charAt(j) != ']') j++;
                    operand.push(s.substring(i, j));
                    i = j;
                }

            }

            Stack<String> rev = new Stack<>();
            while(!operand.isEmpty()) {
                rev.push(operand.pop());
            }

            StringBuilder res = new StringBuilder();
            while (!rev.isEmpty()) {
                res.append(rev.pop());
            }

            return res.toString();
        }

        private boolean number(char c) {
            return c >= '0' && c <= '9';
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.decodeString("3[a]2[bc]"));
        System.out.println(sol.decodeString("3[a2[c]]"));
        System.out.println(sol.decodeString("2[abc]3[cd]ef"));
    }

}
