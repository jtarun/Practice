package com.jtarun.practice.leetcode;

import java.util.*;

/** 815
 * We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.
 *
 * We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by buses only, what is the least number of buses we must take to reach our destination? Return -1 if it is not possible.
 */
public class BusRoutes {

    private static class Solution {
        private static class Node {
            int bus;
            int stop;
            int busCount;
            Node(int bus, int stop) {
                this.bus = bus;
                this.stop = stop;
                this.busCount = Integer.MAX_VALUE;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return bus == node.bus &&
                        stop == node.stop &&
                        busCount == node.busCount;
            }

            @Override
            public int hashCode() {
                return Objects.hash(bus, stop, busCount);
            }
        }

        public int numBusesToDestination(int[][] routes, int S, int T) {
            if (S == T) return 0;

            Map<Integer, List<Node>> h = new HashMap<>();

            for (int i = 0; i < routes.length; i++) {

                int[] route = routes[i];
                for (int j = 0; j < route.length; j++) {
                    h.computeIfAbsent(route[j], k -> new ArrayList<>()).add(new Node(i, route[(j+1) % route.length]));
                }

            }

            Queue<Node> q = new LinkedList<>();
            if (h.get(S) == null) return -1;

            for (Node node : h.get(S)) {
                node.busCount = 1;
                q.offer(node);
            }

            int res = Integer.MAX_VALUE;
            while (!q.isEmpty()) {

                Node t = q.poll();

                if (t.stop == T) {
                    res = Math.min(res, t.busCount);
                    continue;
                }

                for (Node child : h.get(t.stop)) {
                     int busCount = t.busCount;
                     if (child.bus != t.bus) {
                         busCount++;
                     }
                     if (child.busCount > busCount) {
                         child.busCount = busCount;
                         q.offer(child);
                     }
                }

            }

            return res == Integer.MAX_VALUE ? -1 : res;
        }


        public int numBusesToDestination2(int[][] routes, int S, int T) {
            int n = routes.length;
            Map<Integer, List<Node>> h = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int[] route = routes[i];

                for (int j = 1; j < route.length; j++) {
                    int source = route[j-1];
                    int dest = route[j];
                    h.computeIfAbsent(source, k -> new ArrayList<>()).add(new Node(i, dest));
                    h.computeIfAbsent(dest, k -> new ArrayList<>()).add(new Node(i, source));
                }
            }

            Set<Node> visited = new HashSet<>();
            Map<Node, Integer> dp = new HashMap<>();
            int res = Integer.MAX_VALUE;
            for (Node node : h.get(S)) {
                visited.add(node);
                int d = dfs(h, node, T, visited, dp) ;
                res = Math.min(res, d == Integer.MAX_VALUE ? d : d + 1);
            }

            return res == Integer.MAX_VALUE ? -1 : res;
        }

