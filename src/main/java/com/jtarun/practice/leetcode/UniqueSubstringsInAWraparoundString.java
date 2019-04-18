package com.jtarun.practice.leetcode;

import java.util.*;

/** 467
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz",
 * so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 *
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.
 *
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 */
public class UniqueSubstringsInAWraparoundString {

    private static class Solution {

        public int findSubstringInWraproundString(String p) {
            int i = 0, res = 0;
            int[] maxEnding = new int[26];
            while (i < p.length()) {

                int j = i+1;
                maxEnding[p.charAt(i) - 'a'] = Math.max(maxEnding[p.charAt(i) - 'a'], 1);

                while (j < p.length() && neighbour(p.charAt(j-1), p.charAt(j))) {
                    maxEnding[p.charAt(j) - 'a'] = Math.max(maxEnding[p.charAt(j) - 'a'], j-i+1);
                    j++;
                }

                i = j;
            }


            for (i = 0; i < 26; i++) {
                res += maxEnding[i];
            }

            return res;
        }

        private boolean neighbour(char c, char d) {
            if (c == 'z' && d == 'a') return true;
            return d-c == 1;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findSubstringInWraproundString("zab"));
    }

}
