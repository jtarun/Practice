package com.jtarun.practice.leetcode;


import java.util.*;

/** 819
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list
 * of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer
 * is unique.
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 */
public class MostCommonWord {

    private static class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> s = new HashSet<>();
            for (String b : banned) s.add(b);
            int i = 0, n = paragraph.length();
            Map<String, Integer> h = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            while (i < n) {
                char c = paragraph.charAt(i);
                if (symbol(c)) {
                    if (sb.length() > 0) {
                        String word = sb.toString();
                        if (!s.contains(word)) {
                            h.put(word, h.getOrDefault(word,0)+1);
                        }
                        sb.setLength(0);
                    }
                } else {
                    sb.append(c >= 'A' && c <= 'Z' ? (char)(c + 32) : c);
                }

                i++;
            }

            if (sb.length() > 0) {
                String word = sb.toString();
                if (!s.contains(word)) {
                    h.put(word, h.getOrDefault(word,0)+1);
                }
            }

            int max = 0;
            String res = "";
            for (String word : h.keySet()) {
                int freq = h.get(word);
                if (freq > max) {
                    max = freq;
                    res = word;
                }
            }

            return res;
        }

        private boolean symbol(char c) {
            boolean ch = (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
            return !ch;
        }
    }

}
