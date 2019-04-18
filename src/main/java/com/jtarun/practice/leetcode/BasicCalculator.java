package com.jtarun.practice.leetcode;

import java.util.*;

/** 224
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative
 * integers and empty spaces .
 *
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class BasicCalculator {

    private static class Solution {
        public int calculate(String s) {
            Stack<Integer> operand = new Stack<>();
            Stack<Character> operator = new Stack<>();

            int i = 0, n = s.length();
            while (i < n) {
                char c = s.charAt(i);

                if (c == ' '){
                } else if (c == '(') operator.push(c);
                else if (digit(c)) {
                    int j = i+1;
                    int num = c-'0';
                    while (j < n && digit(s.charAt(j))) {
                        num = num*10 + (int)(s.charAt(j) - '0');
                        j++;
                    }
                    operand.push(num);

                    i = j-1;
                } else if (c == ')') {
                    while (!operator.isEmpty() && operator.peek() != '(') {
                        char op = operator.pop();
                        int operand2 = operand.pop();
                        int operand1 = operand.pop();
                        operand.push(apply(operand1, operand2, op));
                    }
                    operator.pop();

                } else {
                    if (!operator.isEmpty() && operator.peek() != '(') {
                        char op = operator.pop();
                        int operand2 = operand.pop();
                        int operand1 = operand.pop();
                        operand.push(apply(operand1, operand2, op));
                    }
                    operator.push(c);
                }
                i++;
            }

            while (!operator.isEmpty()) {
                int operand2 = operand.pop();
                int operand1 = operand.pop();
                operand.push(apply(operand1, operand2, operator.pop()));
            }

            return operand.pop();
        }

        private boolean digit(char c) {
            return c >= '0' &&  c <= '9';
        }

        private int apply(int o1, int o2, int op) {
            if (op == '+') return o1 + o2;
            return o1 - o2;
        }
    }

}
