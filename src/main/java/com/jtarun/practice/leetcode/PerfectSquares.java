package com.jtarun.practice.leetcode;

import java.util.*;

/** 279
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 */
public class PerfectSquares {

    private static class Solution {

        public int numSquares(int n) {
            int[] dp = new int[n+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 1; i + j * j <= n; j++) {
                    dp[i+j*j] = Math.min(dp[i+j*j], dp[i] + 1);
                }
            }

            return dp[n];
        }

        public int numSquares2(int n) {
            Set<Integer> squares = getAllSquares(n);
            Queue<Integer> q = new LinkedList<>();
            q.addAll(squares);
            Set<Integer> visited = new HashSet<>();
            int cnt = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                cnt++;
                while (size-- > 0) {
                    Integer t = q.poll();
                    if (t == n) {
                        return cnt;
                    }
                    visited.add(t);

                    for (int x : squares) {
                        int val = t + x;
                        if ((val <= n) && !visited.contains(val)) {
                            q.offer(val);
                            visited.add(val);
                        }
                    }
                }
            }

            return 0;
        }

        private Set<Integer> getAllSquares(int n) {
            Set<Integer> res = new HashSet<>();
            for (int i = 1; i <= n/i; i++) {
                res.add(i*i);
            }
            return res;
        }
    }

}
