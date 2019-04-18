package com.jtarun.practice.leetcode;

import java.util.*;

/** 893
 * You are given an array A of strings.
 *
 * Two strings S and T are special-equivalent if after any number of moves, S == T.
 *
 * A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].
 *
 * Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is
 * not special-equivalent with any string in S.
 *
 * Return the number of groups of special-equivalent strings from A.
 *
 * Example 1:
 *
 * Input: ["a","b","c","a","c","c"]
 * Output: 3
 * Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
 *
 * Example 2:
 *
 * Input: ["abc","acb","bac","bca","cab","cba"]
 * Output: 3
 * Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
 */
public class GroupsOfSpecialEquivalentStrings {

    private static class Solution {
        public int numSpecialEquivGroups(String[] A) {
            Set<String> s = new HashSet<>();
            for (String a : A) {
                s.add(transform(a));
            }
            return s.size();
        }

        private String transform(String a) {
            int n = a.length();
            if (n <= 2) return a;

            int[] h1 = new int[26];
            int[] h2 = new int[26];
            for (int i = 0; i < a.length(); i += 2) {
                h1[a.charAt(i)-'a']++;
            }
            for (int i = 1; i < a.length(); i += 2) {
                h2[a.charAt(i) - 'a']++;
            }

            int oddLength = (a.length() + 1) / 2;
            char[] odd = new char[oddLength];
            char[] even = new char[a.length() - oddLength];

            sort(h1, odd);
            sort(h2, even);

            return (new String(odd)) + (new String(even));
        }

        private void sort(int[] h, char[] arr) {
            int k = 0;
            for (int i = 0; i < 26; i++) {
                char c = (char)('a' + i);
                while (h[i] > 0) {
                    h[i]--;
                    arr[k++] = c;
                }
            }
        }
    }

}
