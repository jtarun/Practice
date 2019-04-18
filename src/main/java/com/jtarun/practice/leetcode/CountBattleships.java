package com.jtarun.practice.leetcode;

import java.util.*;

/** 419
 * Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty
 * slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape
 * 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 * Follow up:
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 */
public class CountBattleships {

    private static class Solution {
        public int countBattleships(char[][] board) {
            int m = board.length;
            if (m == 0) return 0;
            int n = board[0].length;
            if (n == 0) return 0;

            int res = 0;
            for (int i = 0 ; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if ((board[i][j] != 'X') ||
                            (i-1 >= 0 && board[i-1][j] == 'X') ||
                            (j-1 >= 0 && board[i][j-1] == 'X')) {
                        continue;
                    }

                    res++;
                }
            }

            return res;
        }

        // Union Find
        public int countBattleships2(char[][] board) {
            int m = board.length;
            if (m == 0) return 0;
            int n = board[0].length;
            if (n == 0) return 0;

            UnionFind uf = new UnionFind(m*n);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 'X') {
                        uf.count--;
                        continue;
                    }

                    int ind = i * n + j;

                    if (j < n-1 && board[i][j+1] == 'X') {
                        uf.union(ind, ind + 1);
                    } else if (i < m-1 && board[i+1][j] == 'X') {
                        uf.union(ind, ind+n);
                    }
                }
            }

            return uf.count;
        }

        private static class UnionFind {
            int[] parents;
            int count;
            UnionFind(int n) {
                parents = new int[n];
                for (int i = 0; i < n; i++) parents[i] = i;
                count = n;
            }

            void union(int i, int j) {
                int x = find(i);
                int y = find(j);
                if (x != y) {
                    count--;
                    parents[x] = y;
                }
            }

            int find(int i) {
                List<Integer> path = new ArrayList<>();
                while (i != parents[i]) {
                    path.add(i);
                    i = parents[i];
                }

                for (int x : path) parents[x] = i;
                return i;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.println(sol.countBattleships(board));

    }

}
