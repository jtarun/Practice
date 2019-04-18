package com.jtarun.practice.leetcode;

import java.util.*;

/** 890
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in
 * the pattern with p(x), we get the desired word.
 *
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter,
 * and no two letters map to the same letter.)
 *
 * Return a list of the words in words that match the given pattern.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 * since a and b map to the same letter.
 *
 *
 * Note:
 *
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 */
public class FindAndReplacePattern {

    private static class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> res = new ArrayList<>();
            for (String word : words) {
                if (match(word, pattern)) res.add(word);
            }

            return res;
        }

        private boolean match(String word, String pattern) {

            if (pattern.length() != word.length()) return false;

            int i = 0;
            int n = pattern.length();
            Map<Character, Character> h = new HashMap<>();

            boolean[] used = new boolean[256];
            while (i < n) {
                char c = word.charAt(i);
                char d = pattern.charAt(i);
                i++;

                if (h.containsKey(c)) {
                    if (h.get(c) != d)return false;
                } else {
                    if (used[d]) return false;

                    h.put(c, d);
                    used[d] = true;
                }

            }

            return true;
        }

    }

}
