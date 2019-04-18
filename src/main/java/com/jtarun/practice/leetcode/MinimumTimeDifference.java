package com.jtarun.practice.leetcode;

import java.util.*;

/** 539
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 */
public class MinimumTimeDifference {

    private static class Solution {
        public int findMinDifference(List<String> timePoints) {

            int[] min = new int[timePoints.size()];
            for (int i = 0; i < min.length; i++) {
                min[i] = getMin(timePoints.get(i));
            }

            Arrays.sort(min);
            int res = Integer.MAX_VALUE;
            for (int i = 1; i < min.length; i++) {
                res = Math.min(res, min[i] - min[i-1]);
            }
            int total = 24*60;
            res = Math.min(res, total - (min[min.length-1]-min[0]));

            return res;
        }


        int getMin(String s) {
            String[] p = s.split(":");
            return Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
        }

    }

}
