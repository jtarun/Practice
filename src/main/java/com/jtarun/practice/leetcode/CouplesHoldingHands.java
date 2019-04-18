package com.jtarun.practice.leetcode;

import java.util.*;

/** 765
 * N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps
 * so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up
 * and switch seats.
 *
 * The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order,
 * the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).
 *
 * The couples' initial seating is given by row[i] being the value of the person who is initially sitting
 * in the i-th seat.
 */
public class CouplesHoldingHands {

    private static class Solution {

        public int minSwapsCouples(int[] row) {
            int n = row.length/2;
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                int c1 = row[2*i]/2;
                int c2 = row[2*i+1]/2;

                if (c1 != c2) uf.union(c1, c2);
            }

            return n - uf.count();
        }

        private class UnionFind {
            int[] parents;
            int count;

            UnionFind(int n) {
                parents = new int[n];
                count = n;
                for (int i = 0; i < n; i++) parents[i] = i;
            }

            void union(int i, int j) {
                int x = find(i);
                int y = find(j);
                if ( x != y) {
                    parents[x] = y;
                    count--;
                }
            }

            int find(int i) {
                List<Integer> path = new ArrayList<>();
                while ( i != parents[i]) {
                    path.add(i);
                    i = parents[i];
                }

                for (int node: path) parents[node] = i;

                return i;
            }

            int count(){
                return count;
            }

        }


        public int minSwapsCouples2(int[] row) {
            Map<Integer, Integer> h = new HashMap<>();
            for (int i = 0; i < row.length; i++) {
                h.put(row[i], i);
            }

            int res = 0;
            for (int i = 0; i < row.length; i += 2) {

                int j = i;
                while (h.get(partner(row[j])) != j+1) {
                    res++;
                    int partner = partner(row[j]);
                    int partnerInd = h.get(partner);

                    int v = row[j+1];
                    row[j+1] = partner;
                    row[partnerInd] = v;

                    h.put(partner, j+1);
                    h.put(v, partnerInd);

                    j = partnerInd;
                    if (j % 2 != 0) j--;
                }
            }

            return res;
        }

        int partner(int x) {
            if (x % 2 == 0) return x+1;
            return x-1;
        }
    }

}