        private int dfs(Map<Integer, List<Node>> h, Node node, int dest, Set<Node> visited, Map<Node, Integer> dp) {
            if (node.stop == dest) {
                return 0;
            }

            if (dp.containsKey(node)) return dp.get(node);

            int res = Integer.MAX_VALUE;
            if (h.get(node.stop) != null) {
                for (Node child : h.get(node.stop)) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        int buses = dfs(h, child, dest, visited, dp);
                        if (child.bus != node.bus) buses++;
                        res = Math.min(res, buses);
                    }
                }
            }

            dp.put(node, res);

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] routes = {{148,167,216},{6,23,25,40,43,58,63,69,77,86,94,96,106,117,119,127,139,151,153,155,157,186,191,196,200,204,210,216,219},{2,6,7,16,27,30,42,47,49,68,69,77,93,94,96,102,104,111,114,126,131,137,150,161,167,171,174,193,198,199,200,223},{46,131,211},{25,36,51,52,65,78,90,102,103,105,108,114,123,151,152,153,162,174,175},{217},{9,10,15,27,37,38,41,43,46,51,67,74,81,82,83,94,95,107,113,120,122,123,124,132,149,160,162,169,170,171,174,177,185,192,193,195,196,198,213,217,220,221},{74,78,85,95,130,136,145,152,173,175,180,181,184,193,199,202},{13,18,28,38,41,42,47,75,87,91,106,151,158,166,181,182,199,216},{44,63,71,74,144,162,169,220},{2,23,115,185,208},{0,8,13,14,35,46,67,89,91,122,124,126,130,156,177,193,212,214},{2,4,24,37,40,43,55,68,81,92,106,107,109,127,132,138,145,159,163,165,170,172,183,184,209,213,215,220},{5,16,17,34,38,48,55,59,60,65,69,84,86,94,100,103,109,110,112,127,130,131,134,145,148,149,154,161,166,169,182,183,201,203,208,214,223},{0,2,5,6,8,19,49,50,53,79,92,94,97,109,110,112,121,129,132,135,138,139,144,160,166,170,194,197,198,201,212},{27,52,61,112,118,133,142,159,175,186,216},{2,20,34,64,65,77,87,91,95,96,97,125,126,131,144,146,149,152,154,164,165,170,179,205,207},{24,85,123,132,172,173,194,222},{2,4,5,15,23,36,44,47,63,64,78,80,84,97,99,102,104,114,120,130,132,143,161,162,163,167,171,172,176,179,180,194,196,199,202,204,209,214,216,221},{8,22,26,31,38,39,41,59,78,90,102,108,110,138,141,146,176,185,190,198,200,219,220},{5,24,30,46,55,64,67,74,78,136,194,216},{133,142,202},{13,40,49,57,63,75,76,85,91,107,116,121,128,135,137,141,154,193,198,200,204,223},{4,13,14,26,28,33,39,49,58,65,67,74,77,81,90,96,122,124,144,156,158,166,169,170,179,203,204,208,215,223},{6,20,28,36,46,90,107,115,124,131,135,144,147,148,149,161,162,174,176,214,221},{10,20,21,29,35,36,62,65,67,70,72,87,89,92,100,103,107,109,113,126,129,139,140,145,146,147,174,176,180,184,189,190,193,196,198,199,200,209,217},{19,22,27,54,59,63,77,102,122,126,140,143,154,164,165,175,212,216,217,218},{11,13,16,18,27,31,46,49,69,77,88,109,111,119,121,146,161,169,193,194,198,200,204},{1,7,28,58,73,91,98,138,150,173,182,186,213},{3,25,28,33,46,68,70,74,78,97,141,146,149,169,172,178,185,188,202,212,223},{3,4,19,22,24,37,38,43,54,55,56,57,58,62,66,72,75,77,88,106,114,119,127,132,133,137,144,146,150,156,161,164,165,179,181,195,200,213,214,215,222},{9,11,14,15,38,46,55,61,66,68,69,75,76,79,82,91,100,101,102,113,135,141,142,171,175,180,198,208,210,215,218,221},{2,30,33,62,93,104,124,127,128,147,158,160,161,173,181,189,192,199,201,215,223},{4,26,29,38,47,58,61,69,78,93,94,112,114,131,136,144,182,193,198,203,206,209},{5,13,14,16,17,22,30,32,45,47,49,55,63,64,68,77,82,84,86,92,98,100,104,107,117,119,122,127,134,153,164,179,185,197,201,209,212,213,220,223},{2,4,5,6,42,55,75,81,84,93,102,111,112,113,118,129,142,149,159,169,191,193,200,214,223},{10,12,15,19,20,24,33,34,40,47,54,64,93,104,115,121,123,124,155,172,189,190,193,196,202,212,219,222},{104,108,143},{14,15,20,21,31,47,48,59,67,70,74,82,94,102,109,121,125,128,148,162,165,171,180,196,199,202,205,212,214},{2,6,17,18,41,50,60,70,118,151,155,158,166,167,172,180,182,186,188,195},{1,23,25,30,39,41,42,48,58,65,67,94,100,121,126,135,145,152,163,164,171,174,206,210,220,224},{18,25,96,123,172},{5,7,9,12,13,19,22,25,34,51,62,64,74,79,81,85,88,101,102,119,123,140,143,149,155,165,166,167,178,182,189,204,213,222,223},{1,5,18,21,23,50,54,59,62,67,68,72,87,94,95,96,110,116,118,122,133,135,151,155,156,158,171,178,183,184,192,198,208,212,222,224},{18,20,24,34,47,52,56,68,77,82,89,91,97,101,105,106,107,109,118,123,139,141,143,152,153,162,174,180,184,187,188,192,198,202,206,216,224}};
        int[][] routes2 = new int[][] {{1,2,7},{3,6,7}};
        int res  = sol.numBusesToDestination(routes2, 1, 6);
        //int res  = sol.numBusesToDestination(routes, 180, 143);
        System.out.println(res);
    }

}
