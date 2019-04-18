package com.jtarun.practice.leetcode;

import java.util.*;

/** 119
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 */
public class PascalTriangleII {

    private static class Solution {
        public List<Integer> getRow(int rowIndex) {
            int[][] p = new int[rowIndex+1][2];

            p[0][1] = 1;

            for (int r = 2; r <= rowIndex+1; r++) {
                p[0][r%2] = 1;
                for (int j = 1; j < r-1; j++) {

                    p[j][r%2] = p[j][(r+1)%2] + p[j-1][(r+1)%2];

                }
                p[r-1][r%2] =1;

            }

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i <= rowIndex; i++) {
                res.add(p[i][(rowIndex+1)%2]);
            }

            return res;
        }
    }

}
