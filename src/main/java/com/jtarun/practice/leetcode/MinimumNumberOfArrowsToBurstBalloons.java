package com.jtarun.practice.leetcode;

import java.util.*;

/** 452
 * There are a number of spherical balloons spread in two-dimensional space. For each balloon,
 * provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal,
 * y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice.
 * Start is always smaller than end. There will be at most 104 balloons.
 *
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend
 * bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot.
 * An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must
 * be shot to burst all balloons.
 *
 * Example:
 *
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * Output:
 * 2
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    private static class Solution {
        public int findMinArrowShots(int[][] points) {
            int n = points.length;
            if (n == 0) return 0;

            Arrays.sort(points, Comparator.comparingInt(x -> x[1]));
            int end = points[0][1];
            int res = 1;
            for (int i = 0; i < n; i++) {
                if (points[i][0] > end) {
                    res++;
                    end = points[i][1];
                }
            }

            return res;
        }


        public int findMinArrowShots2(int[][] points) {
            int n = points.length;
            if (n <= 1) return n;

            int OPEN = 0, CLOSE = 1;
            List<int[]> l = new ArrayList<>();
            for (int i = 0; i < points.length; i++) {
                int[] p = points[i];
                l.add(new int[]{p[0], OPEN, i});
                l.add(new int[]{p[1], CLOSE, i});
            }

            Comparator<int[]> cmp = (a, b) -> {
                int c = Integer.compare(a[0], b[0]);
                if (c == 0) c = (a[1] == OPEN ? -1 : 1);
                return c;
            };
            Collections.sort(l, cmp);

            Set<Integer> processed = new HashSet<>();
            List<Integer> st = new ArrayList<>();
            int res = 0;
            for (int i = 0; i < l.size(); i++) {
                int[] e = l.get(i);
                int v = e[0], state = e[1], ind = e[2];
                if (state == OPEN) {
                    st.add(ind);
                } else if (state == CLOSE && !processed.contains(ind)) {

                    processed.addAll(st);
                    st.clear();

                    res++;

                }

            }

            return res;
        }



    }

}
