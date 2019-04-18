package com.jtarun.practice.leetcode;

/** 917
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
 * and all letters reverse their positions.
 *
 *
 *
 * Example 1:
 *
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 *
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 */
public class ReverseOnlyLetters {

    private static class Solution {
        public String reverseOnlyLetters(String S) {
            if (S.length() == 0) return S;

            char[] str = S.toCharArray();
            int i = 0, j = S.length()-1;
            while (i < j) {
                if (!letter(str[i])) {
                    i++;
                    continue;
                }
                if (!letter(str[j])) {
                    j--;
                    continue;
                }

                char t = str[i];
                str[i] = str[j];
                str[j] = t;
                i++;
                j--;
            }

            return new String(str);
        }

        private boolean letter(char c) {
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }
    }

}
