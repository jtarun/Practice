package com.jtarun.practice.leetcode;

import java.util.*;

public class ReachANumber {

    private static class Solution {

        public int reachNumber(int target) {
            if (target == 0) return 0;

            target = Math.abs(target);

            int n = (int)Math.ceil(-1 + Math.sqrt(1 + (8 * (long)target)) / 2);

            int sum = (n * (n+1)) / 2;

            int diff = sum - target;
            if (diff == 0 || (diff % 2 == 0)) return n;

            return ((n+1)% 2 != 0) ? n + 1 : n + 2;
        }

        // Memory Limit Exceeded.
        public int reachNumberBFS(int target) {
            if (target == 0) return 0;

            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            int level = 0;
            while (!q.isEmpty()) {
                level++;
                int size = q.size();
                while (size-- > 0) {
                    int t = q.poll();

                    if (t + level == target || t - level == target) return level;

                    q.offer(t + level);
                    q.offer(t - level);

                }

            }

            return -1;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reachNumber(-1000000000));
    }
}
