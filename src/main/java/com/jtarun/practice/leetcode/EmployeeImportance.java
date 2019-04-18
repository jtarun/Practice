package com.jtarun.practice.leetcode;

import java.util.*;

/**690
 *
 * You are given a data structure of employee information, which includes the employee's unique id, his importance value
 * and his direct subordinates' id.
 *
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3.
 * They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]],
 * and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate
 * of employee 1, the relationship is not direct.
 *
 * Now given the employee information of a company, and an employee id, you need to return the total importance value
 * of this employee and all his subordinates.
 */
public class EmployeeImportance {

    private static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    private static class Solution {
        public int getImportance(List<Employee> employees, int id) {
            Map<Integer, Integer> importance = new HashMap<>();
            Map<Integer, List<Integer>> subordinates = new HashMap<>();

            for (Employee e : employees) {

                importance.put(e.id, e.importance);
                subordinates.put(e.id, e.subordinates);

            }

            Queue<Integer> q = new LinkedList<>();
            q.offer(id);
            int res = 0;
            while (!q.isEmpty()) {
                Integer t = q.poll();
                res += importance.get(t);

                List<Integer> subs = subordinates.get(t);
                if (subs == null) {
                    continue;
                }

                for (Integer sid : subs) {
                    q.offer(sid);
                }
            }

            return res;
        }
    }

}
