package com.jtarun.practice.leetcode;

import java.util.*;

/** 886
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 *
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same
 * group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 */
public class PossibleBipartition {

    private static class Solution {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            if (dislikes.length == 0) return true;
            Map<Integer, List<Integer>> h = new HashMap<>();
            for (int i = 1; i <= N; i++) h.put(i, new ArrayList<>());
            for (int[] dislike : dislikes) {
                h.get(dislike[0]).add(dislike[1]);
                h.get(dislike[1]).add(dislike[0]);
            }

            int[] color = new int[N+1];

            for (int i = 1; i <= N; i++ ) {
                if (color[i] > 0) continue;

                int desiredColor = 2;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 1;

                while (!q.isEmpty()) {
                    int size = q.size();

                    while (size-- > 0) {
                        int s = q.poll();

                        for (int d : h.get(s)) {
                            if (color[d] > 0 && color[d] != desiredColor) return false;
                            if (color[d] == 0) {
                                color[d] = desiredColor;
                                q.offer(d);
                            }
                        }

                    }

                    desiredColor = 3 - desiredColor;
                }

            }


            return true;

        }
    }

}
