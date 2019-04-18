package com.jtarun.practice.leetcode;

import java.util.*;


/** 438
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInAString {

    private static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int m = s.length();
            int n = p.length();
            if (n > m || n == 0) return res;

            int[] a = new int[26];
            int[] b = new int[26];

            for (int i = 0; i < n; i++) a[p.charAt(i)-'a']++;

            int start = 0;
            for (int i = 0; i < m; i++) {
                char c = s.charAt(i);
                b[c-'a']++;
                while (b[c-'a'] > a[c-'a']) {
                    b[s.charAt(start)-'a']--;
                    start++;
                }
                if (i-start+1 == n) res.add(start);
            }

            return res;
        }
    }

}
