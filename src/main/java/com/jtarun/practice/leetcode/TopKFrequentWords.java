package com.jtarun.practice.leetcode;

import java.util.*;

/** 692
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency,
 * then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 */
public class TopKFrequentWords {

    private static class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> h = new HashMap<>();
            for (String word : words) h.put(word, h.getOrDefault(word, 0) + 1);

            Comparator<Map.Entry<String, Integer>> cmp = (a, b) -> {
                int c = Integer.compare(b.getValue(), a.getValue());
                if (c == 0) c = a.getKey().compareTo(b.getKey());
                return c;
            };
            TreeSet<Map.Entry<String, Integer>> s = new TreeSet<>(cmp);

            for (Map.Entry<String, Integer> entry : h.entrySet()) {
                s.add(entry);
                if (s.size() > k) {
                    s.pollLast();
                }
            }

            List<String> res = new ArrayList<>();
            while (!s.isEmpty()) {
                res.add(s.pollFirst().getKey());
            }

            return res;
        }
    }

}
