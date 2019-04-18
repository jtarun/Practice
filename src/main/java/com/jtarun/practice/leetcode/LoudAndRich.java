package com.jtarun.practice.leetcode;

import java.util.*;


/** 851
 * In a group of N people (labelled 0, 1, 2, ..., N-1), each person has different amounts of money,
 * and different levels of quietness.
 *
 * For convenience, we'll call the person with label x, simply "person x".
 *
 * We'll say that richer[i] = [x, y] if person x definitely has more money than person y.  Note that richer may only
 * be a subset of valid observations.
 *
 * Also, we'll say quiet[x] = q if person x has quietness q.
 *
 * Now, return answer, where answer[x] = y if y is the least quiet person (that is, the person y with the smallest
 * value of quiet[y]), among all people who definitely have equal to or more money than person x.
 */
public class LoudAndRich {

    private static class Solution {

        public int[] loudAndRich(int[][] richer, int[] quiet) {
            Map<Integer, List<Integer>> h = new HashMap<>();
            for (int[] r : richer) {
                h.computeIfAbsent(r[1], k -> new ArrayList<>()).add(r[0]);
            }

            int n = quiet.length;
            int[] res = new int[n];
            Arrays.fill(res, n);

            for (int i = 0; i < n; i++) {
                if (res[i] == n)
                    helper(h, quiet, res, i);
            }

            Map<Integer, Integer> qMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                qMap.put(quiet[i], i);
            }

            for (int i = 0; i < n; i++) {
                res[i] = qMap.get(res[i]);
            }

            return res;
        }

        private int helper(Map<Integer, List<Integer>> h, int[] quiet, int[] res, int i) {
            int n = res.length;

            if (res[i] != n) return res[i];

            if (h.get(i) == null) {
                res[i] = quiet[i];
                return quiet[i];
            }

            res[i] = quiet[i];
            for (int child : h.get(i)) {
                res[i] = Math.min(res[i], helper(h, quiet, res, child));
            }

            return res[i];
        }

        public int[] loudAndRich2(int[][] richer, int[] quiet) {
            Map<Integer, List<Integer>> h = new HashMap<>();
            Map<Integer, List<Integer>> parents = new HashMap<>();

            int n = quiet.length;

            int[] res = new int[n];
            int[] out = new int[n];
            for (int[] r : richer) {
                h.computeIfAbsent(r[1], k -> new ArrayList<>()).add(r[0]);
                parents.computeIfAbsent(r[0], k -> new ArrayList<>()).add(r[1]);
            }

            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (h.get(i) == null) {
                    out[i] = 0;
                    q.offer(new int[]{i, quiet[i]});
                } else {
                    out[i] = h.get(i).size();
                }
            }

            for (int i = 0; i < n; i++) {
                res[i] = quiet[i];
            }

            while (!q.isEmpty()) {

                int[] t = q.poll();
                int node = t[0], qt = t[1];
                res[node] = Math.min(res[node], qt);

                if (parents.get(node) == null) continue;

                for (int parent : parents.get(node)) {

                    res[parent] = Math.min(res[parent], qt);

                    out[parent]--;
                    if (out[parent] == 0) {
                        q.offer(new int[]{parent, res[parent]});
                    }
                }
            }



            Map<Integer, Integer> qMap = new HashMap<>();
            for (int i = 0; i <n; i++) {
                qMap.put(quiet[i], i);
            }

            for (int i = 0; i < n; i++) {
                res[i] = qMap.get(res[i]);
            }

            return res;
        }
    }

}
