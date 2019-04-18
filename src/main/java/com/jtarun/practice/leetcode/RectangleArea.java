package com.jtarun.practice.leetcode;

/** 223
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 */
public class RectangleArea {

    private static class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int area1 = (C-A) * (D-B);
            int area2 = (G-E) * (H-F);

            int common = overlap(A, C, E, G) * overlap(B, D, F, H);

            return area1 + area2 - common;
        }

        int overlap(int a, int b, int c, int d) {
            if (c >= b || d <= a) return 0;

            return Math.min(b,d) - Math.max(a,c);
        }

    }

}
