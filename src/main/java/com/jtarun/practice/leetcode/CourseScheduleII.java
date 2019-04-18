package com.jtarun.practice.leetcode;

import java.util.*;

/** 210
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take
 * to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all
 * courses, return an empty array.
 */
public class CourseScheduleII {

    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Map<Integer, Set<Integer>> h = new HashMap<>();
            Map<Integer, Set<Integer>> dependents = new HashMap<>();
            int n = numCourses;
            for (int i = 0; i < n; i++) {
                h.put(i, new HashSet<>());
                dependents.put(i, new HashSet<>());
            }

            for (int[] pre : prerequisites) {
                h.get(pre[0]).add(pre[1]);
                dependents.get(pre[1]).add(pre[0]);
            }

            List<Integer> leaves = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (h.get(i).size() == 0) leaves.add(i);
            }

            int[] res = new int[n];
            int i = 0;
            while (n > 0 && leaves.size() > 0) {

                n -= leaves.size();

                List<Integer> newLeaves = new ArrayList<>();
                for (int leaf : leaves) {
                    res[i++] = leaf;
                    for (int dependent : dependents.get(leaf)) {
                        h.get(dependent).remove(leaf);
                        if (h.get(dependent).size() == 0) {
                            newLeaves.add(dependent);
                        }
                    }
                }

                leaves = newLeaves;

            }

            if (n != 0) return new int[]{};

            return res;
        }
    }

}
