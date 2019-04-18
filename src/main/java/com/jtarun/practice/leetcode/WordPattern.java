package com.jtarun.practice.leetcode;

import java.util.*;

/** 290
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty
 * word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 */
public class WordPattern {

    private static class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] parts = str.split(" ");
            if (pattern.length() != parts.length) return false;
            int n = pattern.length();
            Map<String, Character> h = new HashMap<>();
            boolean[] used = new boolean[26];

            for (int i = 0; i < n; i++) {
                String s = parts[i];
                char c = pattern.charAt(i);
                if (h.containsKey(parts[i])) {
                    if (h.get(s) != c) return false;
                } else {
                    int ind = c - 'a';
                    if (used[ind]) return false;
                    used[ind] = true;
                    h.put(s, c);
                }

            }


            return true;
        }
    }

}
