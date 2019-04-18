package com.jtarun.practice.leetcode;

import java.util.*;

/** 797 (Medium)
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return
 * them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all
 * nodes j for which the edge (i, j) exists.
 *
 * Example:
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */
public class AllPathsFromSourceToTarget {

    private static class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            int n = graph.length;
            List<List<Integer>> res = new ArrayList<>();
            dfs(graph, 0, n-1, new ArrayList<>(), res);
            return res;
        }

        private void dfs(int[][] graph, int node, int target, List<Integer> temp, List<List<Integer>> res) {
            temp.add(node);
            if (node == target) {
                res.add(new ArrayList<>(temp));
            } else if (graph[node] != null) {
                for (int child : graph[node]) {
                    dfs(graph, child, target, temp, res);
                }
            }
            temp.remove(temp.size()-1);
        }
    }

}
