package com.jtarun.practice.leetcode;

import java.util.*;

/** 733
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the
 * image (from 0 to 65535).
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value
 * newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting
 * pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels
 * with the newColor.
 *
 * At the end, return the modified image.
 */
public class FloodFill {

    private static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int m = image.length;
            if (m == 0) return image;
            int n = image[0].length;
            if (n == 0) return image;

            int color = image[sr][sc];
            if (color == newColor) return image;

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{sr, sc});
            image[sr][sc] = newColor;

            int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0,-1}};


            while (!q.isEmpty()) {

                int[] t = q.poll();
                int x1 = t[0], y1 = t[1];

                for (int[] d : dirs) {
                    int x2 = x1 + d[0];
                    int y2 = y1 + d[1];
                    if (x2 < 0 || y2 < 0 || x2 >= m || y2 >= n || image[x2][y2] != color) continue;

                    image[x2][y2] = newColor;
                    q.offer(new int[]{x2, y2});
                }

            }

            return image;

        }
    }

}
