package com.jtarun.practice.leetcode;

import java.util.*;

/** 435
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of
 * the intervals non-overlapping.
 *
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 * Example 1:
 * Input: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * Output: 1
 *
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 */
public class NonOverlappingIntervals {

    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    private static class Solution {
        public int eraseOverlapIntervals(Interval[] intervals) {
            int n = intervals.length;
            if (n == 0) return 0;

            Arrays.sort(intervals, (a, b) -> a.end - b.end);

            int i = 0, res = 0;
            while (i < n) {
                int end = intervals[i].end;
                int j = i + 1;
                while (j < n && intervals[j].start < end) j++;

                res += j - i - 1;

                i = j;
            }

            return res;
        }
    }

}
