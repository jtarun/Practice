package com.jtarun.practice.leetcode;

import java.util.*;

/** 212
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * Example:
 *
 * Input:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * Output: ["eat","oath"]
 * Note:
 * You may assume that all inputs consist of lowercase letters a-z.
 */
public class WordSearchII {

    private static class Solution {

        private class Node {
            Node[] children = new Node[26];
            boolean word = false;

            Node insert(char c) {
                int ind = c - 'a';
                if (children[ind] == null) {
                    children[ind] = new Node();
                }
                return children[ind];
            }

            void setWord() {
                this.word = true;
            }

            boolean isWord() {
                return this.word;
            }
        }

        private class Trie {
            Node root = new Node();

            void insert(String s) {
                Node cur = root;
                for (int i = 0; i < s.length(); i++) {
                    cur = cur.insert(s.charAt(i));
                }
                cur.setWord();
            }

            // -1 -> not a prefix
            // 0 -> prefix but not word
            // 1 -> word
            int contains(String s) {
                Node cur = root;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (cur.children[c-'a'] == null) return -1;
                    cur = cur.children[c-'a'];
                }

                return cur.isWord() ? 1 : 0;
            }
        }


        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            if (words.length == 0 || board.length == 0 || board[0].length == 0) return res;

            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }

            int m = board.length;
            int n = board[0].length;

            Set<String> found = new HashSet<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    boolean[][] v = new boolean[m][n];
                    v[i][j] = true;
                    dfs(board, i, j, m, n, v, found, "" + board[i][j], trie);

                }
            }

            res.addAll(found);
            return res;
        }

        int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0, -1}};

        private void dfs(char[][] b, int i, int j, int m, int n, boolean[][] v, Set<String> res, String prefix, Trie trie) {

            int r = trie.contains(prefix);
            if (r == 1) {
                res.add(prefix);
            } else if (r == -1) {
                return;
            }

            for (int[] d : dirs) {
                int x = i + d[0];
                int y = j + d[1];

                if (x < 0 || y < 0 || x >= m || y >= n || v[x][y]) continue;

                v[x][y] = true;
                dfs(b, x, y, m, n, v, res, prefix + b[x][y], trie);
                v[x][y] = false;
            }

        }
    }

}
