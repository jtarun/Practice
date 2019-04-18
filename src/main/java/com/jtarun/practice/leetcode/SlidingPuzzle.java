package com.jtarun.practice.leetcode;

import java.util.*;

/** 773
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 *
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 *
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 *
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved.
 * If it is impossible for the state of the board to be solved, return -1.
 */
public class SlidingPuzzle {

    private static class Solution {
        public int slidingPuzzle(int[][] board) {
            String root = serialize(board);
            String dest = serialize(new int[][]{{1,2,3}, {4,5,0}});
            if (root.equals(dest)) return 0;

            Queue<String> q = new LinkedList<>();
            q.add(root);
            Set<String> visited = new HashSet<>();
            visited.add(root);
            int level = 0;
            while (!q.isEmpty()) {
                level++;
                int size = q.size();
                while (size-- > 0) {
                    String t = q.poll();

                    for (String child : getChildren(t)) {
                        if (child.equals(dest)) return level;

                        if (visited.add(child)) {
                            q.offer(child);
                        }
                    }
                }

            }

            return -1;
        }

        private String serialize(int[][] board) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i  < 2; i++) {
                for (int j = 0; j < 3; j++){
                    if (sb.length() != 0) sb.append(",");
                    sb.append(board[i][j]);
                }
            }
            return sb.toString();
        }

        private int[] xdir = {1, 0, -1, 0};
        private int[] ydir = {0, 1, 0, -1};
        private List<String> getChildren(String s) {
            String[] b = s.split(",");
            int[][] board = new int[2][3];

            int[] z = new int[2];
            for (int i = 0; i < b.length; i++) {
                int r = i / 3;
                int c = i % 3;
                board[r][c] = b[i].charAt(0) - '0';
                if (board[r][c] == 0) {
                    z[0] = r;
                    z[1] = c;
                }
            }

            List<String> res = new ArrayList<>();
            for (int i = 0; i < xdir.length; i++) {
                int x = z[0] + xdir[i];
                int y = z[1] + ydir[i];

                if (x < 0 || x >= 2 || y < 0 || y >= 3) continue;
                int v = board[x][y];

                board[z[0]][z[1]] = v;
                board[x][y] = 0;

                res.add(serialize(board));

                board[x][y] = v;
                board[z[0]][z[1]] = 0;

            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol= new Solution();
        int[][] board = {{1,2,3},{5,4,0}};
        int res = sol.slidingPuzzle(board);
        System.out.println(res);
    }

}
