package com.jtarun.practice.cognite;

public class Cognite {

    private static final int[][] dirs = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1,0}, {-1, 1}};

    static int gameOfLife(int[][] board, int n, int m, int i, int j) {

        int liveNeighours = 0;
        for (int[] dir : dirs) {

            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && y >= 0 && x < n && y < m) {
                liveNeighours += board[x][y];
            }
        }

        int res;
        if (liveNeighours < 2 || liveNeighours > 3) {
            res = 0;
        } else {
            res = 1;
            if (board[i][j] == 0 ){
                res = liveNeighours == 3 ? 1 : 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int n = 8, m = 10;
        int[][] board = {
                {1,0,0,0,0,0,0,0,0,0},
                {0,1,1,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
        };

        print(board, n, m);

        for (int k = 1; k <= 10; k++) {
            int[][] boardRes = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    boardRes[i][j] = gameOfLife(board, n, m, i, j);
                }
            }
            board = boardRes;
            System.out.println();
            print(board, n, m);
        }

    }

    private static void print(int[][] board, int n, int m) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(String.valueOf(board[i][j]) + " ");
            }
            System.out.println();
        }

    }

}
