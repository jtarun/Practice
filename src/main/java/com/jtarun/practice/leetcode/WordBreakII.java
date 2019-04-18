package com.jtarun.practice.leetcode;

import java.util.*;

/** 140
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible
 * sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 */
public class WordBreakII {

    private static class Solution {

        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>();
            for (String word : wordDict) set.add(word);

            boolean[] possible = new boolean[s.length()];
            Arrays.fill(possible, true);
            List<String> res = new ArrayList<>();
            dfs(s, 0, new StringBuilder(), res, set, possible);
            return res;
        }

        private boolean dfs(String s, int i, StringBuilder temp, List<String> res, Set<String> dict,
                            boolean[] possible) {
            if (i == s.length()) {
                res.add(temp.toString());
                return true;
            }

            if (!possible[i]) return false;

            boolean success = false;
            for (int j= i; j < s.length(); j++) {
                String sub = s.substring(i, j+1);
                if (dict.contains(sub)) {
                    int len = temp.length();
                    if (temp.length() != 0) temp.append(' ');
                    temp.append(sub);
                    if (dfs(s, j+1, temp, res, dict, possible)) success = true;
                    temp.setLength(len);
                }

            }

            possible[i] = success;
            return success;
        }


        public List<String> wordBreak2(String s, List<String> wordDict) {
            List<String> res = new ArrayList<>();
            if (s.length() == 0) return res;

            Trie trie = new Trie();
            int maxWordLen = 0;
            for (String word : wordDict) {
                trie.add(word);
                maxWordLen = Math.max(maxWordLen, word.length());
            }

            int n = s.length();
            boolean[][] isWord = new boolean[n][n];
            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                Node cur = trie.root;
                for (int j = i; j < Math.min(n, i + maxWordLen); j++) {
                    cur = cur.child(s.charAt(j));
                    if (cur == null) break;
                    if (cur.isWord) {
                        isWord[i][j] = true;
                        dp[i][j] = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if (dp[i][j]) continue;

                    for (int k = i; k < j; k++) {
                        if (dp[i][k] && dp[k+1][j]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }

            helper(s, 0, new StringBuilder(), res, isWord, dp, maxWordLen);

            return res;
        }

        private void helper(String s, int ind, StringBuilder temp, List<String> res, boolean[][] isWord,
                            boolean[][] dp, int maxWordLen) {
            if (ind == s.length()) {
                res.add(temp.toString());
                return;
            }

            for (int i = ind; i < Math.min(ind+maxWordLen, s.length()); i++){

                if (isWord[ind][i]) {
                    StringBuilder newTemp = new StringBuilder(temp);
                    if (newTemp.length() != 0) newTemp.append(' ');
                    newTemp.append(s.substring(ind, i+1));

                    if (i == s.length() - 1 || dp[i+1][s.length()-1]) {
                        helper(s, i+1, newTemp, res, isWord, dp, maxWordLen);
                    }

                }
            }
        }

        private static class Node {
            Map<Character, Node> h = new HashMap<>();
            boolean isWord = false;

            Node add(char c) {
                return h.computeIfAbsent(c, k -> new Node());
            }

            Node child(char c) {
                return h.get(c);
            }
        }

        private static class Trie {
            Node root = new Node();

            void add(String word) {
                Node cur = root;
                for (char c : word.toCharArray()) {
                    cur = cur.add(c);
                }
                cur.isWord = true;
            }

            boolean contains(String word) {
                Node cur = root;
                for (char c : word.toCharArray()) {
                    cur = cur.child(c);
                    if (cur == null) return false;
                }
                return cur.isWord;
            }
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        //String word = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        //List<String> dict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");

        String word = "catsanddog";
        List<String> dict = Arrays.asList("cat","cats","and","sand","dog");


        sol.wordBreak(word, dict)
                .forEach(System.out::println);
    }
}
