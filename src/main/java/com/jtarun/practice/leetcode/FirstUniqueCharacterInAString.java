package com.jtarun.practice.leetcode;

/** 387
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {

    private static class Solution {
        public int firstUniqChar(String s) {
            int[] a = new int[26];

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (a[c-'a'] == 0) a[c-'a'] = i+1;
                else if (a[c-'a'] > 0) a[c-'a'] = -a[c-'a'];
            }

            int min = Integer.MAX_VALUE;

            for (int i = 0; i < 26; i++) {
                if (a[i] > 0) min = Math.min(min, a[i]);
            }

            return min == Integer.MAX_VALUE ? -1 : min-1;
        }
    }

}
