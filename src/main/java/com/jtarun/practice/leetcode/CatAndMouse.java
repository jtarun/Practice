package com.jtarun.practice.leetcode;

import java.util.*;


/** 913
 * A game on an undirected graph is played by two players, Mouse and Cat, who alternate turns.
 *
 * The graph is given as follows: graph[a] is a list of all nodes b such that ab is an edge of the graph.
 *
 * Mouse starts at node 1 and goes first, Cat starts at node 2 and goes second, and there is a Hole at node 0.
 *
 * During each player's turn, they must travel along one edge of the graph that meets where they are.
 * For example, if the Mouse is at node 1, it must travel to any node in graph[1].
 *
 * Additionally, it is not allowed for the Cat to travel to the Hole (node 0.)
 *
 * Then, the game can end in 3 ways:
 *
 * If ever the Cat occupies the same node as the Mouse, the Cat wins.
 * If ever the Mouse reaches the Hole, the Mouse wins.
 * If ever a position is repeated (ie. the players are in the same position as a previous turn, and it is the same
 * player's turn to move), the game is a draw.
 * Given a graph, and assuming both players play optimally, return 1 if the game is won by Mouse, 2 if the game
 * is won by Cat, and 0 if the game is a draw.
 */
public class CatAndMouse {

    private static class Solution {
        int MOUSE = 1, CAT = 2, DRAW = 0;

        public int catMouseGame(int[][] graph) {

            // (m, c, turn)
            int[][][] outdegree = new int[51][51][3];
            int[][][] color = new int[51][51][3];

            Queue<int[]> q = new LinkedList<>();

            for (int m = 0; m < graph.length; m++) {

                for (int c = 1; c < graph.length; c++) {

                    outdegree[m][c][MOUSE] = graph[m].length;
                    outdegree[m][c][CAT] = graph[c].length;

                    for (int x : graph[c]) {
                        if (x == 0) outdegree[m][c][CAT]--;
                        break;
                    }

                    if (m == 0) {
                        color[m][c][MOUSE] = MOUSE;
                        color[m][c][CAT] = MOUSE;
                        q.offer(new int[]{m, c, MOUSE});
                        q.offer(new int[]{m, c, CAT});
                    } else if (m == c) {
                        color[m][c][MOUSE] = CAT;
                        color[m][c][CAT] = CAT;
                        q.offer(new int[]{m, c, MOUSE});
                        q.offer(new int[]{m, c, CAT});
                    }

                }

            }

            while (!q.isEmpty()) {

                int[] t = q.poll();
                int m1 = t[0], c1 = t[1], t1 = t[2];

                for (int[] parent : parents(graph, m1, c1, t1)) {
                    int m2 = parent[0], c2 = parent[1], t2 = parent[2];

                    if (color[m2][c2][t2] == DRAW) {

                        if (color[m1][c1][t1] == t2) {
                            color[m2][c2][t2] = color[m1][c1][t1];
                            q.offer(new int[]{m2, c2, t2});
                        } else {

                            outdegree[m2][c2][t2]--;
                            if (outdegree[m2][c2][t2] == 0) {
                                color[m2][c2][t2] = 3 - t2;
                                q.offer(new int[]{m2, c2, t2});
                            }
                        }
                    }

                }
            }

            //print(color, graph.length);

            return color[1][2][MOUSE];
        }

        private List<int[]> parents(int[][] graph, int m, int c, int t) {
            List<int[]> res = new ArrayList<>();
            if (t == MOUSE) {
                for (int x : graph[c]) {
                    if (x != 0) res.add(new int[]{m, x, CAT});
                }
            } else if (t == CAT) {

                for (int x : graph[m]) {
                    res.add(new int[]{x, c, MOUSE});
                }
            }

            return res;
        }

        private void print(int[][][] color, int n) {
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    for (int k = 1; k <= 2; k++) {
                        System.out.println(i + " : " + j + " : " + k + " : " + color[i][j][k]);
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[][] graph = {{2, 3}, {3, 4}, {0, 4}, {0, 1}, {1, 2}};
        int[][] graph = {{2,3},{2},{0,1},{0,4},{3}};
        int res = sol.catMouseGame(graph);
        System.out.println(res);
    }

}
