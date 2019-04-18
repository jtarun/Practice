package com.jtarun.practice.leetcode;

import java.util.*;

/** 84
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
public class LargestRectangeInHistogram {

    private static class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> s = new Stack<>();

            int area = 0, i = 0;
            for (i = 0; i < heights.length; i++) {

                if (s.isEmpty() || heights[s.peek()] <= heights[i]) s.push(i);
                else {

                    int top = s.pop();
                    int width = s.isEmpty() ? i : i - s.peek() - 1;
                    area = Math.max(area, width * heights[top]);
                    i--;
                }

            }

            while (!s.isEmpty()) {
                int top = s.pop();
                int width = s.isEmpty() ? i  : i - s.peek() - 1;
                area = Math.max(area, width * heights[top]);
            }

            return area;
        }
    }

}
