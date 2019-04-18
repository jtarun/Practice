package com.jtarun.practice.leetcode;

import java.util.*;

/** 648
 * In English, we have a concept called root, which can be followed by some other words to form another
 * longer word - let's call this word successor. For example, the root an, followed by other, which can
 * form another word another.
 *
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in
 * the sentence with the root forming it. If a successor has many roots can form it, replace it with the root
 * with the shortest length.
 *
 * You need to output the sentence after the replacement.
 *
 * Example 1:
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * Note:
 * The input will only have lower-case letters.
 * 1 <= dict words number <= 1000
 * 1 <= sentence words number <= 1000
 * 1 <= root length <= 100
 * 1 <= sentence words length <= 1000
 */
public class ReplaceWords {

    private static class Solution {
        public String replaceWords(List<String> dict, String sentence) {
            Trie trie = new Trie();
            for (String word: dict) {
                trie.add(word);
            }

            StringBuilder res = new StringBuilder();
            int start = -1, i = 0, n = sentence.length();
            while (i < n) {
                char c = sentence.charAt(i);

                if (c == ' ') {
                    if (start >= 0 && sentence.charAt(start) != ' ') {
                        String word = sentence.substring(start, i);
                        res.append(trie.search(word));
                    }
                    res.append(' ');
                    start = i;
                } else {
                    if (start < 0 || sentence.charAt(start) == ' ') start = i;
                }

                i++;
            }

            if (start >= 0) {
                String word = sentence.substring(start, i);
                res.append(trie.search(word));
            }

            return res.toString();
        }

        private class Node {
            Map<Character, Node> h = new HashMap<>();
            boolean word;

            Node add(char c) {
                return h.computeIfAbsent(c, k -> new Node());
            }

            Node child(char c) {
                return h.get(c);
            }
        }

        private class Trie {
            Node root = new Node();

            void add(String s) {
                Node cur = root;
                for (int i = 0; i < s.length(); i++) {
                    cur = cur.add(s.charAt(i));
                }
                cur.word = true;
            }

            String search(String s) {
                Node cur = root;

                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    cur = cur.child(c);
                    if (cur == null) break;
                    if (cur.word) return s.substring(0, i+1);
                }

                return s;
            }
        }
    }

}
