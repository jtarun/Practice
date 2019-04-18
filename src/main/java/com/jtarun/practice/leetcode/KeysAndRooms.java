package com.jtarun.practice.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 841
 *
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room
 * may have some keys to access the next room.
 *
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where
 * N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 *
 * Initially, all the rooms start locked (except for room 0).
 *
 * You can walk back and forth between rooms freely.
 *
 * Return true if and only if you can enter every room.
 */
public class KeysAndRooms {

    private static class Solution {

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int[] cnt = new int[1];
            boolean[] v = new boolean[rooms.size()];
            helper(rooms, 0, cnt, v);
            return cnt[0] == rooms.size();
        }

        private void helper(List<List<Integer>> rooms, int i, int[] cnt, boolean[] v) {
            int n = rooms.size();
            if (i >= n || v[i]) return;
            v[i] = true;
            cnt[0]++;
            for (int child : rooms.get(i)) {
                if (!v[child]) {
                    helper(rooms, child, cnt, v);
                }
            }
        }

        public boolean canVisitAllRooms2(List<List<Integer>> rooms) {

            int n = rooms.size();
            if (n == 0) return true;

            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            boolean[] v = new boolean[n];
            v[0] = true;
            int cnt = 1;

            while (!q.isEmpty()) {

                int t = q.poll();

                for (int child : rooms.get(t)) {
                    if (!v[child]) {
                        v[child] = true;
                        q.offer(child);
                        cnt++;
                    }
                }
            }

            return cnt == n;
        }
    }

}
