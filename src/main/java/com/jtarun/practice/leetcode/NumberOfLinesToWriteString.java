package com.jtarun.practice.leetcode;

/** 806
 * We are to write the letters of a given string S, from left to right into lines.
 * Each line has maximum width 100 units, and if writing a letter would cause the width of the line to exceed
 * 100 units, it is written on the next line. We are given an array widths, an array where widths[0] is
 * the width of 'a', widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.
 *
 * Now answer two questions: how many lines have at least one character from S, and what is the width used
 * by the last such line? Return your answer as an integer list of length 2.
 *
 *
 *
 * Example :
 * Input:
 * widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "abcdefghijklmnopqrstuvwxyz"
 * Output: [3, 60]
 * Explanation:
 * All letters have the same length of 10. To write all 26 letters,
 * we need two full lines and one line with 60 units.
 */
public class NumberOfLinesToWriteString {

    private static class Solution {
        public int[] numberOfLines(int[] widths, String S) {
            int curCount = 0, lines = 0;
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                int cnt = widths[c-'a'];
                if (curCount + cnt <= 100) {
                    curCount = curCount + cnt;
                } else {
                    curCount = cnt;
                    lines++;
                }
            }

            int[] res = new int[2];
            res[0] = lines+1;
            res[1] = curCount;

            return res;
        }
    }

}
