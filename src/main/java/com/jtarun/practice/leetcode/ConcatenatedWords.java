package com.jtarun.practice.leetcode;

import java.util.*;

/** 472
 * Given a list of words (without duplicates), please write a program that returns all concatenated words
 * in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words
 * in the given array
 */
public class ConcatenatedWords {

    private static class Solution {
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> res = new ArrayList<>();
            Set<String> dict = new HashSet<>();
            for (String word : words) {
                dict.add(word);
            }

            for (String word : words) {
                if (dfs(word, dict)) {
                    res.add(word);
                }
            }

            return res;
        }


        private boolean dfs(String s, Set<String> dict) {
            for (int k = 1; k < s.length(); k++) {
                String s1 = s.substring(0, k);
                String s2 = s.substring(k, s.length());;
                boolean b1 = dict.contains(s1);
                boolean b2 = dict.contains(s2);
                if (b1 && b2) return true;

                if (b1 && dfs(s2, dict)) return true;
                if (b2 && dfs(s1, dict)) return true;
            }
            return false;
        }
    }

}
