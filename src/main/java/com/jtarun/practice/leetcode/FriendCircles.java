package com.jtarun.practice.leetcode;

/** 547
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive
 * in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend
 * of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1,
 * then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total
 * number of friend circles among all the students.
 */
public class FriendCircles {

    private static class Solution {
        public int findCircleNum(int[][] M) {
            int n = M.length;
            if (n == 0) return 0;

            UF uf = new UF(n);
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if (M[i][j] == 1) uf.union(i, j);
                }
            }

            return uf.count();
        }

        private class UF {
            int[] parent;
            int cnt;

            UF(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) parent[i] = i;
                cnt = n;
            }

            void union(int i, int j) {
                int p1 = find(i);
                int p2 = find(j);
                if (p1 != p2) {
                    cnt--;
                    parent[p1] = p2;
                }
            }

            int find(int i) {
                while (parent[i] != i) {
                    i = parent[i];
                }
                return i;
            }

            int count() {
                return cnt;
            }
        }
    }

}
