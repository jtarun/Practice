package com.jtarun.practice.leetcode;

import java.util.*;

/** 207
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
 * expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */
public class CourseSchedule {

    private static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, Set<Integer>> h = new HashMap<>();
            Map<Integer, Set<Integer>> dependents = new HashMap<>();
            int n = numCourses;
            for (int i = 0; i < n; i++) {
                h.put(i, new HashSet<>());
                dependents.put(i, new HashSet<>());
            }

            for (int[] dep : prerequisites) {
                h.get(dep[0]).add(dep[1]);
                dependents.get(dep[1]).add(dep[0]);
            }

            List<Integer> leaves = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (h.get(i).size() == 0) leaves.add(i);
            }

            while (n > 0 && leaves.size() > 0) {
                n -= leaves.size();

                List<Integer> newLeaves = new ArrayList<>();
                for (int leaf : leaves) {
                    for (int dependent : dependents.get(leaf)) {
                        h.get(dependent).remove(leaf);
                        if (h.get(dependent).size() == 0) newLeaves.add(dependent);
                    }
                }

                leaves = newLeaves;
            }

            return n == 0;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] pre = {{1,0}};
        System.out.println(sol.canFinish(2, pre));
    }

}
