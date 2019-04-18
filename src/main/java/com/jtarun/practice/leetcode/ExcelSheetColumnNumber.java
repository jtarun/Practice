package com.jtarun.practice.leetcode;

/** 171
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 */
public class ExcelSheetColumnNumber {

    private static class Solution {
        public int titleToNumber(String s) {
            int res = 0;

            for (int i = 0; i < s.length(); i++) {
                res = res* 26 + (s.charAt(i) - 'A' + 1);
            }

            return res;
        }
    }

}
