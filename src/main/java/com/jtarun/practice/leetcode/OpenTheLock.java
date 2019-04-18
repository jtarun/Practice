package com.jtarun.practice.leetcode;

import java.util.*;

/** 752
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots:
 * '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can
 * turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 *
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 *
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the
 * lock will stop turning and you will be unable to open it.
 *
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of
 * turns required to open the lock, or -1 if it is impossible.
 */
public class OpenTheLock {

    private static class Solution {
        public int openLock(String[] deadends, String target) {
            if (target.equals("0000")) return 0;

            Set<String> blocks = new HashSet<>();
            for (String deadend : deadends) {
                blocks.add(deadend);
            }

            if (blocks.contains("0000")) return -1;

            Queue<String> q = new LinkedList<>();
            q.offer("0000");
            Set<String> visited = new HashSet<>();

            int level = 0;
            while (!q.isEmpty()) {
                level++;
                int size = q.size();
                while (size-- > 0) {
                    String t = q.poll();

                    for (String child : children(t)) {
                        if (child.equals(target)) return level;

                        if (!blocks.contains(child) && visited.add(child)) {
                            q.offer(child);
                        }
                    }

                }

            }

            return -1;
        }


        private List<String> children(String s) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                res.addAll(children(s, i));
            }
            return res;
        }

        private List<String> children(String s, int i) {
            List<String> res = new ArrayList<>();
            int v = s.charAt(i) - '0';

            int j1, j2;
            if (v == 0) {
                j1 = 9;
                j2 = 1;
            } else if (v == 9) {
                j1 = 8;
                j2 = 0;
            } else {
                j1 = v-1;
                j2 = v+1;
            }

            char[] arr = s.toCharArray();
            arr[i] = (char)(j1 + '0');
            res.add(new String(arr));
            arr[i] = (char)(j2 + '0');
            res.add(new String(arr));

            return res;
        }
    }



}
