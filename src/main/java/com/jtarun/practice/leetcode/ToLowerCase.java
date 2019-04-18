package com.jtarun.practice.leetcode;

/** 709
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 */
public class ToLowerCase {

    private static class Solution {
        public String toLowerCase(String str) {
            char[] s = str.toCharArray();

            for (int i = 0; i < s.length; i++) {
                if (s[i] >= 'A' && s[i] <= 'Z') s[i] += 32;
            }

            return new String(s);
        }
    }

}
