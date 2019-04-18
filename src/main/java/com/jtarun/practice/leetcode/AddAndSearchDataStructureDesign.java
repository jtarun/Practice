package com.jtarun.practice.leetcode;

import java.util.*;


/** 211
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or '.'.
 * A . means it can represent any one letter.
 */
public class AddAndSearchDataStructureDesign {

    private static class WordDictionary {
        private static class Node {
            Map<Character, Node> children = new HashMap<>();
            boolean isWord = false;

            Node add(char c) {
                return children.computeIfAbsent(c, k -> new Node());
            }
            Node child(char c) {
                return children.get(c);
            }
        }


        private static class Trie {
            Node root;
            Trie() {
                root = new Node();
            }

            public void addWord(String word) {
                Node cur = root;
                for (char c : word.toCharArray()) {
                    cur = cur.add(c);
                }
                cur.isWord = true;
            }

            public boolean search(String word) {
                return search(word.toCharArray(), 0, root);
            }

            private boolean search(char[] word, int i, Node cur) {
                if (cur == null) return false;
                if (i == word.length) {
                    return cur.isWord;
                }

                if (word[i] == '.') {
                    for (Node child : cur.children.values()) {
                        if (search(word, i+1, child)) return true;
                    }
                } else {
                    Node child = cur.child(word[i]);
                    return search(word, i+1, child);
                }

                return false;
            }

        }

        Trie trie;

        /** Initialize your data structure here. */
        public WordDictionary() {
            trie = new Trie();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            trie.addWord(word);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return trie.search(word);
        }
    }

}
