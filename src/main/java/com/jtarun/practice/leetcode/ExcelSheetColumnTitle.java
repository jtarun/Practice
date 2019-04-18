package com.jtarun.practice.leetcode;

/** 168
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 */
public class ExcelSheetColumnTitle {

    private static class Solution {
        public String convertToTitle(int n) {
            StringBuilder res = new StringBuilder();

            while (n > 0) {
                int d = n % 26;
                char c = (d == 0) ? 'Z' : (char)('A' + d - 1);
                res.append(c);

                n = (n-1)/26;
            }

            return res.reverse().toString();
        }
    }
}
