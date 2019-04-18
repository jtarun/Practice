package com.jtarun.practice.leetcode;

import java.util.*;

/** 720
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be
 * built one character at a time by other words in words. If there is more than one possible answer,
 * return the longest word with the smallest lexicographical order.
 *
 * If there is no answer, return the empty string.
 * Example 1:
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 */
public class LongestWordInDictionary {

    private static class Solution {
        public String longestWord(String[] words) {
            Set<String> set = new HashSet<>();
            int max= 0;
            String res = "";
            Arrays.sort(words);
            int i;
            for (String word : words) {
                set.add(word);
                String prefix = "";
                for (i = 0; i < word.length(); i++) {
                    prefix += word.charAt(i);
                    if (!set.contains(prefix)) break;
                }

                if (i == word.length() && i > max) {
                    res = word;
                    max = i;
                }
            }

            return res;
        }
    }

}
