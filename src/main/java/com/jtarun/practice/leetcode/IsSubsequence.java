package com.jtarun.practice.leetcode;

import java.util.*;

/** 392
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very
 * long (length ~= 500,000) string, and s is a short string (<=100).
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence
 * of "abcde" while "aec" is not).
 */
public class IsSubsequence {

    private static class Solution {

        public boolean isSubsequence(String s, String t) {
            Map<Character, List<Integer>> h = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                h.computeIfAbsent(t.charAt(i), k -> new ArrayList<>()).add(i);
            }

            // process s
            int lastConsumed = -1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                List<Integer> indices = h.get(c);
                if (indices == null) return false;
                int ind = Collections.binarySearch(indices, lastConsumed+1);
                if (ind < 0) ind = -(ind+1);
                if (ind == indices.size()) return false;
                lastConsumed = indices.get(ind);
            }

            return true;
        }

        public boolean isSubsequence2(String s, String t) {
            int j = 0, i= 0;
            while (j < s.length() && i < t.length()) {
                if (t.charAt(i) == s.charAt(j)) j++;
                i++;
            }

            return j == s.length();
        }
    }


}
