package com.jtarun.practice.leetcode;

import java.util.*;


/** 522
 * Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon
 * subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any
 * subsequence of the other strings.
 *
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing
 * the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a
 * subsequence of any string.
 *
 * The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence.
 * If the longest uncommon subsequence doesn't exist, return -1.
 *
 * Example 1:
 * Input: "aba", "cdc", "eae"
 * Output: 3
 * Note:
 *
 * All the given strings' lengths will not exceed 10.
 * The length of the given list will be in the range of [2, 50].
 */
public class LongestUncommonSubsequenceII {

    private static class Solution {
        public int findLUSlength(String[] strs) {
            Map<String, Integer> h = new HashMap<>();
            for (String str : strs) {
                h.put(str, h.getOrDefault(str, 0) + 1);
            }

            List<String> duplicates = new ArrayList<>();
            List<String> uniques = new ArrayList<>();
            for (Map.Entry<String, Integer> e : h.entrySet()) {
                if (e.getValue() == 1) uniques.add(e.getKey());
                else duplicates.add(e.getKey());
            }

            int res = -1;
            for (String str : uniques) {
                boolean found = false;
                for (String duplicate : duplicates) {
                    if (subsequence(str, duplicate)) {
                        found = true;
                        break;
                    }
                }
                if (!found) res = Math.max(res, str.length());
            }

            return res;
        }


        private boolean subsequence(String s, String t) {

            int i = s.length()-1, j = t.length()-1;
            while (i >= 0 && j >= 0) {

                while (j >= 0 && t.charAt(j) != s.charAt(i)) j--;

                if (j < 0) return false;

                i--;
                j--;
            }

            return i < 0;
        }

    }

}
