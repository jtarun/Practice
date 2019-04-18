package com.jtarun.practice.leetcode;

import java.util.*;

/** 787
 * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to
 * find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 */
public class CheapestFlightWithKStops {

    private static class Solution {
        private class Node {
            int s;
            int cost;
            public Node(int s, int cost) {
                this.s = s;
                this.cost = cost;
            }
        }

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            if (src == dst) return 0;

            Map<Integer, List<Node>> h = new HashMap<>();

            for (int[] flight : flights) {
                h.computeIfAbsent(flight[0], k -> new ArrayList<>()).add(new Node(flight[1], flight[2]));
            }

            if (h.get(src) == null) return -1;

            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(src, 0));

            int[] cost = new int[n+1];
            for (int i = 0; i < n; i++) cost[i] = Integer.MAX_VALUE;
            cost[src] = 0;

            while (!q.isEmpty() && K-- >= 0) {
                int size = q.size();
                while (size-- > 0) {

                    Node t = q.poll();

                    if (h.get(t.s) == null) continue;

                    for (Node child : h.get(t.s)) {
                        if (cost[child.s] > t.cost + child.cost) {
                            cost[child.s] = t.cost + child.cost;
                            q.offer(new Node(child.s, cost[child.s]));
                        }
                    }
                }
            }

            return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
        }


        // TLE
        public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
            if (src == dst) return 0;

            Map<Integer, List<Node>> h = new HashMap<>();

            for (int[] flight : flights) {
                h.computeIfAbsent(flight[0], k -> new ArrayList<>()).add(new Node(flight[1], flight[2]));
            }

            for (int i = 0; i < n; i++) {
                if (h.get(i) == null) h.put(i, new ArrayList<>());
            }

            Queue<Node> q = new LinkedList<>();
            q.addAll(h.get(src));

            int res = Integer.MAX_VALUE;

            while (!q.isEmpty() && K-- >= 0) {
                int size = q.size();
                while (size-- > 0) {

                    Node t = q.poll();
                    if (t.s == dst) {
                        res = Math.min(res, t.cost);
                        continue;
                    }

                    for (Node child : h.get(t.s)) {
                        if (t.s != child.s) {
                            q.offer(new Node(child.s, t.cost + child.cost));
                        }
                    }
                }
            }

            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int res = sol.findCheapestPrice(3, flights, 0, 2, 0);
        System.out.println(res);
    }
}
