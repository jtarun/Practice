package com.jtarun.practice.leetcode;

import java.util.*;

public class DifferentWaysToAddParentheses {

    private static class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            Map<Integer, List<Integer>> h = new HashMap<>();
            return helper(input.toCharArray(), 0, input.length()-1, h);

        }

        List<Integer> helper(char[] input, int s, int e, Map<Integer, List<Integer>> h) {
            int ind = s*input.length + e;
            if (h.containsKey(ind)) return h.get(ind);


            List<Integer> res = new ArrayList<>();
            for (int i = s; i <= e; i++) {

                if (operator(input[i])) {

                    List<Integer> l1 = helper(input, s, i-1, h);
                    List<Integer> l2 = helper(input, i+1, e, h);

                    for (int x : l1) {
                        for (int y : l2) {
                            int r = apply(x, y, input[i]);
                            res.add(r);
                        }
                    }
                }
            }

            if (res.isEmpty()) {
                int val = 0;
                while (s <= e) {
                    val = val*10 + (int)(input[s] - '0');
                    s++;
                }

                res.add(val);
            }

            h.put(ind, res);

            return res;
        }

        private boolean operator(char c) {
            return c == '+' || c == '-' || c == '*';
        }

        private int apply(int a, int b, char op) {
            if (op == '+') return a+b;
            if (op == '-') return a-b;
            return a*b;
        }

    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.diffWaysToCompute("2*3-4*5").forEach(System.out::println);
    }

}
