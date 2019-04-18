package com.jtarun.practice.leetcode;

/** 434
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of
 * non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 *
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class NumberOfSegmentsInAString {

    private static class Solution {
        public int countSegments(String s) {
            int i = 0;
            int res = 0;
            int n = s.length();

            while (i < n) {
                while (i < n && space(s.charAt(i))) i++;
                if ( i == n) break;

                res++;
                int j = i;
                while (j < n && !space(s.charAt(j))) j++;

                i = j;
            }

            return res;
        }

        private boolean space(char c) {
            return c == ' ' || c == '\t';
        }
    }

}
