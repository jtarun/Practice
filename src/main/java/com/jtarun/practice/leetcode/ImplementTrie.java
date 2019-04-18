package com.jtarun.practice.leetcode;

/** 208
 *  Implement a trie with insert, search, and startsWith methods.
 *
 *  Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 *
 */
public class ImplementTrie {

    private static class Trie {

        private class Node {
            Node[] children = new Node[26];
            boolean isWord = false;

            Node insert(char c) {
                int ind = (int)(c - 'a');
                if (children[ind] == null) children[ind] = new Node();
                return children[ind];
            }

            Node child(char c) {
                int ind = (int) (c - 'a');
                return children[ind];
            }
        }

        Node root;


        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                cur = cur.insert(word.charAt(i));
            }
            cur.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                cur = cur.child(word.charAt(i));
                if (cur == null) return false;
            }

            return cur.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                cur = cur.child(prefix.charAt(i));
                if (cur == null) return false;
            }

            return true;
        }
    }

}
