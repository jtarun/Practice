package com.jtarun.practice.leetcode;

import java.util.*;

/** 743
 * There are N network nodes, labelled 1 to N.
 *
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
 * v is the target node, and w is the time it takes for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal?
 * If it is impossible, return -1.
 *
 * Note:
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
 */
public class NetworkDelayTime {

    private static class Solution {

        public int networkDelayTime(int[][] times, int n, int k) {

            Map<Integer, List<int[]>> h = new HashMap<>();
            for (int[] time : times) {
                h.computeIfAbsent(time[0], p -> new ArrayList<>()).add(new int[]{time[1], time[2]});
            }

            if (h.get(k) == null) return -1;

            int[] cost = new int[n+1];
            Arrays.fill(cost, Integer.MAX_VALUE);
            cost[k] = 0;

            Queue<int[]> q = new LinkedList<>();

            for (int[] child : h.get(k)) {
                cost[child[0]] = child[1];
                q.offer(child);
            }

            while (!q.isEmpty()) {
                int[] t = q.poll();

                int s = t[0], c = t[1];
                if (h.get(s) == null) continue;

                for (int[] child : h.get(s)) {
                    if (c + child[1] < cost[child[0]]) {
                        cost[child[0]] = c + child[1];
                        q.offer(new int[]{child[0], cost[child[0]]});
                    }
                }
            }

            int res = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                res = Math.max(res, cost[i]);
            }

            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }

}
