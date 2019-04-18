package com.jtarun.practice.leetcode;

import java.util.*;

public class DungeonGame {

    private static class Solution {
        int calculateMinimumHP(int[][] dungeon) {

            int m = dungeon.length;
            if (m == 0) return 0;
            int n = dungeon[0].length;
            if (n == 0) return 0;

            int[] cost = new int[m * n];
            Arrays.fill(cost, Integer.MIN_VALUE);
            cost[0] = dungeon[0][0];
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{0, 0, cost[0], cost[0]});

            int[][] dirs = {{0, 1}, {1, 0}};
            while (!q.isEmpty()) {
                int[] t = q.poll();
                int i = t[0], j = t[1], health = t[2], minHealth = t[3];

                for (int[] d : dirs) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x < 0 || y < 0 || x >= m || y >= n) continue;

                    int newHealth = health + dungeon[x][y];
                    int newMinHealth = Math.min(minHealth, newHealth);

                    if (newMinHealth > cost[x * n + y]) {
                        cost[x * n + y] = newMinHealth;
                        q.offer(new int[]{x, y, newHealth, newMinHealth});
                    }

                }

            }

            int maxMinimumHealth = cost[m * n - 1];
            return maxMinimumHealth >= 0 ? 1 : -maxMinimumHealth + 1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[][] d = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[][] d = {{0,-5},{0,0}};
        int res = sol.calculateMinimumHP(d);
        System.out.println(res);
    }

}
