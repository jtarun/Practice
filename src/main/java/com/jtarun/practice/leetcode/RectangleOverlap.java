package com.jtarun.practice.leetcode;


/** 836
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left
 * corner, and (x2, y2) are the coordinates of its top-right corner.
 *
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only
 * touch at the corner or edges do not overlap.
 *
 * Given two (axis-aligned) rectangles, return whether they overlap.
 *
 * Example 1:
 *
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * Example 2:
 *
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 * Notes:
 *
 * Both rectangles rec1 and rec2 are lists of 4 integers.
 * All coordinates in rectangles will be between -10^9 and 10^9.
 */
public class RectangleOverlap {

    private static class Solution {
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            int x12 = rec2[0];
            int y12 = rec2[1];
            int x22 = rec2[2];
            int y22 = rec2[3];

            int x11 = rec1[0];
            int y11 = rec1[1];
            int x21 = rec1[2];
            int y21 = rec1[3];

            if (x21 <= x12 || x11 >= x22 || y11 >= y22 || y21 <= y12) return false;
            return true;
        }


    }

}
