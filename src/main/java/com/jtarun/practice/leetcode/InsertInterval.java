package com.jtarun.practice.leetcode;

import java.util.*;

/** 57
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

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
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> res = new ArrayList<>();

            boolean merged = false;
            for (int i = 0; i < intervals.size();) {

                int s = intervals.get(i).start;
                int e = intervals.get(i).end;

                if (!merged && newInterval.end < s) {
                    res.add(newInterval);
                    merged = true;
                }

                if (!merged && overlap(s,e, newInterval.start, newInterval.end)) {
                    //update s and e
                    s = Math.min(s, newInterval.start);
                    e = Math.max(e, newInterval.end);
                    merged = true;
                }

                int j = i+1;
                while (j < intervals.size() && overlap(s, e, intervals.get(j).start, intervals.get(j).end)) {
                    e = Math.max(intervals.get(j).end, e);
                    j++;
                }

                i = j;
                res.add(new Interval(s, e));
            }

            if (!merged) {
                res.add(newInterval);
            }

            return res;
        }

        private boolean overlap(int s1, int e1, int s2, int e2) {
            if (s2 > e1 || e2 < s1) return false;
            return true;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        List<Interval> input = new ArrayList<>();
        for (int[] inv : intervals) {
            input.add(new Interval(inv[0], inv[1]));
        }
        sol.insert(input, new Interval(4,8)).forEach(inv -> {
            System.out.print("(" + inv.start + ", " + inv.end + "), ");
        });
    }

}
