package com.jtarun.practice.leetcode;

/** 520
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 * Example 1:
 * Input: "USA"
 * Output: True
 *
 * Example 2:
 * Input: "FlaG"
 * Output: False
 *
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class DetectCapital {

    private static class Solution {
        public boolean detectCapitalUse(String word) {
            int n = word.length();
            if (n <= 1) return true;

            int diff = 0;
            char first = word.charAt(0);
            char second = word.charAt(1);
            if ((first >= 'A' && first <= 'Z') && (second >= 'A' && second <= 'Z')) diff = 32;

            for (int i = 1; i < n; i++ ) {
                char c = (char)(word.charAt(i) + diff);
                if (c < 'a' || c > 'z') return false;
            }

            return true;
        }
    }

}
