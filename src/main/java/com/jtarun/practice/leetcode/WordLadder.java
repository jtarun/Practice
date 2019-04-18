package com.jtarun.practice.leetcode;

import java.util.*;

/** 127
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder {

    private static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<String> q = new LinkedList<>();
            q.offer(beginWord);
            int n = beginWord.length();

            Set<String> dict = new HashSet<>();
            for (String word : wordList) {
                dict.add(word);
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                cnt++;

                while (size-- > 0) {
                    String t = q.poll();
                    char[] sb = t.toCharArray();
                    for (int i = 0; i < n; i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == t.charAt(i)) continue;
                            sb[i] = c;
                            String s = new String(sb);
                            if (dict.contains(s)) {
                                if (s.equals(endWord)) {
                                    return cnt+1;
                                }
                                q.offer(s);
                                dict.remove(s);
                            }
                        }
                        sb[i] = t.charAt(i);
                    }

                }

            }

            return 0;
        }
    }


}
