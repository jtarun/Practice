package com.jtarun.practice.leetcode;

import java.util.*;

/** 847
 * An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.
 *
 * graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.
 *
 * Return the length of the shortest path that visits every node. You may start and stop at any node, you may
 * revisit nodes multiple times, and you may reuse edges.
 */
public class ShortestPathVisitingAllNodes {

    private static class Solution {
        private static class Node {
            int cur;
            int visited;
            int level;
            Node(int cur, int visited, int level) {
                this.cur = cur;
                this.visited = visited;
                this.level = level;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return cur == node.cur &&
                        visited == node.visited;
            }

            @Override
            public int hashCode() {
                return Objects.hash(cur, visited);
            }
        }

        public int shortestPathLength(int[][] graph) {
            int n = graph.length;
            if ( n <= 3) return n-1;

            Queue<Node> q = new LinkedList<>();
            Set<Node> s = new HashSet<>();
            for (int i = 0; i < n; i++) {
                Node node = new Node(i, 1<<i, 0);
                q.add(node);
                s.add(node);
            }

            int level = 0;
            boolean success = false;
            while (!q.isEmpty()) {
                level++;
                int size = q.size();
                while (size-- > 0) {
                    Node t = q.poll();
                    for (int child : graph[t.cur]) {
                        int newVisited = t.visited | (1 << child);
                        if (newVisited == ((1<<n) -1)) {
                            success = true;
                            break;
                        }
                        Node childNode = new Node(child, newVisited, level);
                        if (!s.contains(childNode)) {
                            s.add(childNode);
                            q.offer(childNode);
                        }
                    }
                    if (success) break;
                }
                if (success) break;
            }

            return level;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[][] g = {{1},{0,2,4},{1,3,4},{2},{1,2}};
        //int[][] g = {{1,2,3},{0},{0},{0}};
        int[][] g = {{1,5},{0,3},{3,5},{1,2,5},{7},{0,7,6,2,3},{5},{5,4,8},{7}};
        int res = sol.shortestPathLength(g);
        System.out.println();
        System.out.println(res);
    }

}
