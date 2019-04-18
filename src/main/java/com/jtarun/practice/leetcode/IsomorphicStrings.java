package com.jtarun.practice.leetcode;

import java.util.*;

/** 205
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class IsomorphicStrings {

    private static class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> h = new HashMap<>();
            Set<Character> used = new HashSet<>();
            int n = s.length();

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                char d = t.charAt(i);
                if (h.containsKey(c)) {
                    if (h.get(c) != d) return false;
                } else {
                    if (used.contains(d)) return false;
                    h.put(c, d);
                    used.add(d);
                }

            }


            return true;
        }
    }

}
