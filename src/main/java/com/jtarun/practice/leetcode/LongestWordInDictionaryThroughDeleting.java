package com.jtarun.practice.leetcode;

import java.util.*;

/** 524
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting
 * some characters of the given string. If there are more than one possible results, return the longest word with the
 * smallest lexicographical order. If there is no possible result, return the empty string.
 *
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * Output:
 * "apple"
 */
public class LongestWordInDictionaryThroughDeleting {

    private static class Solution {
        public String findLongestWord(String s, List<String> d) {
            Collections.sort(d);
            String res = "";
            int max = 0;
            for (String word:  d) {
                if (subsequence(s, word) && word.length() > max) {
                    res = word;
                    max = word.length();
                }
            }
            return res;
        }

        private boolean subsequence(String s, String t) {
            int i = s.length() -1, j = t.length() - 1;

            while (i >= 0 && j >= 0) {
                char c = t.charAt(j);
                while (i >= 0 && s.charAt(i) != c) i--;
                if (i >= 0) j--;
                i--;
            }

            return j < 0;
        }
    }

}
