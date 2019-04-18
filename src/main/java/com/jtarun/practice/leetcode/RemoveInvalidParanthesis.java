package com.jtarun.practice.leetcode;

import java.util.*;

/** 301
 * Remove the minimum number of invalid parentheses in order to make the input string valid.
 * Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 */
public class RemoveInvalidParanthesis {
    private static class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();

            Queue<List<Character>> q = new LinkedList<>();
            List<Character> root = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) root.add(s.charAt(i));
            q.offer(root);

            Set<List<Character>> visited = new HashSet<>();
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    List<Character> t = q.poll();
                    if (valid(t)) {
                        res.add(toString(t));
                    }

                    if (res.size() > 0) continue;

                    for (int i = 0; i < t.size(); i++) {
                        char c = t.get(i);
                        if (c != '(' && c != ')') continue;

                        List<Character> child = new LinkedList<>();
                        for (int j = 0; j < t.size(); j++) {
                            if (j == i) continue;
                            child.add(t.get(j));
                        }

                        if (!visited.contains(child)) {
                            visited.add(child);
                            q.offer(child);
                        }
                    }

                }

                if (res.size() > 0) break;
            }

            return res.size() > 0 ? res : new ArrayList<>(Arrays.asList(""));
        }

        private boolean valid(List<Character> exp) {
            Stack<Character> s = new Stack<>();
            for (Character c : exp) {

                if (c != '(' && c != ')') continue;

                if (s.isEmpty() || c == '(') s.push(c);
                else if (c == ')') {
                    if (s.isEmpty() || s.peek() != '(') return false;
                    s.pop();
                }
            }

            return s.isEmpty();
        }

        private String toString(List<Character> e) {
            StringBuilder sb = new StringBuilder();
            for (Character c : e) {
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
