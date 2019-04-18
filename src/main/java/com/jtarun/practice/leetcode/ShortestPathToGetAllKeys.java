package com.jtarun.practice.leetcode;

import java.util.*;

/**
 * 864
 *
 * We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is the starting point,
 * ("a", "b", ...) are keys, and ("A", "B", ...) are locks. We start at the starting point, and one move consists
 * of walking one space in one of the 4 cardinal directions. We cannot walk outside the grid, or walk into a wall.
 * If we walk over a key, we pick it up.  We can't walk over a lock unless we have the corresponding key.
 *
 * For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter of the first K letters of the
 * English alphabet in the grid.  This means that there is exactly one key for each lock, and one lock for each key;
 * and also that the letters used to represent the keys and locks were chosen in the same order as the English
 * alphabet.
 *
 * Return the lowest number of moves to acquire all keys.  If it's impossible, return -1.
 */
public class ShortestPathToGetAllKeys {

    private static class Solution {

        private static class Node {
            int x;
            int y;
            int keys;

            Node(int x, int y) {
                this.x = x;
                this.y = y;
                keys = 0;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return x == node.x &&
                        y == node.y &&
                        keys == node.keys;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y, keys);
            }
        }

        public int shortestPathAllKeys(String[] grid) {
            int m = grid.length;
            if (m == 0) return 0;
            int n = grid[0].length();
            if (n == 0) return 0;

            Queue<Node> q = new LinkedList<>();
            int keys = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char c = grid[i].charAt(j);
                    if (c == '@') {
                        q.offer(new Node(i, j));
                    }

                    if (key(c)) keys++;
                }
            }
            int mask = (1 << keys) - 1;

            Set<Node> visited = new HashSet<>();
            int level = 0;
            int[] xdir = {1, 0, -1, 0};
            int[] ydir = {0, 1, 0, -1};
            while (!q.isEmpty()) {
                int size = q.size();
                level++;
                while (size-- > 0) {
                    Node t = q.poll();

                    for (int i = 0; i < xdir.length; i++) {
                        int newX = t.x + xdir[i];
                        int newY = t.y + ydir[i];

                        if (newX >= m || newX < 0 || newY >= n || newY < 0) continue;
                        char c = grid[newX].charAt(newY);
                        if (c == '#') continue;
                        boolean isLock = lock(c);
                        boolean isKey = key(c);

                        if (isLock && ((t.keys & (1 << (c - 'A'))) == 0)) continue;

                        Node child = new Node(newX, newY);
                        child.keys = t.keys;
                        if (isKey && ((t.keys & keyMask(c)) == 0)) {
                            child.keys |= keyMask(c);

                            if (child.keys == mask) return level;
                        }
                        if (visited.add(child)) {
                            q.offer(child);
                        }

                    }

                }

            }

            return -1;
        }


        private boolean key(char c) {
            return c >= 'a' && c <= 'f';
        }

        private boolean lock(char c) {
            return c >= 'A' && c <= 'F';
        }

        private int keyMask(char c) {
            return 1 << (c - 'a');
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] grid = {"@.a.#", "###.#", "b.A.B"};
        int res = sol.shortestPathAllKeys(grid);
        System.out.println(res);
    }

}
