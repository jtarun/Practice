package com.jtarun.practice.leetcode;

import java.util.*;

/** 120
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent
 * numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows
 * in the triangle.
 */
public class Triangle {

    private static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int len = triangle.get(n-1).size();

            int[] dp = new int[len];
            for (int i = 0; i < len; i++) dp[i] = triangle.get(n-1).get(i);

            for (int i = n-2; i >= 0; i--) {

                for (int j = 0; j <= i; j++) {

                    dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);

                }


            }

            return dp[0];
        }
    }

}
