package com.jtarun.practice.leetcode;

/** 812
 * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of
 * the points.
 *
 * Example:
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2
 * Explanation:
 * The five points are show in the figure below. The red triangle is the largest.
 */
public class LargestTriangleArea {

    private static class Solution {
        public double largestTriangleArea(int[][] points) {
            double res = 0.0;
            for (int i = 0; i < points.length-2; i++) {
                for (int j = i+1; j < points.length-1; j++) {
                    for (int k = j+1; k < points.length; k++) {
                        res = Math.max(res, area(points[i], points[j], points[k]));
                        //System.out.println(res + " -> " + i + " " + j + " " + k);
                    }
                }
            }

            return res;
        }

        private double area(int[] pointx, int[] pointy, int[] pointz) {

            double a = dist(pointx, pointy);
            double b = dist(pointy, pointz);
            double c = dist(pointx, pointz);

            double sum = a+b+c;
            double max = Math.max(a, Math.max(b,c));
            if (sum - max <= max) return 0.0;

            double s = sum/2;

            return Math.sqrt(s*(s-a)*(s-b)*(s-c));
        }

        private double dist(int[] pointx, int[] pointy) {
            double xdiff = pointx[0] - pointy[0];
            double ydiff = pointx[1] - pointy[1];

            return Math.sqrt(xdiff*xdiff + ydiff*ydiff);
        }

    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] points = {{-35,19},{40,19},{27,-20},{35,-3},{44,20},{22,-21},{35,33},{-19,42},{11,47},{11,37}};
        System.out.println(sol.largestTriangleArea(points));
    }

}
