package com.jtarun.practice.leetcode;

/** 744
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
 * find the smallest element in the list that is larger than the given target.
 *
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 */
public class FindSmallestLetterGreaterThanTarget {

    private static class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            char res = 'A';
            char min = letters[0];

            for (char c : letters) {
                if (c < min) min = c;
                if (c > target) {
                    if (res == 'A' || c < res) {
                        res = c;
                    }
                }
            }

            return res == 'A' ? min : res;
        }
    }

}
