package com.jtarun.practice.leetcode;

import java.util.*;

/** 399
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a
 * real number (floating point number). Given some queries, return the answers. If the answer does not exist,
 * return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>>
 *     queries , where equations.size() == values.size(), and the values are positive. This represents the
 *     equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero
 * and there is no contradiction.
 */
public class EvaluateDivision {

    private static class Solution {
        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            Map<String, Map<String, Double>> eq = new HashMap<>();
            for (int i = 0; i < equations.length; i++) {
                eq.computeIfAbsent(equations[i][0], k -> new HashMap<>()).put(equations[i][1], values[i]);
                eq.computeIfAbsent(equations[i][1], k -> new HashMap<>()).put(equations[i][0], 1/values[i]);
            }

            double[] res = new double[queries.length];
            int i = -1;
            for (String[] query :queries) {
                i++;
                String num = query[0];
                String den = query[1];
                if (!eq.containsKey(num)) {
                    res[i] = -1;
                } else if (num.equals(den)) {
                    res[i] = 1.0;
                } else if (eq.containsKey(num) && eq.get(num).get(den) != null) {
                    res[i] = eq.get(num).get(den);
                } else {
                    double[] val = new double[]{-1};
                    Set<String> used = new HashSet<>();
                    helper(eq, num, den, 1, val, used);
                    res[i] = val[0];
                }
            }

            return res;
        }

        private void helper(Map<String, Map<String, Double>> eq, String num, String den, double cur, double[] res, Set<String> used) {
            if (!eq.containsKey(num)) return;
            if (res[0] != -1) return;

            if (num.equals(den)) {
                res[0] = cur;
                return;
            }

            used.add(num);

            for (Map.Entry<String, Double> entry : eq.get(num).entrySet()) {
                if (!used.contains(entry.getKey())) {
                    helper(eq, entry.getKey(), den, cur*entry.getValue(), res, used);
                }
            }

        }
    }

}
