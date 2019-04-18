package com.jtarun.practice.leetcode;


/** 541
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from
 * the start of the string. If there are less than k characters left, reverse all of them. If there are
 * less than 2k but greater than or equal to k characters, then reverse the first k characters and left the
 * other as original.
 *
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII {

    private static class Solution {
        public String reverseStr(String s, int k) {
            if (k <= 1) return s;

            char[] str = s.toCharArray();
            int i = 0;
            while (i < str.length) {
                reverse(str, i, k);
                i += 2*k;
            }

            return new String(str);
        }

        private void reverse(char[] s, int i, int len) {
            int j = i + len - 1;
            if (j >= s.length) j = s.length-1;

            while (i < j) {
                char t = s[i];
                s[i++] = s[j];
                s[j--] = t;
            }
        }
    }

}
