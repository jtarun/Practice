package com.jtarun.practice.leetcode;

import java.util.*;

/** 739
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many
 * days you would have to wait until a warmer temperature. If there is no future day for which this is possible,
 * put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be
 * [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the
 * range [30, 100].
 */
public class DailyTemperatures {

    private static class Solution {
        public int[] dailyTemperatures(int[] T) {
            int[] res = new int[T.length];
            Stack<Integer> s = new Stack<>();

            for (int i = T.length-1; i >= 0; i--) {
                while (!s.isEmpty() && T[s.peek()] <= T[i]) {
                    s.pop();
                }

                res[i] = s.isEmpty() ? 0 : s.peek()-i;

                s.push(i);
            }


            return res;
        }
    }

}
