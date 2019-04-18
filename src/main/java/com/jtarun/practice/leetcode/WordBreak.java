package com.jtarun.practice.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 139
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 */
public class WordBreak {

    private static class Solution {

        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> h = new HashSet<>();
            for (String word : wordDict) h.add(word);

            int n = s.length();
            boolean[] dp = new boolean[n+1];

            for (int l = 1; l <= n; l++) {
                if (h.contains(s.substring(0, l))) dp[l] = true;
            }

            for (int i = 1; i < n; i++) {
                for (int j = i-1; j >= 0; j--) {
                    if (dp[j+1] && h.contains(s.substring(j+1, i+1))) {
                        dp[i+1] = true;
                        break;
                    }
                }
            }

            return dp[n];
        }

        // brute force (TLE)
        public boolean wordBreak2(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>();
            for (String word : wordDict) dict.add(word);

            return helper(s, dict);
        }

        private boolean helper(String s, Set<String> dict) {
            if (s.isEmpty()) return true;

            for (int i = 1; i <= s.length(); i++) {
                String w = s.substring(0, i);
                if (dict.contains(w)) {
                    if (i < s.length()) {
                        if( helper(s.substring(i, s.length()), dict)) return true;
                    } else return true;
                }
            }

            return false;
        }
    }

}
