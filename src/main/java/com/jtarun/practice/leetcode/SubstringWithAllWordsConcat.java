package com.jtarun.practice.leetcode;

import java.util.*;

/** 30
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting
 * indices of substring(s) in s that is a concatenation of each word in words exactly once and without
 * any intervening characters.
 */
public class SubstringWithAllWordsConcat {

    private static class Solution {

        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();

            if (words.length == 0) return res;
            int wlen = words[0].length();
            int n = words.length;
            if (wlen * n > s.length()) return res;

            Map<Integer, String> h = new HashMap<>();
            Map<String, Integer> dict = new HashMap<>();
            for (String word : words) {
                int cnt = dict.getOrDefault(word, 0);
                dict.put(word, cnt+1);
            }

            for (int i = 0; i < s.length() - wlen + 1; i++) {
                String t = s.substring(i, i + wlen);
                if (dict.containsKey(t)) {
                    h.put(i, t);
                }
            }

            for (int i = 0; i < s.length() - wlen * n + 1; i++) {
                if (h.containsKey(i)) {
                    Map<String, Integer> found = copy(dict);
                    int count = 0;
                    for (int j = i; j < s.length() && j < i + n * wlen; j += wlen) {
                        String str = h.get(j);
                        if (str == null) break;
                        int cnt = found.get(str);
                        if (cnt == 0) break;
                        found.put(str, cnt-1);
                        count++;
                    }
                    if (count == n) {
                        res.add(i);
                    }
                }
            }

            return res;
        }

        private Map<String, Integer> copy(Map<String, Integer> dict) {
            Map<String, Integer> c = new HashMap<>();
            for (Map.Entry<String, Integer> entry : dict.entrySet()) {
                c.put(entry.getKey(), entry.getValue());
            }
            return c;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})
                .forEach(x -> System.out.print(x + ", "));
    }

}
