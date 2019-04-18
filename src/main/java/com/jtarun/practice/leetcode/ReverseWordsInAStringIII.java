package com.jtarun.practice.leetcode;

/** 557
 * Given a string, you need to reverse the order of characters in each word within a sentence while still
 * preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsInAStringIII {

    private static class Solution {
        public String reverseWords(String s) {
            if (s.length() == 0) return s;

            int i = 0, n = s.length(), k = 0;
            char[] str = new char[n];
            while (i < n) {
                int j = i;
                while (j < n && s.charAt(j) != ' ') j++;
                if (k > 0) str[k++] = ' ';
                for (int l = j-1; l >= i; l--) str[k++] = s.charAt(l);
                i = j + 1;
            }

            return new String(str);
        }
    }

}
