package com.jtarun.practice.leetcode;

import java.util.*;

/** 916 (Medium)
 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.
 *
 * Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.
 * For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 *
 * Now say a word a from A is universal if for every b in B, b is a subset of a.
 *
 * Return a list of all universal words in A.  You can return the words in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * Output: ["facebook","google","leetcode"]
 */
public class WordSubsets {

    private static class Solution {
        public List<String> wordSubsets(String[] A, String[] B) {
            int[] max = new int[26];
            for (String s : B) {
                int[] h = new int[26];
                count(s, h);
                for (int i = 0; i < 26; i++) {
                    max[i] = Math.max(max[i], h[i]);
                }
            }

            List<String> res = new ArrayList<>();
            for (String s : A) {
                int[] h = new int[26];
                count(s, h);
                boolean success = true;
                for (int i = 0; i < 26; i++) {
                    if (h[i] < max[i]) {
                        success = false;
                        break;
                    }
                }

                if (success) res.add(s);
            }

            return res;
        }

        void count(String s, int[] h) {
            for (int i = 0; i < s.length(); i++) {
                h[s.charAt(i)-'a']++;
            }
        }

    }

}
