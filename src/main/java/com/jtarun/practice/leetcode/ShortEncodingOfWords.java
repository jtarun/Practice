package com.jtarun.practice.leetcode;

import java.util.*;

/** 820
 * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.
 *
 * For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#"
 * and indexes = [0, 2, 5].
 *
 * Then for each index, we will recover the word by reading from the reference string from that index until
 * we reach a "#" character.
 *
 * What is the length of the shortest reference string S possible that encodes the given words?
 *
 * Example:
 *
 * Input: words = ["time", "me", "bell"]
 * Output: 10
 * Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 *
 * Note:
 *
 * 1 <= words.length <= 2000.
 * 1 <= words[i].length <= 7.
 * Each word has only lowercase letters.
 */
public class ShortEncodingOfWords {

    private static class Solution {

        public int minimumLengthEncoding(String[] words) {
            Trie trie = new Trie();
            for (String word: words) trie.add(word);
            int res = 0;
            for (String word : words) {
                if (trie.search(word)){
                    res += word.length()+1;
                }
            }
            return res;
        }

        private static class Node {
            Map<Character, Node> children = new HashMap<>();
            boolean isWord;
        }

        private static class Trie {
            Node root = new Node();

            void add(String word) {
                Node cur = root;
                boolean newWord = false;
                for (int i = word.length()-1; i >= 0; i--) {
                    char c = word.charAt(i);
                    Node child = cur.children.get(c);
                    if (child == null) {
                        cur.children.put(c, new Node());
                        newWord = true;
                    }
                    cur = cur.children.get(c);
                    if (i > 0) cur.isWord = false; // duplicate words are counted.
                }
                if (newWord) cur.isWord = true;
            }

            boolean search(String word) {
                Node cur = root;
                for (int i = word.length()-1; i >= 0; i--) {
                    char c = word.charAt(i);
                    Node child = cur.children.get(c);
                    if (child == null) return false;
                    cur = child;
                }
                boolean res = cur.isWord;
                cur.isWord = false;
                return res;
            }

        }

    }

}
