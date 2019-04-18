package com.jtarun.practice.leetcode;

import java.util.*;

/** 227 (Medium)
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 *
 * Example 1:
 * Input: "3+2*2"
 * Output: 7
 *
 * Example 2:
 * Input: " 3/2 "
 * Output: 1
 *
 * Example 3:
 * Input: " 3+5 / 2 "
 * Output: 5
 */
public class BasicCalculatorII {

    private static class Solution {
        public int calculate(String s) {
            List<String> tokens = new ArrayList<>();
            int i = 0, n = s.length();
            while (i < n) {
                char c = s.charAt(i);
                if (c == ' ') {
                    i++;
                    continue;
                }

                if (operator(c)) {
                    i++;
                    tokens.add("" + c);
                    continue;
                }

                int j = i;
                while (j < n && digit(s.charAt(j))) j++;
                tokens.add(s.substring(i, j));

                i = j;
            }
            if (tokens.size() == 0) return 0;

            Map<Character, Integer> precedence = new HashMap<>();
            precedence.put('+', 1);
            precedence.put('-', 1);
            precedence.put('*', 4);
            precedence.put('/', 4);

            Stack<Integer> operand = new Stack<>();
            Stack<Character> operator = new Stack<>();
            for (i = 0; i < tokens.size(); i++) {
                String token = tokens.get(i);
                if (operator(token.charAt(0))) {
                    char op = token.charAt(0);
                    if (operator.isEmpty() || (precedence.get(op) > precedence.get(operator.peek()))) operator.push(op);
                    else {
                        while (!operator.isEmpty() && (precedence.get(op) <= precedence.get(operator.peek()))) {
                            int operand2 = operand.pop();
                            int operand1 = operand.pop();

                            int x = apply(operand1, operand2, operator.pop());
                            operand.push(x);
                        }
                        operator.push(op);
                    }

                } else {
                    operand.push(Integer.parseInt(token));
                }

            }

            while (!operator.isEmpty()) {
                int operand2 = operand.pop();
                int operand1 = operand.pop();

                int x = apply(operand1, operand2, operator.pop());
                operand.push(x);
            }

            return operand.pop();
        }

        private int apply(int operand1, int operand2, char op) {
            if (op == '+') {
                return operand1 + operand2;
            } else if (op == '-') {
                return operand1 - operand2;
            } else if (op == '*') {
                return operand1 * operand2;
            }

            return operand1 / operand2;
        }

        private boolean operator(char c) {
            return (c == '+' || c == '/' || c == '-' || c == '*');
        }

        private boolean digit(char c) {
            return c>= '0' &&  c <= '9';

        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int res = sol.calculate("1+2*5/3+6/4*2");
        System.out.println(res);
    }

}
