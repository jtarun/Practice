package com.jtarun.practice.leetcode;

/** 551 (Easy)
 * You are given a string representing an attendance record for a student. The record only contains the
 * following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more
 * than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class StudentAttendanceRecordI {

    private static class Solution {
        public boolean checkRecord(String s) {
            int aCount = 0;
            int  i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (c == 'A') {
                    aCount++;
                    if (aCount > 1) return false;
                } else if (c == 'L') {
                    int j = i+1;
                    while (j < s.length() && s.charAt(j) == 'L') {
                        j++;
                        if (j-i > 2) return false;
                    }
                }
                i++;
            }

            return true;
        }
    }

}
